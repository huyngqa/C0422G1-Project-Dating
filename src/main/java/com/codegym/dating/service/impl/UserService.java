package com.codegym.dating.service.impl;

import com.codegym.dating.config.MailConfig;
import com.codegym.dating.dto.UserDto;
import com.codegym.dating.model.User;
import com.codegym.dating.payload.request.UpdateStatusRequest;
import com.codegym.dating.repository.IUserRepository;
import com.codegym.dating.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Optional;
import java.util.Properties;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;


    @Override
    public Optional<UserDto> findByIdDto(Integer id) {
        return this.iUserRepository.findByIdDto(id);
    }

//    public Page<UserDto> findAllPage(Pageable pageable) {
//        return iUserRepository.getAllPage(pageable);
//    }

    @Override
    public Page<UserDto> userPage(String name, String dateOfBirth, String address, String job, String
            gender, String hobbitName, Pageable pageable) {
        if (gender == "") {
            return iUserRepository.findAllUserAndSearch
                    ("%" + name + "%",
                            dateOfBirth,
                            "%" + address + "%",
                            "%" + job + "%",
                            0,
                            1,
                            "%" + hobbitName + "%",
                            pageable);
        } else if (gender.equals("0")) {
            return iUserRepository.findAllUserAndSearch
                    ("%" + name + "%",
                            dateOfBirth,
                            "%" + address + "%",
                            "%" + job + "%",
                            0,
                            0,
                            "%" + hobbitName + "%",
                            pageable);
        } else {
            return iUserRepository.findAllUserAndSearch
                    ("%" + name + "%",
                            dateOfBirth,
                            "%" + address + "%",
                            "%" + job + "%",
                            1,
                            1,
                            "%" + hobbitName + "%",
                            pageable);
        }
    }

    @Override
    public Page<UserDto> findAllSearchPage(Pageable pageable, String name) {
        return iUserRepository.getAllSearchPage(pageable, '%' + name + '%');
    }

    @Override
    public User findUserById(Integer id) {
        return iUserRepository.findByIdNativeQuery(id);
//        return iUserRepository.getAllSearchPage(pageable, '%' + name + '%');
    }

    @Override
    public void updateCoin(Integer coin, Integer idUser) {
        iUserRepository.updateCoin(coin, idUser);
    }

    @Override
    public void updateTypeUser(Integer coin, Integer idUser) {
        Integer idTypeUser = 0;
        if (coin >= 0 && coin < 100) {
            idTypeUser = 1;
        } else if (coin >= 100 && coin < 1000) {
            idTypeUser = 2;
        } else if (coin >= 1000 && coin < 5000) {
            idTypeUser = 3;
        } else if (coin >= 5000) {
            idTypeUser = 4;
        }
        this.iUserRepository.updateTypeUser(idTypeUser, idUser);
    }

    @Override
    public Page<UserDto> findAllPage(Pageable pageable) {
//        return iUserRepository.getAllSearchPage(pageable);
        return null;
    }

    @Override
    public List<UserDto> findAllSearch(String name) {
        return iUserRepository.getAllSearch(name);
    }

    @Override
    public Page<User> findAll(String name, Pageable pageable) {
        return iUserRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Page<User> findByTypeUser(String name, String typeUser, Pageable pageable) {
        return iUserRepository.findByTypeUser(name, typeUser, pageable);
    }

    @Override
    public Optional<User> findByIdUser(int id) {
        return iUserRepository.findById(id);
    }

    @Override
    public void updateWarningUser(UpdateStatusRequest updateStatusRequest) {
        Optional<User> userOpt = this.findByIdUser(updateStatusRequest.getIdUser());
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.getAccount().setStatus(updateStatusRequest.getStatus());
            iUserRepository.save(user);

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", MailConfig.HOST_NAME);
            props.put("mail.smtp.socketFactory.port", MailConfig.SSL_PORT);
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.port", MailConfig.SSL_PORT);

            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(MailConfig.APP_EMAIL, MailConfig.APP_PASSWORD);
                }
            });

            Message message = new MimeMessage(session);
            try{
                message.setFrom(new InternetAddress(MailConfig.APP_EMAIL));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getAccount().getEmail()));
                message.setSubject("Cảnh cáo thành viên");

                Multipart multipart = new MimeMultipart();
                MimeBodyPart textBodyPart = new MimeBodyPart();
                String htmlContent = "<div style=\"width: 500px;height: 400px; background-color: #d4cfcc; margin: 0 auto;border-radius: 5px;padding: 10px\" >\n" +
                        "    <h4>Kính gửi quý khách!</h4>\n" +
                        "    <p>Gần đây chúng tôi nhận được nhiều phản ánh từ hệ thống tố cáo tài khoản sử dụng của bạn vi phạm điều lệ của trang web nhiều lần\n" +
                        "      .Qua xác minh chúng tôi quyết định khóa account theo thời gian quy định\n" +
                        "      Nếu bạn có bất kì khiếu nại gì thì vui lòng liên hệ đội ngũ suport để xử lý</p>\n" +
                        "    <p>Mail suport: <span style=\"color: #1943c2\">tuannc1004@gmail.com</span></p>\n" +
                        "    <p>Phone: <span style=\"color: #1943c2\">0344848457</span></p>\n" +
                        "    <p>Website: <link style=\"color: #1943c2\" href=\"\" style=\"color: #e3274c\">webdaiting.com</p><br>\n" +
                        "    <span>Trân trọng!</span>\n" +
                        "    <h4>Đội ngũ Webdaiting</h4>\n" +
                        "  </div>";
                textBodyPart.setContent(htmlContent, "text/html;charset=UTF-8");

                multipart.addBodyPart(textBodyPart);

                message.setContent(multipart);

                Transport.send(message);
                System.out.println("sending");
            }catch(MessagingException ex) {
                ex.printStackTrace();
                System.out.println("send Errors!!!!!!");
            }
        }
    }
}

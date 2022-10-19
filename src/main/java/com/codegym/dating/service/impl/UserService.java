package com.codegym.dating.service.impl;

import com.codegym.dating.config.MailConfig;
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

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

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
                String htmlContent = "<h1>Dear anh/chị</h1>\n" +
                        "<p>Gàn đây chúng tôi nhận được nhiều tố cáo về việc tài khoản vi phạm quy định của trang web</p>\n" +
                        "<p>Chúng tôi xem xét và đưa ra quết định khóa account của quý khách.</p>\n" +
                        "<p>Nếu quý khách cảm thấy không hài lòng có thể khiếu nại tới</p><a href=\"abc.com\"></a>\n" +
                        "<h3 style=\"color:green\">Mr.Tuan</h3>\"\n" +
                        "<b>Phone number:</b><span>0971450138</span>\";";
                textBodyPart.setContent(htmlContent, "text/html");

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

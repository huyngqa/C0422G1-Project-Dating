package com.codegym.dating.repository;

import com.codegym.dating.model.Hobbit;
import com.codegym.dating.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Transactional
public interface IUserRepository extends JpaRepository<User, Integer> {
    @Query(nativeQuery = true,
            value = "SELECT c.* " +
            "FROM user as c " +
            "LEFT JOIN user_has_hobbit as uhh " +
            "ON c.id_user = uhh.id_user " +
            "LEFT JOIN hobbit as h " +
            "ON uhh.id_hobbit = h.id_hobbit " +
            "WHERE " +
            "c.name like ?1 " +
            "AND year(c.date_of_birth) >= ?2 " +
            "AND c.address LIKE ?3 " +
            "AND c.job LIKE ?4 " +
            "AND c.gender like ?5 " +
            "AND h.hobbit_name Like ?6 " +
            "GROUP BY c.id_user ",
            countQuery = "SELECT c.* " +
                    "FROM user as c " +
                    "LEFT JOIN user_has_hobbit as uhh " +
                    "ON c.id_user = uhh.id_user " +
                    "LEFT JOIN hobbit as h " +
                    "ON uhh.id_hobbit = h.id_hobbit " +
                    "WHERE " +
                    "c.name like ?1 " +
                    "AND year(c.date_of_birth) >= ?2 " +
                    "AND c.address LIKE ?3 " +
                    "AND c.job LIKE ?4 " +
                    "AND c.gender like ?5 " +
                    "AND h.hobbit_name Like ?6 " +
                    "GROUP BY c.id_user ")
    public Page<User> searchAll(String name,
                         String dateOfBirth,
                         String address,
                         String job,
                         String gender,
                         String hobbit,
                         Pageable pageable);
}

package com.lld.splitwise.repositories;

import com.lld.splitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findUserByUsernameContainsAndAndPhoneNumberIs(String username, String phoneNumber);

    /**
     * If user has id that already exists, it will update.
     * else it will create a new user
     * @param user
     * @return
     */
    User save(User user);

    User findUserById(Long id);
}

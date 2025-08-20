/* CodingNomads (C)2024 */
package com.codingnomads.springsecurity.authorization.custompermissions.services;

import com.codingnomads.springsecurity.authorization.custompermissions.models.User;
import com.codingnomads.springsecurity.authorization.custompermissions.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public User updateByEmail(String currentEmail, String newEmail) {
        System.out.println("Looking for user with email: " + currentEmail);
        User user = userRepository.findByEmail(currentEmail);

        if (user != null) {
            System.out.println("Found user, changing email from " + user.getEmail() + " to " + newEmail);
            user.setEmail(newEmail);
            User savedUser = userRepository.save(user);
            System.out.println("User saved with new email: " + savedUser.getEmail());
            return savedUser;
        }
        System.out.println("User not found!");
        throw new RuntimeException("User not found with email: " + currentEmail);
    }

}

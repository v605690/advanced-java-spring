/* CodingNomads (C)2024 */
package com.codingnomads.springsecurity.authorization.custompermissions.services;

import com.codingnomads.springsecurity.authorization.custompermissions.models.User;
import com.codingnomads.springsecurity.authorization.custompermissions.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public User updateByEmail(String email) {
        User user = userRepository.findByEmail(email);

        if (user != null) {
            user.setEmail(email);
        return userRepository.save(user);
        }
        return null;
    }
}

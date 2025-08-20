/* CodingNomads (C)2024 */
package com.codingnomads.springsecurity.authorization.custompermissions.controllers;

import com.codingnomads.springsecurity.authorization.custompermissions.models.User;
import com.codingnomads.springsecurity.authorization.custompermissions.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String home() {
        return "permissions";
    }

    @GetMapping("/user")
    @ResponseBody
    @PostAuthorize("hasPermission(returnObject, 'READ')")
    public User getEntityById(@RequestParam String email) {
        return userService.getUser(email);
    }

    @GetMapping("/user/delete/{id}")
    @ResponseBody
    @PreAuthorize(
            "hasPermission(#id, 'com.codingnomads.springsecurity.authorization.custompermissions.models.User', 'DELETE')")
    public String deleteEntity(@PathVariable Long id) {
        userService.deleteUser(id);
        return ("deleted user with id: " + id);
    }

    @GetMapping("/user1/{email}")
    @ResponseBody
    @PostAuthorize(
            "hasPermission(#email, 'com.codingnomads.springsecurity.authorization.custompermissions.models.User', 'READ')")
    public String readEntity(@PathVariable String email) {
        userService.getUser("user1@email.com");
        return ("retrieve email address of id: " + email);
    }

    @PatchMapping("/home")
    @ResponseBody
    @PreAuthorize(
            "hasPermission(#email, 'com.codingnomads.springsecurity.authorization.custompermissions.models.User', 'UPDATE')")
    public User updateEmail(@RequestParam String email) {
        return userService.updateByEmail(email);
    }
}

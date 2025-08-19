/* CodingNomads (C)2024 */
package com.codingnomads.springsecurity.authorization.addingauthorization.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@EnableMethodSecurity
public class HomeController {

    @ModelAttribute
    public void addUserInfo(HttpServletRequest request, Model model) {
        model.addAttribute("remoteUser", request.getRemoteUser());
    }

    @GetMapping("/")
    public String homePage() {
        return "authorization/home";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "authorization/admin";
    }

    @GetMapping("/superu")
    public String superUPage() {
        return "authorization/superu";
    }

    @GetMapping("/mas")
    @PreAuthorize("#id != 1")
    public String testMas(int id) {
        return "authorization/home";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/hr")
    public String hrPage() {
        return "authorization/hr";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/resources")
    public String resourcePage() {
        return "authorization/resources";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "authorization/about";
    }



    /*
       Method Security Annotations

       @RolesAllowed("ROLE_USER")
       @PreAuthorize("#id != 1")
       @PostAuthorize("returnObject.ownerUsername == authentication.principal.username")
       @PreFilter(value = "filterObject != shutdown", filterTarget = "commands")
       @PostFilter("filterObject.id <= 20")
    */
}

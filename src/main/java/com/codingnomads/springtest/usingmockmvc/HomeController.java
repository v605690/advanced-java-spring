/* CodingNomads (C)2024 */
package com.codingnomads.springtest.usingmockmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/")
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Bobbert");
        return "greeting";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String greet() {
        return "Hello Back";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "This is a path test";
    }

    @GetMapping("/path")
    public String test2(Model model) {
        model.addAttribute("path", "Index path test");
        return "greeting";
    }

    @GetMapping("/user")
    @ResponseBody
    public String test3() {
        return "New user added";
    }
}

package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")//도메인 첫번째 localhost:8080/
    public String home() {
        return "home";
    }
}

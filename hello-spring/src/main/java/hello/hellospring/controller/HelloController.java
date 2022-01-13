package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("hello")//hello 링크를 눌렀을 때 아래 메소드 실행
    public String hello(Model model){
        model.addAttribute("data","hello!");//data 변수에 삽입
        return "hello";//hello.html
    }

    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam("name") String name, Model model){//model에 담으면 view에서 렌더링할 때 씀
        model.addAttribute("name",name);//key,name
        return "hello-template";
    }

}

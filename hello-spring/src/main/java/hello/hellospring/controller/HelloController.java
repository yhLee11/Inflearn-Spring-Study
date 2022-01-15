package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")//hello 링크를 눌렀을 때 아래 메소드 실행
    public String hello(Model model) {
        model.addAttribute("data", "hello!");//data 변수에 삽입
        return "hello";//hello.html
    }

    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam(value = "name") String name, Model model) {//model에 담으면 view에서 렌더링할 때 씀
        model.addAttribute("name", name);//key,name
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody//http에서 header,body에서 body부에 "hello "+name을 직접 넣어주겠다
    public String helloString(@RequestParam("name") String name){
        return "hello "+name;//"hello spring", 요청한 클라이언트에 그대로 전달
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;//객체를 넘김
    }
    static class Hello{
        private String name;
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name=name;
        }
    }
}
    
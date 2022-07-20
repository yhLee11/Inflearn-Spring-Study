package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRespository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRespository memberRespository = MemberRespository.getInstance();

//    @RequestMapping(value = "/new-form",method = RequestMethod.GET)
    @GetMapping("/new-form")
    public String newForm(){
        return "new-form";
    }

    @GetMapping()
    public String members(Model model) {
        List<Member> members = memberRespository.findAll();

        model.addAttribute("members", members);
        return "members";
    }

    @PostMapping("/save")
    public String save(@RequestParam("username") String username, @RequestParam("age") int age, Model model){

        Member member = new Member(username, age);
        memberRespository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }
}

package hello.springmvc.basic.requestMapping;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {
    /**
     * 회원 목록 조회: GET
     * 회원 등록: POST
     * 회원 조회: GET
     * 회원수정: PATCH /users/{userId}
     * 회원 삭제: DELETE /users/{userId}
     */
    @GetMapping
    public String user() {
        return "get users";
    }

    @PostMapping
    public String addUser() {
        return "post user";
    }

    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId) {
        return "get userId=" + userId;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "delete userId=" + userId;
    }

}

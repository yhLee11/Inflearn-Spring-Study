package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){//메서드가 끝날 때마다 실행되는 메서드: 콜백메서드
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        //검증1
        System.out.println("result = "+(result==member));
        //검증2
        Assertions.assertEquals(member,result);
        //다를 경우
        //Assertions.assertEquals(member,null);
        //검증3
    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();//shift+f6: rename
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();//get()을 쓰면 Optional을 한번 까는 것
        Assertions.assertEquals(member1,result);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        Assertions.assertEquals(result.size(),2);
    }
}

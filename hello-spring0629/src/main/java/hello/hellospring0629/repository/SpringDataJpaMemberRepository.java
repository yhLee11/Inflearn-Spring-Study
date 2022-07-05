package hello.hellospring0629.repository;

import hello.hellospring0629.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>,MemberRepository {//인터페이스가 인터페이스를 받는 경우 extends
    @Override
    Optional<Member> findByName(String name);
}

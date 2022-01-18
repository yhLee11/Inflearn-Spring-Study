package hello.hellospring.repository;
import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);//저장소에 저장

    Optional<Member> findById(Long id);//저장소에서 id 찾아오기

    Optional<Member> findByName(String name);

    List<Member> findAll();
}
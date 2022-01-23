package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();//메모리 저장소
    private static long sequence = 0L;


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));//값이 null이어도 가능
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() //loop로 돌림
                    .filter(member -> member.getName().equals(name))//lambda 사용, 파라메타 name이 member의 name과 같은지 확인, 같은 경우에만 filter
                    .findAny();//필터링 된 데이터 중 찾으면 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());//member들이 반환됨
    }

    public void clearStore(){
        store.clear();
    }
}
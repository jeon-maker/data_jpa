package study.datajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.Member;

@SpringBootTest
@Transactional
@Rollback(false)
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void testMember(){
        Member member = new Member();
        member.setUsername("memberA");

        Member savedMember = memberRepository.save(member);


        Member findMember = memberRepository.findById(savedMember.getId()).get();

        System.out.println("savedMember = " + savedMember);
        System.out.println("findMember = " + findMember);
    }
}

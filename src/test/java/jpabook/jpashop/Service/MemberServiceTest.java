package jpabook.jpashop.Service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @DisplayName("회원가입")
    @Test
    public void signUp() throws Exception {
        //given
        Member member = new Member();
        member.setName("이호진");

        //when
        Long savedId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne(savedId));
    }

    @DisplayName("유효성 검사")
    @Test
    public void duplicateMember() throws Exception {
        //given
        Member member = new Member();
        member.setName("감자");

        Member member1 = new Member();
        member1.setName("감자");

        //when

        assertThrows(IllegalStateException.class, () -> {
            memberService.join(member);
            memberService.join(member1);
        });

        //then
//        fail("에러가 발생해야함.");
    }
}
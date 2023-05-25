package com.ll.tag.app.base.initData;

import com.ll.tag.app.member.entity.Member;
import com.ll.tag.app.member.entity.emum.AuthLevel;
import com.ll.tag.app.member.repository.MemberRepository;
import com.ll.tag.app.member.service.MemberService;

import java.util.Arrays;
import java.util.List;

public interface InitDataBefore {
    default void before(
            MemberRepository memberRepository,
            MemberService memberService) {

        Member member1 = memberService.join("user1", "1234", "user1@test.com", "");
        member1.setAuthLevel(AuthLevel.ADMIN);
        memberRepository.save(member1);
        Member member2 = memberService.join("user2", "1234", "user2@test.com", "user2");
    }
}

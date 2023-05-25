package com.ll.tag.app.base.initData;

import com.ll.tag.app.member.repository.MemberRepository;
import com.ll.tag.app.member.service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevInitData implements InitDataBefore {
    @Bean
    CommandLineRunner initData(
            MemberRepository memberRepository,
            MemberService memberService
    ) {
        return args -> {
            before(memberRepository, memberService);
        };
    }
}
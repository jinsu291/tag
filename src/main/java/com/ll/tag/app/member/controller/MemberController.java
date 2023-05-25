package com.ll.tag.app.member.controller;

import com.ll.tag.app.member.service.MemberService;
import com.ll.tag.app.member.form.MemberForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @PreAuthorize("isAnonymous()")
    @GetMapping("/join")
    public String showJoin() {
        return "member/join";
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping("/join")
    public String join(@Valid MemberForm memberForm) {
        memberService.join(memberForm.getUsername(), memberForm.getPassword(), memberForm.getEmail(), memberForm.getNickname());
        return "redirect:/member/login";
    }
}
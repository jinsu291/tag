package com.ll.tag.app.member.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MemberForm {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String email;
    private String nickname;
}

package com.ll.tag.member.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ll.tag.base.entity.BaseEntity;
import com.ll.tag.member.entity.emum.AuthLevel;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Member extends BaseEntity {
    @Column(unique = true)
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private String nickname;
    private boolean emailVerified;

    @Convert(converter = AuthLevel.Converter.class)
    private AuthLevel authLevel;

    public String getName() {
        if (nickname != null) {
            return nickname;
        }

        return username;
    }

    public Member(long id) {
        super(id);
    }

    public List<GrantedAuthority> genAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("MEMBER"));

        if (getAuthLevel() == AuthLevel.MANAGER) {
            authorities.add(new SimpleGrantedAuthority("MANAGER"));
        }

        if (getAuthLevel() == AuthLevel.ADMIN) {
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
        }

        return authorities;
    }
}
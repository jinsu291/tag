package com.ll.tag.app.member.entity.emum;

import com.ll.tag.app.member.exception.NotMatchAuthLevelException;
import lombok.Getter;

import javax.persistence.AttributeConverter;
import java.util.EnumSet;

@Getter
public enum AuthLevel {
    NORMAL(3, "NORMAL"),
    MANAGER(5, "MANAGER"),
    ADMIN(7, "ADMIN");

    AuthLevel(int code, String value) {
        this.code = code;
        this.value = value;
    }

    private int code;
    private String value;

    public static class Converter implements AttributeConverter<AuthLevel, Integer> {
        @Override
        public Integer convertToDatabaseColumn(AuthLevel attribute) {
            return attribute.getCode();
        }

        @Override
        public AuthLevel convertToEntityAttribute(Integer dbData) {
            return EnumSet.allOf(AuthLevel.class).stream()
                    .filter(e -> e.getCode() == dbData)
                    .findAny()
                    .orElseThrow(NotMatchAuthLevelException::new);
        }
    }
}

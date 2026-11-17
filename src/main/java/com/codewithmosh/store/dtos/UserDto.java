package com.codewithmosh.store.dtos;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//
//@AllArgsConstructor
//@Getter
//public class UserDto {
//    private Long id;
//    private String name;
//    private String email;
//}

import java.time.LocalDateTime;

public record UserDto(
        Long id,
        String name,
        String email
) {}

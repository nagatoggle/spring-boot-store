package com.codewithmosh.store.users;

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

public record UserDto(
        Long id,
        String name,
        String email
) {}

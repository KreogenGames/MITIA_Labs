package ru.mirea.mitia.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {

    private UUID id;
    private String lastName;
    private String firstName;
    private String email;
    private String country;
    private String gender;
}

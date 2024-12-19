package ru.mirea.mitia.model;

import lombok.Data;

import java.util.UUID;

@Data
public class UserModel {

    private UUID id;
    private String lastName;
    private String firstName;
    private String email;
    private String country;
    private String gender;
}

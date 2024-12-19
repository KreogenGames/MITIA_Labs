package ru.mirea.mitia.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Schema(description = "Создание пользователя")
public class UserCreateModel {

    @Schema(description = "Фамилия")
    @NotEmpty(message = "Фамилия пользователя обязательное поле")
    @Size(max = 100, message = "Длина фамилии пользователя максимум 100 символов")
    private String lastName;

    @Schema(description = "Имя")
    @NotEmpty(message = "Имя пользователя обязательное поле")
    @Size(max = 100, message = "Длина имени пользователя максимум 100 символов")
    private String firstName;

    @Schema(description = "Адрес электронной почты")
    @NotEmpty(message = "Адрес электронной почты обязательное поле")
    @Size(max = 100, message = "Длина адреса электронной почты максимум 100 символов")
    private String email;

    @Schema(description = "Страна проживания")
    @Size(max = 100, message = "Длина названия страны проживания пользователя максимум 100 символов")
    private String country;

    @Schema(description = "Пол")
    @Size(max = 7)
    private String gender;
}

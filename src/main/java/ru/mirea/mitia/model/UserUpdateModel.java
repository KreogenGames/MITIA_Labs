package ru.mirea.mitia.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
@Schema(description = "Обновление пользователя")
public class UserUpdateModel {

    @Schema(description = "Фамилия")
    @Size(max = 100, message = "Длина фамилии пользователя максимум 100 символов")
    private String lastName;

    @Schema(description = "Имя")
    @Size(max = 100, message = "Длина имени пользователя максимум 100 символов")
    private String firstName;

    @Schema(description = "Адрес электронной почты")
    @Size(max = 100, message = "Длина адреса электронной почты максимум 100 символов")
    private String email;

    @Schema(description = "Страна проживания")
    @Size(max = 100, message = "Длина названия страны проживания пользователя максимум 100 символов")
    private String country;

    @Schema(description = "Пол")
    @Size(max = 7)
    private String gender;
}

package ru.mirea.mitia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mirea.mitia.mapper.UserMapper;
import ru.mirea.mitia.model.UserCreateModel;
import ru.mirea.mitia.model.UserModel;
import ru.mirea.mitia.model.UserUpdateModel;
import ru.mirea.mitia.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping({"client", ""})
public class ClientController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/") //Ручка для перенапраления на главную страницу
    public String redirectToUsers() {
        return "redirect:/client/users";
    }

    @GetMapping("/users") //Ручка для отображения списка пользователей
    public String getAllUserData(Model model) {
        List<UserModel> users = userMapper.toModels(userService.getAllUsers());
        model.addAttribute("users", users);
        return "users"; //Возврат шаблона users.html
    }

    @GetMapping("/users/create") //Ручка для отображения формы создания пользователя
    public String showCreateUserForm(Model model) {
        model.addAttribute("userCreateModel", new UserCreateModel());
        return "users-create"; //Возврат шаблона users-create.html
    }

    @PostMapping("/users") //Ручка для исполнения логики по созданию пользователя
    public String createUser (@ModelAttribute("userCreateModel") @Valid UserCreateModel userCreateModel,
                              BindingResult bindingResult,
                              Model model) {
        if (bindingResult.hasErrors()) {
            return "users-create"; // возвращаем форму с ошибками
        }

        var user = userService.createUser(userMapper.toDto(userCreateModel));

        model.addAttribute("user", user);

        // Перенаправление на список пользователей после успешного создания
        return "redirect:/client/users";
    }

    @GetMapping("/users/edit/{id}") //Ручка для отображения формы изменения пользователя
    public String userEditForm(@PathVariable UUID id, Model model) {
        var user = userMapper.toModel(userService.getUser(id));

        model.addAttribute("user", user);
        return "users-edit"; //Возврат шаблона users-edit.html
    }

    @PostMapping("/users/{id}") //Ручка для исполнения логики по изменению пользователя
    public String updateUser(@PathVariable UUID id,
                             @ModelAttribute("userUpdateModel") @Valid UserUpdateModel userUpdateModel) {
        userService.updateUser(id, userMapper.toDto(userUpdateModel));

        // Перенаправление на список пользователей после успешного изменения
        return "redirect:/client/users";
    }

    @PostMapping("/users/delete/{id}") //Ручка для исполнения логики по удалению пользователя
    public String deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);

        // Перенаправление на список пользователей после успешного удаления
        return "redirect:/client/users";
    }
}

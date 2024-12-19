package ru.mirea.mitia.mapper;

import org.mapstruct.Mapper;
import ru.mirea.mitia.dto.UserDto;
import ru.mirea.mitia.entity.UserEntity;
import ru.mirea.mitia.model.UserCreateModel;
import ru.mirea.mitia.model.UserModel;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toEntity(UserDto dto);

    UserDto toDto(UserEntity entity);

    UserDto toDto(UserCreateModel model);

    UserModel toModel(UserDto dto);
}

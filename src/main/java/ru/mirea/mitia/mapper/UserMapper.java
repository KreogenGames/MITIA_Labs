package ru.mirea.mitia.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.mirea.mitia.dto.UserDto;
import ru.mirea.mitia.entity.UserEntity;
import ru.mirea.mitia.model.UserCreateModel;
import ru.mirea.mitia.model.UserModel;
import ru.mirea.mitia.model.UserUpdateModel;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toEntity(UserDto dto);

    UserDto toDto(UserEntity entity);

    UserDto toDto(UserCreateModel model);

    UserDto toDto(UserUpdateModel model);

    UserModel toModel(UserDto dto);

    List<UserDto> toDtos(List<UserEntity> entities);

    List<UserModel> toModels(List<UserDto> dtos);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(UserDto dto, @MappingTarget UserEntity user);
}

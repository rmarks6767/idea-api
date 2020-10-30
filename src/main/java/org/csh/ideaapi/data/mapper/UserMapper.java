package org.csh.ideaapi.data.mapper;

import org.csh.ideaapi.data.dto.User;
import org.csh.ideaapi.data.entity.UserEntity;
import org.mapstruct.*;

@Mapper(
    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    uses = {
        IdeaMapper.class
    }
)
public interface UserMapper  {

    @Mappings({
            @Mapping(target = "id", source = "userEntity.userId")
    })
    User userDTOtoUser(UserEntity userEntity);

    @Mappings({
            @Mapping(target = "userId", source = "user.id")
    })
    UserEntity userToUserDTO(User user);
}

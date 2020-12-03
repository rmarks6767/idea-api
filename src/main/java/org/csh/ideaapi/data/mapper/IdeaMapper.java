package org.csh.ideaapi.data.mapper;

import org.csh.ideaapi.data.dto.Idea;
import org.csh.ideaapi.data.entity.IdeaEntity;
import org.mapstruct.*;

@Mapper(
    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    uses = {
        MemberMapper.class
    }
)
public interface IdeaMapper  {

    @Mapping(target = "id", source = "ideaEntity.ideaId")
    Idea ideaDTOtoIdea(IdeaEntity ideaEntity);

    @Mapping(target = "ideaId", source = "idea.id")
    IdeaEntity ideaToIdeaDTO(Idea idea);
}

package org.csh.ideaapi.data.mapper;

import org.csh.ideaapi.data.dto.Member;
import org.csh.ideaapi.data.entity.MemberEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
    componentModel="spring",
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface MemberMapper {
    @Mappings({
            @Mapping(target = "id", source = "memberEntity.memberId")
    })
    Member memberDTOtoMember(MemberEntity memberEntity);

    @Mappings({
            @Mapping(target = "memberId", source = "member.id")
    })
    MemberEntity memberToMemberDTO(Member member);
}

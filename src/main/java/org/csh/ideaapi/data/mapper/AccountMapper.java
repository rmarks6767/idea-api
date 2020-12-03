package org.csh.ideaapi.data.mapper;

import org.csh.ideaapi.data.dto.Account;
import org.csh.ideaapi.data.entity.AccountEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(
    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    uses = {
        IdeaMapper.class
    }
)
public interface AccountMapper {

    @Mapping(target = "id", source = "accountEntity.accountId")
    Account accountDTOtoAccount(AccountEntity accountEntity);

    @Mapping(target = "accountId", source = "account.id")
    AccountEntity accountToAccountDTO(Account account);
}

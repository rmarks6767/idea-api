package org.csh.ideaapi.data.dao;

import org.csh.ideaapi.data.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    AccountEntity findByUsernameAndPassword(String username, String password);
}

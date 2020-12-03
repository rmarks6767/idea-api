package org.csh.ideaapi.data.dao;

import org.csh.ideaapi.data.entity.IdeaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdeaRepository extends JpaRepository<IdeaEntity, Long> {
    List<IdeaEntity> findAllByOwnerAccountId(Long accountId);
}

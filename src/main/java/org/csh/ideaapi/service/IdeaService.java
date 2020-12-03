package org.csh.ideaapi.service;

import org.csh.ideaapi.data.dao.AccountRepository;
import org.csh.ideaapi.data.dao.IdeaRepository;
import org.csh.ideaapi.data.dto.Idea;
import org.csh.ideaapi.data.entity.AccountEntity;
import org.csh.ideaapi.data.entity.IdeaEntity;
import org.csh.ideaapi.data.mapper.IdeaMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IdeaService {

    IdeaRepository ideaRepository;
    AccountRepository accountRepository;

    @Autowired
    public IdeaService(IdeaRepository ideaRepository, AccountRepository accountRepository) {
        this.ideaRepository = ideaRepository;
        this.accountRepository = accountRepository;
    }

    public List<Idea> getAllIdeas() {
        IdeaMapper mapper = Mappers.getMapper(IdeaMapper.class);
        List<Idea> ideas = new ArrayList<>();

        ideaRepository.findAll().forEach(idea -> ideas.add(mapper.ideaDTOtoIdea(idea)));

        return ideas;
    }

    public List<Idea> getIdeas(Long accountId) {
        IdeaMapper mapper = Mappers.getMapper(IdeaMapper.class);
        List<Idea> ideas = new ArrayList<>();

        ideaRepository.findAllByOwnerAccountId(accountId).forEach(idea -> ideas.add(mapper.ideaDTOtoIdea(idea)));

        return ideas;
    }

    public Idea getIdea(Long ideaId) {
        IdeaMapper mapper = Mappers.getMapper(IdeaMapper.class);

        return mapper.ideaDTOtoIdea(ideaRepository.getOne(ideaId));
    }

    public Idea createIdea(Long accountId, Idea idea) {
        IdeaMapper mapper = Mappers.getMapper(IdeaMapper.class);
        IdeaEntity ideaEntity = mapper.ideaToIdeaDTO(idea);
        AccountEntity account = accountRepository.getOne(accountId);

        account.addIdea(ideaEntity);
        accountRepository.save(account);

        return mapper.ideaDTOtoIdea(ideaEntity);
    }

}

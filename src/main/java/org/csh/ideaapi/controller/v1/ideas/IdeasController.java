package org.csh.ideaapi.controller.v1.ideas;

import org.csh.ideaapi.data.dto.Idea;
import org.csh.ideaapi.service.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ideas")
public class IdeasController {

    @Autowired
    IdeaService service;

    @GetMapping
    public List<Idea> allIdeas() {
        return service.getAllIdeas();
    }

    @GetMapping("/{accountId}") // TODO: Pagination is a later thing lmao
    public List<Idea> ideas(@PathVariable(name = "accountId") Long accountId) {
        return service.getIdeas(accountId);
    }

    @PostMapping("/{accountId}")
    public Idea createIdea(@PathVariable(name = "accountId") Long accountId, @RequestBody Idea idea) {
        return service.createIdea(accountId, idea);
    }

}

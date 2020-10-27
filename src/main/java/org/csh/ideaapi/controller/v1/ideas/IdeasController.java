package org.csh.ideaapi.controller.v1.ideas;

import org.csh.ideaapi.data.model.Idea;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/ideas")
public class IdeasController {

    @GetMapping
    public List<Idea> ideas() {
        return new ArrayList<>() {{
            add(new Idea());
            add(new Idea());
            add(new Idea());
        }};
    }
}

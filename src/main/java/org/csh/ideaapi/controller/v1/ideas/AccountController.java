package org.csh.ideaapi.controller.v1.ideas;

import org.csh.ideaapi.data.dto.Account;
import org.csh.ideaapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/account")
public class AccountController {

    @Autowired
    AccountService service;

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return service.createAccount(account);
    }

    @GetMapping("/{username}/{password}")
    public Account login(@PathVariable(name = "username") String username, @PathVariable(name = "password") String password) {
        return service.login(username, password);
    }

}

package org.csh.ideaapi.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {

    private Long id;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    private String firstName;
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    private String lastName;
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    private String email;
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    private String username;
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    private String password;
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    private List<Idea> ideas;

    public List<Idea> getIdeas() { return ideas; }
    public void setIdeas(List<Idea> ideas) {
        this.ideas = new ArrayList<>();

        if (ideas != null)
            this.ideas.addAll(ideas);
    }
    public void addIdea(Idea idea) {
        if (ideas == null)
            ideas = new ArrayList<>();
        ideas.add(idea);
    }

}

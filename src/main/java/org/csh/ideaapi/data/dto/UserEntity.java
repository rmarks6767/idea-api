package org.csh.ideaapi.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column("user_id")
    private Long userId;
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    @Column("first_name")
    private String firstName;
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    @Column("last_name")
    private String lastName;
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    @Column("email")
    private String email;
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Column("username")
    private String username;
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    @Column("password")
    private String password;
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("user")
    private List<IdeaEntity> ideas;

    public List<IdeaEntity> getIdeas() { return ideas; }
    public void setIdeas(List<IdeaEntity> ideas) {
        this.ideas = new ArrayList<>();

        if (ideas != null) {
            for (IdeaEntity idea : ideas) {
                idea.
                this.ideas.add(idea);
            }
        }
    }
    public void addIdea(IdeaEntity idea) {

    }
}


//    CREATE TABLE users (
//      id BIGINT NOT NULL AUTO_INCREMENT,
//      first_name varchar(255) NOT NULL,
//      last_name varchar(255) NOT NULL,
//      email varchar(255) NOT NULL,
//      username varchar(255) NOT NULL,
//      password varchar(255) NOT NULL,
//      PRIMARY KEY (id)
//    );
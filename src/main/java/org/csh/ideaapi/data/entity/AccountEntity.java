package org.csh.ideaapi.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
public class AccountEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    public Long getAccountId() { return accountId; }
    public void setAccountId(Long accountId) { this.accountId = accountId; }

    @Column(name = "first_name")
    private String firstName;
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    @Column(name = "last_name")
    private String lastName;
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    private String email;
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    private String username;
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("owner")
    private List<IdeaEntity> ideas;

    public List<IdeaEntity> getIdeas() { return ideas; }
    public void setIdeas(List<IdeaEntity> ideas) {
        this.ideas = new ArrayList<>();

        if (ideas != null) {
            for (IdeaEntity idea : ideas) {
                idea.setOwner(this);
                this.ideas.add(idea);
            }
        }
    }
    public void addIdea(IdeaEntity idea) {
        if (ideas == null) {
            ideas = new ArrayList<>();
        }
        idea.setOwner(this);
        ideas.add(idea);
    }

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MemberEntity member;
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
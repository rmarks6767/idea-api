package org.csh.ideaapi.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "members")
public class MemberEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    public Long getMemberId() { return memberId; }
    public void setMemberId(Long memberId) { this.memberId = memberId; }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idea_id")
    @JsonIgnoreProperties("members")
    private IdeaEntity idea;
    public IdeaEntity getIdea() { return idea; }
    public void setIdea(IdeaEntity idea) { this.idea = idea; }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    public UserEntity getUser() { return user; }
    public void setUser(UserEntity user) { this.user = user; }

}


//        CREATE TABLE members (
//        id BIGINT NOT NULL AUTO_INCREMENT,
//        idea_id BIGINT,
//        user_id BIGINT,
//        FOREIGN KEY (idea_id)
//        REFERENCES ideas(id)
//        ON DELETE CASCADE,
//        FOREIGN KEY (user_id)
//        REFERENCES users(id)
//        ON DELETE CASCADE,
//        PRIMARY KEY (id)
//        );
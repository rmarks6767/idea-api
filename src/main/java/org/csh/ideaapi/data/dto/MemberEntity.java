package org.csh.ideaapi.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="members")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    public Long getMemberId() { return memberId; }
    public void setMemberId(Long memberId) { this.memberId = memberId; }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn("idea_id")
    @JsonIgnoreProperties("members")
    private IdeaEntity idea;
    public IdeaEntity getIdea() { return idea; }
    public void setIdea(IdeaEntity idea) { this.idea = idea; }

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn("user_id")
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
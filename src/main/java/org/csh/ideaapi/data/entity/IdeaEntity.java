package org.csh.ideaapi.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ideas")
public class IdeaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ideaId;
    public Long getId() { return ideaId; }
    public void setId(Long id) { this.ideaId = id; }

    private String title;
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    private String description;
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }


    private String url;
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    private Boolean hidden;
    public Boolean getHidden() { return hidden; }
    public void setHidden(Boolean hidden) { this.hidden = hidden; }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("ideas")
    private UserEntity owner;
    public UserEntity getOwner() { return owner; }
    public void setOwner(UserEntity owner) { this.owner = owner; }

    @OneToMany(mappedBy = "idea", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("idea")
    private List<MemberEntity> members = new ArrayList<>();
    public List<MemberEntity> getMembers() { return members; }
    public void setMembers(List<MemberEntity> members) {
        this.members = new ArrayList<>();

        if (members != null) {
            for (MemberEntity member : members) {
                member.setIdea(this);
                this.members.add(member);
            }
        }
    }
    public void addMember(MemberEntity member) {
        if (members == null) {
            members = new ArrayList<>();
        }
        member.setIdea(this);
        members.add(member);
    }
}

    //CREATE TABLE ideas (
//        id BIGINT NOT NULL AUTO_INCREMENT,
//        title varchar(255) NOT NULL,
//        description text NOT NULL,
//        url varchar(255),
//        hidden bool DEFAULT false,
//        owner BIGINT,
//        FOREIGN KEY (owner)
//        REFERENCES users(id)
//        ON DELETE CASCADE,
//        PRIMARY KEY (id)
//        );
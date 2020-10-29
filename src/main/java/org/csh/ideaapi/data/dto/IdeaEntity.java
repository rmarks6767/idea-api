package org.csh.ideaapi.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="ideas")
public class IdeaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column("title")
    private String title;

    @Column("description")
    private String description;

    @Column("url")
    private String url;

    @Column("hiddle")
    private Boolean hidden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("ideas")
    private UserEntity user;

    @OneToMany
    private List<MemberEntity> members = new ArrayList<>();

    @Column("hidden")
    private Boolean hidden;

}

    CREATE TABLE ideas (
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
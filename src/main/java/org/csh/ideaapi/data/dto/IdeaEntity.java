package org.csh.ideaapi.data.dto;

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

    @Column("members")
    @OneToMany
    private List<MemberEntity> members = new ArrayList<>();

    @Column("hidden")
    private Boolean hidden;

}

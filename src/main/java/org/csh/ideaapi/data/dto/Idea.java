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
public class Idea implements Serializable {

    private Long id;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    private List<Member> members = new ArrayList<>();
    public List<Member> getMembers() { return members; }
    public void setMembers(List<Member> members) {
        this.members = new ArrayList<>();

        if (members != null)
            this.members.addAll(members);
    }
    public void addMember(Member member) {
        if (members == null)
            members = new ArrayList<>();
        members.add(member);
    }

}

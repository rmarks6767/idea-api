package org.csh.ideaapi.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Idea implements Serializable {

    private Long id;
    private List<Member> members;
    private Boolean hidden;
    
}

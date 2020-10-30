package org.csh.ideaapi.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member implements Serializable {

    private Long id;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

}

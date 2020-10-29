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
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;

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


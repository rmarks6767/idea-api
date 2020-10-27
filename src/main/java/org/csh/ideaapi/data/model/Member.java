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
//
//
//    CREATE TABLE users (
//        id BIGINT NOT NULL AUTO_INCREMENT,
//        first_name varchar(255) NOT NULL,
//    last_name varchar(255) NOT NULL,
//    email varchar(255) NOT NULL,
//    username varchar(255) NOT NULL,
//    password varchar(255) NOT NULL,
//    PRIMARY KEY (id)
//);
//
//        CREATE TABLE ideas (
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
//
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


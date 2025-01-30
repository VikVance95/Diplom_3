package org.example;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

public class UserData {
    private String email;
    private String password;
    private String name;


    public UserData(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
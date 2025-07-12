package com.ascmoda.userservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserUpdateDTO {

    private String name;
    private String password;
    private boolean enabled;
}

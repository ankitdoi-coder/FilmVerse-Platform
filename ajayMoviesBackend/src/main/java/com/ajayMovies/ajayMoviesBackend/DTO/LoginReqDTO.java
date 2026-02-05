package com.ajayMovies.ajayMoviesBackend.DTO;

import lombok.Data;

@Data
public class LoginReqDTO {
    private String email;
    private String password;
}
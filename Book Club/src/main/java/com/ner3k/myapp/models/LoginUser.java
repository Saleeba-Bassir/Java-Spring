package com.ner3k.myapp.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser {
    @NotEmpty(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;
    @NotEmpty(message = "Password must not be empty")
    @Size(min=8,max=128,message="Password must be at least 8 and at most 128 characters")
    private String password;
}

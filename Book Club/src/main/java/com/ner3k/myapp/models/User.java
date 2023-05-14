package com.ner3k.myapp.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Pattern(regexp = "^[a-zA-Z]+$",message = "User Name Contains invalid characters")
    @NotEmpty(message = "Username must not be empty")
    @Size(min=3,max=30,message="Username must be at least 3 and at most 30 characters")
    private String username;
    @NotEmpty(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;
    @NotEmpty(message = "Password must not be empty")
    @Size(min=8,max=128,message="Password must be at least 8 and at most 128 characters")
    private String password;
    @Transient
    @NotEmpty(message = "Confirm password is required")
    @Size(min=8,max=128,message="Confirm password must be at least 8 and at most 128 characters")
    private String confirmPassword;

    @OneToMany(mappedBy = "postedBy",fetch = FetchType.LAZY)
    private List<Book> myBooks;

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}

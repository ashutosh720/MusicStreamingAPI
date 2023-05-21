package com.MCT.MusicStreaming.MusicStreamingAPI.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="admin")
public class Admin {

    @Id
    private String admin_id;

    @NotBlank(message = "firstName is mandatory")
    private String ad_firstName;

    @NotBlank(message = "lastName is mandatory")
    private String ad_lastName;

    @NotBlank(message = "userName is mandatory")
    private String ad_username;

    @NotBlank(message = "email is mandatory")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "please provide valid email")
    private String admin_email;

    @NotBlank(message = "password is mandatory")
    private String ad_password;


}

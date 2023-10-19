package com.geekster.userManagementSystem.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(message = "user id not be a null value")
    private Long userId;
    @NotBlank(message = "name must not be a blank")
    private String userName;
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}",message = "DOB must be in the format of YYYY-MM-DD format")
    private String DOB;
    @Email(message = "invalid email format")
    private String email;

    private String Address;
    @Pattern(regexp = "\\+91\\d{10}",message = "phone number must be in format of +91xxxxxxxxxx format")
    private String phoneNumber;

    private LocalDateTime localDateTime;
}

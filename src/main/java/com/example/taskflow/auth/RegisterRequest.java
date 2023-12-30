package com.example.taskflow.auth;

import com.example.taskflow.entities.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  @NotNull (message = "First name is required")
  @NotBlank (message = "First name is required")
  private String firstname;
  @NotNull (message = "Last name is required")
  @NotBlank (message = "Last name is required")
  private String lastname;
  @NotNull (message = "Email is required")
  @NotBlank (message = "Email is required")
  private String email;
  @NotNull (message = "Password is required")
  @NotBlank (message = "Password is required")
  private String password;
  @NotNull (message = "Role is required")
  @NotBlank (message = "Role is required")
  private Role role;
}

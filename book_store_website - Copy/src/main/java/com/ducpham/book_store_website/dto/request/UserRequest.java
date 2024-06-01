package com.ducpham.book_store_website.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {
    @NotBlank(message = "Username is not correct")
    @Size(min = 8, max = 20, message = "Username is only 8 - 20 characters")
    String username;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$\n", message = "Password is not correct")
    String password;

    @NotBlank(message = "Fullname is not correct")
    String fullname;

    @NotBlank
    @Email(message = "Email is not correct")
    String email;
}

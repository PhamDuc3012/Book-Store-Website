package com.ducpham.book_store_website.service;

import com.ducpham.book_store_website.dto.request.UserRequest;
import com.ducpham.book_store_website.dto.response.AuthResponse;
import com.ducpham.book_store_website.entity.User;
import com.ducpham.book_store_website.entity.Account;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthService {

    PasswordEncoder passwordEncoder;
    UserService userService;
    JwtService jwtService;

    public AuthResponse register(UserRequest request) {
        User user = userService.add(request);
        Account account = new Account(user);
        String token  = jwtService.generateToken(account);
        return AuthResponse.builder()
                .token(token)
                .build();
    }
}

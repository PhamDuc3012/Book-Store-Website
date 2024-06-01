package com.ducpham.book_store_website.controller;

import com.ducpham.book_store_website.dto.request.UserRequest;
import com.ducpham.book_store_website.dto.response.AuthResponse;
import com.ducpham.book_store_website.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("book_store/v1/auth")
public class AuthController {

    AuthService authService;

@PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody UserRequest request) {
        return ResponseEntity.ok().body(authService.register(request));
}

}

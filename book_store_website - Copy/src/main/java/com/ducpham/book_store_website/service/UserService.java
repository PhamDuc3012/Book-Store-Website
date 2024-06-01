package com.ducpham.book_store_website.service;

import com.ducpham.book_store_website.dto.request.UserRequest;
import com.ducpham.book_store_website.entity.User;
import com.ducpham.book_store_website.entity.Account;
import com.ducpham.book_store_website.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService{

    PasswordEncoder passwordEncoder;
    UserRepository userRepository;

    public User add(UserRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .fullname(request.getFullname())
                .build();
        return userRepository.save(user);

    }


}

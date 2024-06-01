package com.ducpham.book_store_website.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseEntity {
    @Column(nullable = false, length = 20)
    String username;

    @Column(nullable = false)
    String password;

    @Column(nullable = false)
    String fullname;

    @Column(nullable = false, length = 30)
    String email;

    String phone;

    String address;

    @Column(name = "verification_code", length = 64)
    String verificationCode;

    boolean enabled;
}

package com.ducpham.book_store_website.mapper;

import com.ducpham.book_store_website.dto.request.UserRequest;
import com.ducpham.book_store_website.entity.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-01T15:03:25+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UserRequest userRequest) {
        if ( userRequest == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.username( userRequest.getUsername() );
        user.password( userRequest.getPassword() );
        user.fullname( userRequest.getFullname() );
        user.email( userRequest.getEmail() );

        return user.build();
    }
}

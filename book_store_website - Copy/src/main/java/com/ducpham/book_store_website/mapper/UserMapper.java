package com.ducpham.book_store_website.mapper;

import com.ducpham.book_store_website.dto.request.UserRequest;
import com.ducpham.book_store_website.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {
    @Mapping(target = "verificationCode", ignore = true)
    @Mapping(target = "phone", ignore = true)
    @Mapping(target = "enabled", ignore = true)
    @Mapping(target = "address", ignore = true)
    User toUser(UserRequest userRequest);
}

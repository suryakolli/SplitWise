package com.lld.splitwise.dtos;

import com.lld.splitwise.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProfileResponseDto {
    private User user;
}

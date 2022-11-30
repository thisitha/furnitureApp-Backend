package com.furnitureapp.ar.users.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserFcmDto {
    private String uid;
    private String fcmId;
}

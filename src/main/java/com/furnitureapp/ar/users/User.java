package com.furnitureapp.ar.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    private String Uid;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String fcmId;
    private String profileImageUrl;
}

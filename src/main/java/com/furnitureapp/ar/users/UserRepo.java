package com.furnitureapp.ar.users;

 
import com.furnitureapp.ar.users.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.*;

public interface UserRepo extends JpaRepository<User,Integer>{
    @Query(value = "SELECT * FROM user Where user_email = ?1 AND user_password = ?2",nativeQuery = true)
    public List<User> findAllUsers(String userEmail, String userPassword);

    @Modifying
    @Query(value = "UPDATE user SET fcm_id = ?1 WHERE uid = ?2" ,nativeQuery = true)
    public Integer updateFCM(String fcmId, String uid);
    

    @Modifying
    @Query(value = "UPDATE user SET user_name = ?1 , user_email = ?2  WHERE uid = ?3" ,nativeQuery = true)
    public Integer updateUserProfile(String userName, String userEmail, String userId);

    @Modifying
    @Query(value = "UPDATE user SET user_password = ?2  WHERE uid = ?1" ,nativeQuery = true)
    public Integer updateUserPassword(String userId ,String newPassword);

    @Query(value = "SELECT * FROM user Where uid = ?1",nativeQuery = true)
    public List<User> getUserFromID(String uid);
}
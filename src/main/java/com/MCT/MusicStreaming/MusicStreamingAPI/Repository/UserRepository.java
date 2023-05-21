package com.MCT.MusicStreaming.MusicStreamingAPI.Repository;

import com.MCT.MusicStreaming.MusicStreamingAPI.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    @Query(value = "Select * from users where username = :username and password = :password", nativeQuery = true)
    public Users findByUsernameAndPassword(String username,String password);

}

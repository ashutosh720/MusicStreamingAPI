package com.MCT.MusicStreaming.MusicStreamingAPI.Repository;

import com.MCT.MusicStreaming.MusicStreamingAPI.Model.Admin;
import com.MCT.MusicStreaming.MusicStreamingAPI.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, String> {

    @Query(value = "Select * from admin where ad_username = :ad_username and ad_password = :ad_password", nativeQuery = true)
    public Admin findByUsernameAndPassword(String ad_username,String ad_password);
}

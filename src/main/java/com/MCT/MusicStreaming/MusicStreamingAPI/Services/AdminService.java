package com.MCT.MusicStreaming.MusicStreamingAPI.Services;

import com.MCT.MusicStreaming.MusicStreamingAPI.Exception.NotFoundException;
import com.MCT.MusicStreaming.MusicStreamingAPI.Model.Admin;
import com.MCT.MusicStreaming.MusicStreamingAPI.Model.Users;
import com.MCT.MusicStreaming.MusicStreamingAPI.Repository.AdminRepository;
import com.MCT.MusicStreaming.MusicStreamingAPI.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    public Admin registerAdmin(Admin admin) {

        return adminRepository.save(admin);

    }

    public Admin authenticateAdmin(Admin admin) {
        Admin authenticatedAdmin = adminRepository.findByUsernameAndPassword(admin.getAd_username(), admin.getAd_password());
        if (authenticatedAdmin != null) {
            return authenticatedAdmin;
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }

    public Admin findAdminById(String admin_id) {

        return adminRepository.findById(admin_id)
                .orElseThrow(() -> new NotFoundException(String.format("User ID: %s does not exist", admin_id)));
    }

}

package com.MCT.MusicStreaming.MusicStreamingAPI.Controller;

import com.MCT.MusicStreaming.MusicStreamingAPI.Model.Admin;
import com.MCT.MusicStreaming.MusicStreamingAPI.Model.Users;
import com.MCT.MusicStreaming.MusicStreamingAPI.Services.AdminService;
import com.MCT.MusicStreaming.MusicStreamingAPI.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<Admin> registerAdmin(@Valid @RequestBody Admin admin) {
        Admin savedAdmin = adminService.registerAdmin(admin);
        return new ResponseEntity<Admin>(savedAdmin, HttpStatus.CREATED);
    }


    @PostMapping("/authenticate")
    public ResponseEntity<Admin> authenticateAdmin(@Valid @RequestBody Admin admin) {
        Admin authenticatedAdmin = adminService.authenticateAdmin(admin);
        return new ResponseEntity<Admin>(authenticatedAdmin, HttpStatus.OK);
    }

    @GetMapping("/findbyId/{admin_id}")
    public Admin findAdminById(String admin_id){
        return this.adminService.findAdminById(admin_id);
    }


}
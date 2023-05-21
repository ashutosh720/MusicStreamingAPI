package com.MCT.MusicStreaming.MusicStreamingAPI.Services;

import com.MCT.MusicStreaming.MusicStreamingAPI.Exception.NotFoundException;
import com.MCT.MusicStreaming.MusicStreamingAPI.Model.Users;
import com.MCT.MusicStreaming.MusicStreamingAPI.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Users registerUser(Users user) {

        return userRepository.save(user);

    }

    public Users authenticateUser(Users user) {
        Users authenticatedUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (authenticatedUser != null) {
            return authenticatedUser;
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }

    public Users findUserById(int id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("User ID: %s does not exist", id)));
    }

}
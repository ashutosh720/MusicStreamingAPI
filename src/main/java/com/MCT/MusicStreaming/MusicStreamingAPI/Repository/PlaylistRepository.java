package com.MCT.MusicStreaming.MusicStreamingAPI.Repository;

import com.MCT.MusicStreaming.MusicStreamingAPI.Exception.NotFoundException;
import com.MCT.MusicStreaming.MusicStreamingAPI.Model.Playlist;
import com.MCT.MusicStreaming.MusicStreamingAPI.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlaylistRepository extends JpaRepository<Playlist,Integer> {

    @Query(value = "Select * from playlist where user_id = :user_id", nativeQuery = true)
    public Playlist getPlaylistByUserId(int user_id);
}

//    Playlist playlist = playlistRepository.findById(id)
//            .orElseThrow(() -> new NotFoundException(String.format("Playlist ID: %s does not exist", id)));
//
//        if (!playlist.getUser().getUser_id().equals(user.getUser_id())) {
//                throw new UnauthorizedUserException(String.format("User: %s is not authorized to access playlist ID: %s",
//                user.getUsername(), id));
//                }
//
//                return playlist;
//                }
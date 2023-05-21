package com.MCT.MusicStreaming.MusicStreamingAPI.Controller;

import com.MCT.MusicStreaming.MusicStreamingAPI.Model.Playlist;
import com.MCT.MusicStreaming.MusicStreamingAPI.Model.Users;
import com.MCT.MusicStreaming.MusicStreamingAPI.Services.PlaylistService;
import com.MCT.MusicStreaming.MusicStreamingAPI.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/playlist")
public class PlaylistController {


    @Autowired
    PlaylistService playlistService;

    @Autowired
    UserService userService;

    @PostMapping("/add-playlist")
    public ResponseEntity<?> createPlaylistBy(@Valid @RequestBody Playlist playlist) {

        Playlist savedplaylist = playlistService.savePlaylist(playlist);
        return new ResponseEntity<>(savedplaylist, HttpStatus.CREATED);
    }

    @GetMapping("/user_id/{user_id}")
    public ResponseEntity<Playlist> getPlaylistbyUserId(@PathVariable int user_id) {

        return ResponseEntity.ok((this.playlistService.getAllPlaylistByUserId(user_id)));
    }


    @PostMapping("/{p_id}/song/{songId}")
    public ResponseEntity<?> addSongToPlaylistById(@PathVariable int p_id, @PathVariable int songId , @RequestBody Users user) {


        Playlist playlist = playlistService.addSongById(p_id, songId, user);
        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }

    @DeleteMapping("/{p_id}/song/{songId}")
    public ResponseEntity<?> removeSongFromPlaylistById(@PathVariable int p_id, @PathVariable int songId,@RequestBody Users user) {


        Playlist playlist = playlistService.removeSongById(p_id, songId, user);
        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }
}


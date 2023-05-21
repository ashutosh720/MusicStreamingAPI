package com.MCT.MusicStreaming.MusicStreamingAPI.Controller;

import com.MCT.MusicStreaming.MusicStreamingAPI.Model.Song;
import com.MCT.MusicStreaming.MusicStreamingAPI.Services.AdminService;
import com.MCT.MusicStreaming.MusicStreamingAPI.Services.SongService;
import com.MCT.MusicStreaming.MusicStreamingAPI.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/songs")
public class SongController {


    @Autowired
    SongService songService;

    @Autowired
    AdminService adminService;

    @GetMapping("")
    public Iterable<Song> getAllSongs() {

        return songService.findAllSongs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSongById(@PathVariable int songId) {

        Song song = songService.findSongById(songId);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public Iterable<Song> getSongsByName(@PathVariable String name) {

        return songService.findSongsByName(name);
    }

    @PostMapping("/admin/{admin_id}/add_song")
    public ResponseEntity<Song> addSong(@RequestBody Song song , @PathVariable  String admin_id) {
        Song savedSong = songService.addSong(song,admin_id);
        return new ResponseEntity<>(savedSong, HttpStatus.CREATED);
    }

    @PutMapping("/admin/{admin_id}/update_song/{songId}")
    public ResponseEntity<Song> updateSong(@RequestBody Song song , @PathVariable String admin_id, @PathVariable int songId){

        Song updatedSong= this.songService.updateSong(song,admin_id,songId);
        return ResponseEntity.ok(updatedSong);
    }

    @DeleteMapping("/admin/{admin_id}/delete_song/{songId}")
    public ResponseEntity<String> deleteSong(@PathVariable String admin_id, @PathVariable int songId){

        this.songService.deleteSong(songId, admin_id);
        return new ResponseEntity<>("Deleted", HttpStatus.NO_CONTENT);
    }
}

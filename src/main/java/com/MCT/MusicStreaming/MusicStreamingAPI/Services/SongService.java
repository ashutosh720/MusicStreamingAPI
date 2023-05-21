package com.MCT.MusicStreaming.MusicStreamingAPI.Services;

import com.MCT.MusicStreaming.MusicStreamingAPI.Exception.AlreadyExistsException;
import com.MCT.MusicStreaming.MusicStreamingAPI.Exception.NotFoundException;
import com.MCT.MusicStreaming.MusicStreamingAPI.Exception.UnauthorizedUserException;
import com.MCT.MusicStreaming.MusicStreamingAPI.Model.Admin;
import com.MCT.MusicStreaming.MusicStreamingAPI.Model.Song;
import com.MCT.MusicStreaming.MusicStreamingAPI.Repository.AdminRepository;
import com.MCT.MusicStreaming.MusicStreamingAPI.Repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongService {

    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public Song findSongById(int songId) {

        return songRepository.findById(songId)
                .orElseThrow(() -> new NotFoundException(String.format("Song ID: %s does not exist", songId)));
    }


    public Iterable<Song> findAllSongs() {

        return songRepository.findAll();
    }

    public Iterable<Song> findSongsByName(String name) {

        return songRepository.findByNameContainingIgnoreCase(name);
    }

    @Autowired
    private AdminRepository adminRepository;



    public Song addSong(Song song, String admin_id){

        int existId=song.getSongId();
        Optional<Song> existingSong=songRepository.findById(existId);
        if(existingSong.isEmpty()){
            throw new AlreadyExistsException(String.format("Song already exists in database: %s", song.getName()));
        }

        Admin authadmin =adminRepository.findById(admin_id).orElseThrow(() -> new UnauthorizedUserException(String.format("Admin ID: %s does not exist or Unauthorised User", admin_id)));
        if(authadmin != null){

            songRepository.save(song);
        }


        return song;
    }

    public Song updateSong(Song song, String admin_id , int songId){

        Admin authadmin =adminRepository.findById(admin_id).orElseThrow(() -> new NotFoundException(String.format("Admin ID: %s does not exist", admin_id)));
        if(authadmin != null){

            Song newSong = songRepository.findById(songId).get();
            newSong.setName(song.getName());
            newSong.setSinger(song.getSinger());
            newSong.setAlbum(newSong.getAlbum());
            newSong.setDuration(newSong.getDuration());
            this.songRepository.save(newSong);
        }


        return song;
    }

    public void deleteSong(int songId ,String admin_id) {

        Optional<Song> existingSong=songRepository.findById(songId);
        if(existingSong.isEmpty()){
            throw new NotFoundException(String.format("Song does not exists in database: %s", songId));
        }

        Admin authadmin =adminRepository.findById(admin_id).orElseThrow(() -> new UnauthorizedUserException(String.format("Admin ID: %s does not exist or Unauthorised User", admin_id)));
        if(authadmin != null){

            this.songRepository.deleteById(songId);
        }

    }
}


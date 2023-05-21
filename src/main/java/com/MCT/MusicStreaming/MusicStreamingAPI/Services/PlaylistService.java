package com.MCT.MusicStreaming.MusicStreamingAPI.Services;

import com.MCT.MusicStreaming.MusicStreamingAPI.Exception.AlreadyExistsException;
import com.MCT.MusicStreaming.MusicStreamingAPI.Exception.NotFoundException;
import com.MCT.MusicStreaming.MusicStreamingAPI.Exception.UnauthorizedUserException;
import com.MCT.MusicStreaming.MusicStreamingAPI.Model.Playlist;
import com.MCT.MusicStreaming.MusicStreamingAPI.Model.Song;
import com.MCT.MusicStreaming.MusicStreamingAPI.Model.Users;
import com.MCT.MusicStreaming.MusicStreamingAPI.Repository.PlaylistRepository;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {
    private final UserService userService;
    private final SongService songService;
    private final PlaylistRepository playlistRepository;

    public PlaylistService(UserService userService, SongService songService, PlaylistRepository playlistRepository) {
        this.userService = userService;
        this.songService = songService;
        this.playlistRepository = playlistRepository;
    }

    public Playlist findPlaylistByIdAndUser(int id, Users user) {

        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Playlist ID: %s does not exist", id)));

        if (!playlist.getUser().getUser_id().equals(user.getUser_id())) {
            throw new UnauthorizedUserException(String.format("User: %s is not authorized to access playlist ID: %s",
                    user.getUsername(), id));
        }

        return playlist;
    }

    public Playlist addSongById(int p_id, int songId, Users user) {

        user = userService.findUserById(user.getUser_id());
        Playlist playlist = findPlaylistByIdAndUser(p_id, user);

        Song song = songService.findSongById(songId);
        if (playlist.getSongs().contains(song)) {
            throw new AlreadyExistsException(String.format("Song: %s already exists in playlist: %s",
                    song.getName(), playlist.getP_name()));
        }
        playlist.addsong(song);

        return playlistRepository.save(playlist);
    }

    public Playlist removeSongById(int p_id, int songId, Users user) {

        user = userService.findUserById(user.getUser_id());
        Playlist playlist = findPlaylistByIdAndUser(p_id, user);

        Song song = songService.findSongById(songId);
        if (!playlist.getSongs().contains(song)) {
            throw new NotFoundException(String.format("Song: %s not found in playlist: %s",
                    song.getName(), playlist.getP_name()));
        }
        playlist.removeSong(song);

        return playlistRepository.save(playlist);
    }

    public Playlist savePlaylist(Playlist playlist) {


        Playlist newPlaylist=this.playlistRepository.save(playlist);
        return newPlaylist;
    }

    public Playlist getAllPlaylistByUserId(int user_id){

        Playlist playList=playlistRepository.getPlaylistByUserId(user_id);
        return playList;
    }





}

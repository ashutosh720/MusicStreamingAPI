package com.MCT.MusicStreaming.MusicStreamingAPI.Repository;

import com.MCT.MusicStreaming.MusicStreamingAPI.Model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Integer> {

    public Iterable<Song> findByNameContainingIgnoreCase(String name);
}

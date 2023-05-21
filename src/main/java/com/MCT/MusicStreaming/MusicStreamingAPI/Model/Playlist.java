package com.MCT.MusicStreaming.MusicStreamingAPI.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "playlist")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private Integer p_id;

    @Column(nullable = false)
    private String p_name;



    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Song> songs = new ArrayList<>();



    @OneToOne(fetch = FetchType.LAZY)
    private Users user;

    public void addsong(Song song) {
        this.songs.add(song);
    }

    public void removeSong(Song song) {
        this.songs.remove(song);
    }
}

package com.MCT.MusicStreaming.MusicStreamingAPI.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer songId;

    @NotBlank(message = "songName is mandatory")
    private String name;

    @NotNull(message = "singer is mandatory")
    private String singer;


    @NotNull(message = "album name is mandatory")
    private String album;

    @NotNull(message = "duartion is mandatory")
    private String duration;

    @ManyToOne(fetch = FetchType.LAZY)
    private Playlist playlist;

}

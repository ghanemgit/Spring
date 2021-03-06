package com.spring.songr.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    String name;
    @NonNull
    String artist;
    @NonNull
    int songCount;
    @NonNull
    long lengthInSecond;

    @NonNull
    String imageUrl;


    @OneToMany(mappedBy = "album")
    Set<Song> songs;
}

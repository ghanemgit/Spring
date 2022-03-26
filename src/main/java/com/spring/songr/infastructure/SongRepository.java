package com.spring.songr.infastructure;


import com.spring.songr.domain.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends CrudRepository<Song,Long> {

    Song findSongByTitle(String title);

}

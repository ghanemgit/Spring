package com.spring.songr.infastructure;

import com.spring.songr.domain.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {

    List<Album> findAllById(Long id);
}

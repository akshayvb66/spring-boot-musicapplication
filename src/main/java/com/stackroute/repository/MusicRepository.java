package com.stackroute.repository;

import com.stackroute.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MusicRepository extends JpaRepository<Music,Integer> {

    @Query("select p from Music p where p.trackName=?1")
    List<Music> findByName(String trackName);

}

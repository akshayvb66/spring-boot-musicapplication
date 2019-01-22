package com.stackroute.repository;

import com.stackroute.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music,Integer> {
}

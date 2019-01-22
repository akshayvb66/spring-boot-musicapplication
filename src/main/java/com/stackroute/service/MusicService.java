package com.stackroute.service;

import com.stackroute.domain.Music;

import java.util.List;
import java.util.Optional;

public interface MusicService {

    public Music saveMusic(Music music);

    public List<Music> getAllMusic();

    public Music updateComment(Music music,int trackId);

    public List<Music> deleteTrack(int trackId);

    public Optional<Music> findById(int trackId);
}

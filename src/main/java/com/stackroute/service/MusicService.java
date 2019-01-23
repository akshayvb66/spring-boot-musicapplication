package com.stackroute.service;

import com.stackroute.domain.Music;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;

import java.util.List;
import java.util.Optional;

public interface MusicService {

    public Music saveMusic(Music music) throws TrackAlreadyExistsException;

    public List<Music> getAllMusic();

    public Music updateComment(Music music,int trackId) throws TrackNotFoundException;

    public List<Music> deleteTrack(int trackId) throws TrackNotFoundException;

    public Optional<Music> findById(int trackId) throws TrackNotFoundException;

    public List<Music> findByName(String trackName);
}

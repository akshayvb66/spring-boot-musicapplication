package com.stackroute.service;

import com.stackroute.domain.Music;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * This is an interface to implement the Music class of domain package.
 */
public interface MusicService {


    /*This method is used to add new track to the database*/
    public Music saveMusic(Music music) throws TrackAlreadyExistsException;

    /*This method is used to get all the tracks in database*/
    public List<Music> getAllMusic();

    /*This method is used to update comment of a particular track*/
    public Music updateComment(int trackId,String comment) throws TrackNotFoundException;

    /*This method is used to delete a track through track Id*/
    public List<Music> deleteTrack(int trackId) throws TrackNotFoundException;

    /*This method is used to search for a track by its id*/
    public Optional<Music> findById(int trackId) throws TrackNotFoundException;

    /*This method is used to search for a track by its name*/
    public List<Music> findByName(String trackName);
}

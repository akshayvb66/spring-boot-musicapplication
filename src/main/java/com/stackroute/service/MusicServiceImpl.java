package com.stackroute.service;

import com.stackroute.domain.Music;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This class calls method in repository layer
 */
@Service
public class MusicServiceImpl implements MusicService{


    private MusicRepository musicRepository;

    @Autowired
    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
        }


    /*This method is used to add new track to the database*/
    @Override
    public Music saveMusic(Music music) throws TrackAlreadyExistsException {
        if(musicRepository.existsById(music.getTrackId())){
            throw new TrackAlreadyExistsException("User already exists");
        }

        Music savedMusic= musicRepository.save(music);

        if(music==null){
            throw new TrackAlreadyExistsException("track doesnt exist");
        }
        return savedMusic;
        }

    /*This method is used to get all the tracks in database*/
    @Override
    public List<Music> getAllMusic() {
        return musicRepository.findAll();
        }

    /*This method is used to update comment of a particular track*/
    @Override
    public Music updateComment(int trackId,String comment) throws TrackNotFoundException {
        if(!musicRepository.existsById(trackId)){
            throw new TrackNotFoundException("Track to update not found");
        }

        Music updateMusic = musicRepository.findById(trackId).get();
        updateMusic.setTrackComment(comment);
        return musicRepository.save(updateMusic);
        }


    /*This method is used to delete a track through track Id*/
    @Override
    public List<Music> deleteTrack( int trackId) throws TrackNotFoundException {
        if(!musicRepository.existsById(trackId)){
            throw new TrackNotFoundException("Track for deleting not found");
        }
        musicRepository.deleteById(trackId);
        return musicRepository.findAll();
        }

    /*This method is used to search for a track by its id*/
    @Override
    public Optional<Music> findById(int trackId) throws TrackNotFoundException {
        if(!musicRepository.existsById(trackId)){
            throw new TrackNotFoundException("Track you searched not found ");
        }
        Optional<Music> music = musicRepository.findById(trackId);
        return music;
        }


    /*This method is used to search for a track by its name*/
    @Override
    public List<Music> findByName(String trackName) {

        return musicRepository.findByName(trackName);
        }


}

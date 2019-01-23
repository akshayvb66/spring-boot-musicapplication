package com.stackroute.service;

import com.stackroute.domain.Music;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicServiceImpl implements MusicService{


    MusicRepository musicRepository;

    @Autowired
    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }


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

    @Override
    public List<Music> getAllMusic() {
        return musicRepository.findAll();
    }

    @Override
    public Music updateComment(Music music,int trackId) throws TrackNotFoundException {
        if(!musicRepository.existsById(trackId)){
            throw new TrackNotFoundException("Track to update not found");
        }

        Music updateMusic = musicRepository.save(music);
        return updateMusic;
    }

    @Override
    public List<Music> deleteTrack( int trackId) throws TrackNotFoundException {
        if(!musicRepository.existsById(trackId)){
            throw new TrackNotFoundException("Track for deleting not found");
        }
        musicRepository.deleteById(trackId);
        return musicRepository.findAll();

  }

    @Override
    public Optional<Music> findById(int trackId) throws TrackNotFoundException {
        if(!musicRepository.existsById(trackId)){
            throw new TrackNotFoundException("Track you searched not found ");
        }
        Optional<Music> music = musicRepository.findById(trackId);
        return music;
    }

    @Override
    public List<Music> findByName(String trackName) {

        return musicRepository.findByName(trackName);

    }


}

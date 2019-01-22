package com.stackroute.service;

import com.stackroute.domain.Music;
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
    public Music saveMusic(Music music) {

        Music savedMusic= musicRepository.save(music);
        return savedMusic;
    }

    @Override
    public List<Music> getAllMusic() {
        return musicRepository.findAll();
    }

    @Override
    public Music updateComment(Music music,int trackId){

        Music updateMusic = musicRepository.save(music);
        return updateMusic;
    }

    @Override
    public List<Music> deleteTrack( int trackId) {

        musicRepository.deleteById(trackId);
        return musicRepository.findAll();

  }

    @Override
    public Optional<Music> findById(int trackId) {

           Optional<Music> music = musicRepository.findById(trackId);
        return music;
    }

}

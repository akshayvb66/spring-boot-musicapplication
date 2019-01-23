package com.stackroute.config;

import com.stackroute.domain.Music;
import com.stackroute.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    MusicService musicService;

    @Autowired
    public CommandLineRunner(MusicService musicService) {
        this.musicService = musicService;
    }

    @Override
    public void run(String... args) throws Exception {
        Music music = new Music();
        music.setTrackId(1);
        music.setTrackName("default name CommandLineRunner");
        music.setTrackComment("default comments Line Runner");
        try {
            musicService.saveMusic(music);
        } catch (Exception e) {
        }
    }

}

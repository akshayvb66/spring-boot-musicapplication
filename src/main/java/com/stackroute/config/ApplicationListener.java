package com.stackroute.config;

import com.stackroute.domain.Music;
import com.stackroute.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

    @Component
    public class ApplicationListener implements org.springframework.context.ApplicationListener<ContextRefreshedEvent>{

        MusicService musicService;

        @Autowired
        public ApplicationListener(MusicService musicService) {
            this.musicService = musicService;
        }

        @Override
        public void onApplicationEvent(ContextRefreshedEvent event) {

            Music music = new Music();
            music.setTrackId(0);
            music.setTrackName("default name");
            music.setTrackComment("default comments");
            try {
                musicService.saveMusic(music);
            }
            catch (Exception e){}
        }


    }

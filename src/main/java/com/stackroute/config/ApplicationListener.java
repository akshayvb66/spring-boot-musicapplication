package com.stackroute.config;

import com.stackroute.domain.Music;
import com.stackroute.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:app2.properties")
public class ApplicationListener implements org.springframework.context.ApplicationListener<ContextRefreshedEvent>{

       private MusicService musicService;

       @Value("${trackName}")
       private String trackName;
        @Value("${trackId}")
       private int trackId;
        @Value("${trackComment}")
       private String trackComment;

        @Autowired
        public ApplicationListener(MusicService musicService) {
            this.musicService = musicService;
        }

        @Override
        public void onApplicationEvent(ContextRefreshedEvent event) {

            Music music = new Music();
            music.setTrackId(trackId);
            music.setTrackName(trackName);
            music.setTrackComment(trackComment);
            try {
                musicService.saveMusic(music);
            }
            catch (Exception e){}
        }


    }

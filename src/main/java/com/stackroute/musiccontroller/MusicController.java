package com.stackroute.musiccontroller;

import com.stackroute.domain.Music;
import com.stackroute.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="/")
public class MusicController {

    MusicService musicService;

    @Autowired
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @PostMapping("music")
    public ResponseEntity<?> saveTrack(@RequestBody Music music) {

        ResponseEntity responseEntity;
        try {

            musicService.saveMusic(music);
            responseEntity = new ResponseEntity<String>("successfully added", HttpStatus.CREATED);

        } catch (Exception ex) {

            responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }

        return responseEntity;
    }

    @GetMapping("music")
    public ResponseEntity<List<Music>> getAllTracks() {
        return new ResponseEntity<List<Music>>(musicService.getAllMusic(), HttpStatus.OK);
    }

    @PutMapping("music/{trackId}")
    public ResponseEntity<?> updateComment( @RequestBody Music music,@PathVariable("trackId") int trackId) {

        ResponseEntity responseEntity;
        try {

            musicService.updateComment(music, trackId);
            responseEntity = new ResponseEntity<String>("successfully updated", HttpStatus.OK);
            return responseEntity;
        } catch (Exception ex) {
            responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }

        return responseEntity;
    }

    @DeleteMapping("music/{trackId}")
    public ResponseEntity<?> deleteMusic(@PathVariable("trackId") int trackId ){

        ResponseEntity responseEntity;
        try{

            musicService.deleteTrack(trackId);
            responseEntity= new ResponseEntity<List<Music>>(musicService.getAllMusic(),HttpStatus.OK);
        }
        catch (Exception ex){

            responseEntity= new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("music/{trackId}")
    public ResponseEntity<?> getTrack(@PathVariable("trackId") int trackId){

        ResponseEntity responseEntity;
        try {

            responseEntity= new ResponseEntity<Optional<Music>>(musicService.findById(trackId),HttpStatus.OK);
        }
        catch(Exception ex){

            responseEntity= new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;

    }


}

package com.stackroute.controller;

import com.stackroute.domain.Music;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.service.MusicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="/api/v1")
@Api(value="Music Application",description = "You can add you music search and delete")
public class MusicController {

    MusicService musicService;

    @Autowired
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @ApiOperation(value = "Add your music")
    @PostMapping("music")
    public ResponseEntity<?> saveTrack(@RequestBody Music music) throws TrackAlreadyExistsException {


        ResponseEntity responseEntity;

            musicService.saveMusic(music);
            responseEntity = new ResponseEntity<String>("successfully added", HttpStatus.CREATED);



        return responseEntity;
    }

    @ApiOperation(value = "Find all your songs")
    @GetMapping("musics")
    public ResponseEntity<List<Music>> getAllTracks() {
        return new ResponseEntity<List<Music>>(musicService.getAllMusic(), HttpStatus.OK);
    }

    @ApiOperation(value = "Update comment of your song")
    @PutMapping("music/{trackId}")
    public ResponseEntity<?> updateComment( @RequestBody Music music,@PathVariable("trackId") int trackId) throws TrackNotFoundException {

        ResponseEntity responseEntity;

            musicService.updateComment(music, trackId);
            responseEntity = new ResponseEntity<String>("successfully updated", HttpStatus.OK);
            return responseEntity;

    }

    @ApiOperation(value = "delete the song you hate by id")
    @DeleteMapping("music/{trackId}")
    public ResponseEntity<?> deleteMusic (@PathVariable("trackId") int trackId ) throws TrackNotFoundException {

        ResponseEntity responseEntity;

            musicService.deleteTrack(trackId);
            responseEntity= new ResponseEntity<List<Music>>(musicService.getAllMusic(),HttpStatus.OK);

        return responseEntity;
    }


    @ApiOperation(value = "Search your song by id")
    @GetMapping("music/{trackId}")
    public ResponseEntity<?> getTrack(@PathVariable("trackId") int trackId) throws TrackNotFoundException{

        ResponseEntity responseEntity;

            responseEntity= new ResponseEntity<Optional<Music>>(musicService.findById(trackId),HttpStatus.OK);


        return responseEntity;

    }

    @GetMapping("musics/{trackName}")
    public ResponseEntity<?> getTrackByName(@PathVariable("trackName") String trackName){

        ResponseEntity responseEntity;
        try
        {
            responseEntity= new ResponseEntity(musicService.findByName(trackName),HttpStatus.OK);
        }
        catch(Exception ex){

            responseEntity= new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
        }

        return responseEntity;
    }


}

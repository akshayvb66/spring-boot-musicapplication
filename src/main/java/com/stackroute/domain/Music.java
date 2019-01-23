package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/** This is Music class which defines the track object with trackId, trackName
 * and trackComment
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Music {

    @Id
    private int trackId; //here track id is unique the primary key
    private String trackName;
    private String trackComment;

}

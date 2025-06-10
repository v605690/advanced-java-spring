package com.codingnomads.springdata.example.mybatis.resultsandresult;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Playlist {
    private Long id;
    private String rockPlayList;
    private String punkPlayList;
    private String favPlayList;
}

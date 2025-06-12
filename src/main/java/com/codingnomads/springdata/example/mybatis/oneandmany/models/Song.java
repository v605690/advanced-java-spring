/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.mybatis.oneandmany.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
// A Song can only have one artist = one artist mapped onto the Song
public class Song {

    private Long id;

    private String name;

    private Album album;
    private Artist artist;

    // song length in seconds
    private int songLength;

    public Song(Long id, String name, Album album, Artist artist, int songLength) {
        this.id = id;
        this.name = name;
        this.album = album;
        this.artist = artist;
        this.songLength = songLength;
    }
}

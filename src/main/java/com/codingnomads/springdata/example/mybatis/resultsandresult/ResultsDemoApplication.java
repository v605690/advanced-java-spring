/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.mybatis.resultsandresult;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ResultsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResultsDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData(SongMapper songMapper, PlaylistMapper playlistMapper) {
        return (args) -> {
            // notice the setter names have changed to match Java naming conventions
            Song song1 = new Song();
            song1.setName("Minnesota, WI");
            song1.setAlbumName("Bon Iver");
            song1.setArtistName("Bon Iver");
            song1.setSongLength(232);

            Song song2 = new Song();
            song2.setName("Post Humorous");
            song2.setAlbumName("Orca");
            song2.setArtistName("Gus Dapperton");
            song2.setSongLength(279);

            songMapper.insertNewSong(song1);
            songMapper.insertNewSong(song2);

            Song song3 = songMapper.getSongById(1L);
            System.out.println(song3.toString());

            Playlist playlist = new Playlist();
            playlist.setPunkPlayList("Blink 182");
            playlist.setRockPlayList("Van Halen");
            playlist.setFavPlayList("Judah and The Lion");

            Playlist playlist2 = new Playlist();
            playlist2.setPunkPlayList("Green Day");
            playlist2.setRockPlayList("Metallica");
            playlist2.setFavPlayList("The Killers");

            playlistMapper.insert(playlist);
            playlistMapper.insert(playlist2);

            playlistMapper.delete(1L);
            playlistMapper.delete(12L);

        };
    }
}

/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.mybatis.mapperslesson;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyBatisDemoApplication {

    /* Before running this app, be sure to:

       * create a new empty schema in the mysql database named "mybatis"

       * execute the SQL found "songs_table.sql" on the mybatis schema

       * update the "spring.datasource.url" property in your application.properties file to
         jdbc:mysql://localhost:3306/mybatis?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC

    */

    public static void main(String[] args) {
        SpringApplication.run(MyBatisDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData(SongMapper songMapper) {
        return (args) -> {
            Song song1 = new Song();
            song1.setName("Minnesota, WI");
            song1.setAlbum_name("Bon Iver");
            song1.setArtist_name("Bon Iver");
            song1.setSong_length(232);

            Song song2 = new Song();
            song2.setName("Post Humorous");
            song2.setAlbum_name("Orca");
            song2.setArtist_name("Gus Dapperton");
            song2.setSong_length(279);

            Song favSong = new Song();
            favSong.setName("Is what it is");
            favSong.setAlbum_name("The Process");
            favSong.setArtist_name("Judah & the Lion");

            Song secondFavSong = new Song();
            secondFavSong.setName("Party Party Party");
            secondFavSong.setAlbum_name("Aqua Teen Hunger Force");
            secondFavSong.setArtist_name("Andrew Wk");

            Song thirdFavSong = new Song();
            thirdFavSong.setName("Suburban Kings");
            thirdFavSong.setAlbum_name("To the Stars...Demos, Odds and Ends");
            thirdFavSong.setArtist_name("Tom Delonge");

            Song fourthFavSong = new Song();
            fourthFavSong.setName("The Fourth Favour");
            fourthFavSong.setAlbum_name("The Fourth Favour");
            fourthFavSong.setArtist_name("Judah & the Lion");

            songMapper.insertNewSong(song1);
            songMapper.insertNewSong(song2);
            songMapper.insertNewSong(favSong);
            songMapper.insertNewSong(secondFavSong);
            songMapper.insertNewSong(thirdFavSong);
            songMapper.insertNewSong(fourthFavSong);

            Song song3 = songMapper.getSongById(132L);

            System.out.println(song3.toString());

            List<Song> longSongs = songMapper.getSongsWithLengthGreaterThan(250);
            longSongs.forEach(System.out::println);

            List<Song> albumName = songMapper.getSongsByAlbumName("Bon Iver");
            albumName.forEach(System.out::println);

            List<Song> songList = songMapper.getSongsByArtistNameAndName("Tom Delonge", "Suburban Kings");
            songList.forEach(System.out::println);

            List<Song> artist = songMapper.getSongsByArtist("Andrew Wk");
            artist.forEach(System.out::println);

            List<Song> albumAndArtist = songMapper.getSongsByAlbumAndArtist("Tom Delonge", "Andrew Wk");
            albumAndArtist.forEach(System.out::println);

            songMapper.deleteSongById(121L);

            fourthFavSong.setName("Sweet Surrender");
            fourthFavSong.setAlbum_name("The Process");
            songMapper.updateSong(fourthFavSong);
            artist.forEach(System.out::println);

        };
    }
}

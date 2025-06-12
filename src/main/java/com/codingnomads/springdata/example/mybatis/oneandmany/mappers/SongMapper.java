/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.mybatis.oneandmany.mappers;

import com.codingnomads.springdata.example.mybatis.oneandmany.models.Album;
import com.codingnomads.springdata.example.mybatis.oneandmany.models.Artist;
import com.codingnomads.springdata.example.mybatis.oneandmany.models.Song;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface SongMapper {

    @Insert("INSERT INTO mybatis.songs " + "(name, artist_id, song_length) "
            + "VALUES (#{name}, #{artist.id}, #{songLength});")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertNewSong(Song song);

    @Select("SELECT * " + "FROM mybatis.songs " + "WHERE id = #{param1};")
    @Results(
            id = "songResultMap",
            value = {
                    @Result(property = "album", column = "album_id",
                            javaType = Album.class,
                            one = @One
                                    (select = "com.codingnomads.springdata.example.mybatis.oneandmany.mappers.AlbumMapper.getAlbumWithoutSongs",
                                            fetchType = FetchType.LAZY)),
                    @Result(property = "songLength", column = "song_length"),
                    @Result(
                            // property to map to
                            property = "artist", column = "artist_id",
                            javaType = Artist.class,
                            one = @One
                                    (select = "com.codingnomads.springdata.example.mybatis.oneandmany.mappers.ArtistMapper.getArtistByIdWithoutAlbums",
                                            fetchType = FetchType.LAZY))
            })
    Song getSongById(Long id);

    @Select("SELECT * " + "FROM mybatis.albums " + "WHERE name = #{param1};")
    @ResultMap("songResultMap")
    List<Album> getAlbumsByArtistId(Long id);

    @Select("SELECT * " + "FROM mybatis.songs " + "WHERE name = #{param1};")
    @ResultMap("songResultMap")
    List<Song> getSongsByName(String name);

    @Select("SELECT * " + "FROM mybatis.songs " + "WHERE artist_id = #{param1} AND album = #{param2};")
    @ResultMap("songResultMap")
    List<Song> getSongsByAlbumAndArtist(Long artistId, String album);

    @Select("SELECT * " + "FROM mybatis.songs " + "WHERE artist_id = #{param1};")
    @ResultMap("songResultMap")
    List<Song> getSongsByArtistId(Long artistId);

    @Select("SELECT * " + "FROM mybatis.songs " + "WHERE album_id = #{param1};")
    @ResultMap("songResultMap")
    List<Song> getSongsByAlbumId(Long albumId);

    @Update("UPDATE mybatis.songs "
            + "SET name = #{name}, artist_id = #{artist.id}, album = #{album_id}, song_length = #{songLength} "
            + "WHERE id = #{id};")
    void updateSong(Song song);

    @Delete("DELETE FROM mybatis.songs WHERE id = #{param1};")
    void deleteSongById(Long songId);

    @Delete("DELETE FROM mybatis.songs " + "WHERE artist_id = #{artistId} AND album = #{album};")
    void deleteSongsByAlbumAndArtist(Long artistId, String album);
}

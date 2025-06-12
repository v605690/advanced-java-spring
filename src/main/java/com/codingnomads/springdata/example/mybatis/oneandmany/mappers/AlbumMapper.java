package com.codingnomads.springdata.example.mybatis.oneandmany.mappers;

import com.codingnomads.springdata.example.mybatis.oneandmany.models.Album;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface AlbumMapper {
    // Many albums to one artist

    @Insert("INSERT INTO mybatis.albums (artist_id, name, year) VALUES (#{artist.id}, #{name}, #{year})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertNewAlbum(Album album);

    @Select("SELECT * FROM mybatis.albums WHERE id = #{param1};")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(
                property = "songs",
                column = "id",
                javaType = List.class,
                many =
                        @Many(
                                select =
                                        "com.codingnomads.springdata.example.mybatis.oneandmany.mappers.SongMapper.getSongsByAlbumId",
                                fetchType = FetchType.LAZY))
    })
    Album getAlbum(@Param("param1") Long id);

    @Select("SELECT * FROM mybastis.albums WHERE id = #{param1};")
    Album getAlbumById(@Param("param1") Long id);

    @Select("SELECT * FROM mybastis.albums WHERE id = #{param1};")
    Album getAlbumsWithoutSongs(@Param("param1") Long id);
}

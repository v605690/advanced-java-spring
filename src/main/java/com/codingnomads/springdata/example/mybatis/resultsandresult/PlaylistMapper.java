package com.codingnomads.springdata.example.mybatis.resultsandresult;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PlaylistMapper {
    @Insert("INSERT INTO mybatis.playlists " + "(rock_PlayList, punk_PlayList, fav_PlayList) " +
            "VALUES (#{rockPlayList}, #{punkPlayList}, #{favPlayList});")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(Playlist playlist);

    @Select("SELECT * " + "FROM mybatis.playlists " + "WHERE id = #{param1};")

    @Results(
            id = "playListResultMap",
            value = {
            @Result(property = "rockPlayList", column = "rock_PlayList"),
            @Result(property = "punkPlayList", column = "punk_playlist"),
            @Result(property = "favPlayList", column = "fav_playlist")
    })
    Playlist getById(Long id);

    @Select("SELECT * " + "FROM mybatis.playlists " + "WHERE rock_PlayList = #{param1};")
    @ResultMap("playListResultMap")
    List<Playlist> getByRockPlayList(String rockPlayList);

    @Select("SELECT * " + "FROM mybatis.playlists " + "WHERE punk_PlayList = #{param1};")
    @ResultMap("playListResultMap")
    List<Playlist> getByPunkPlayList(String punkPlayList);

    @Select("SELECT * " + "FROM mybatis.playlists " + "WHERE fav_PlayList = #{param1};")
    @ResultMap("playListResultMap")
    List<Playlist> getByFavPlayList(String favPlayList);

    @Update("UPDATE mybatis.playlists "
            + "SET rock_PlayList = #{rockPlayList}, punk_PlayList = #{punkPlayList}, fav_PlayList = #{favPlayList} "
            + "WHERE id = #{id};")
    void update(Playlist playlist);

    @Delete("DELETE FROM mybatis.playlists WHERE id = #{param1};")
    void delete(Long id);

    @Delete("DELETE FROM mybatis.playlists " + "WHERE punk_PlayList = #{punkPlayList};")
    void deleteByPunkPlayList(String punkPlayList);

}

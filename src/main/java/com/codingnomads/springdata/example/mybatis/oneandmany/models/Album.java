package com.codingnomads.springdata.example.mybatis.oneandmany.models;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "songs")
@Builder
public class Album {
    private Long id;
    private Artist artist;
    private String name;
    private int year;
    private List<Song> songs;
}

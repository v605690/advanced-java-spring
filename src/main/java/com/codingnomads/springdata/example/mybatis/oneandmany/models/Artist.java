/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.mybatis.oneandmany.models;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(exclude = "albums")
// One Artist can have many songs = get the many songs mapped onto the Artist
public class Artist {

    private Long id;

    private String name;

    private String bio;

    private List<Album> albums;
}

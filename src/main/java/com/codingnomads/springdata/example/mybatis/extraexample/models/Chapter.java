/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.mybatis.extraexample.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chapter {

    private Long id;
    private String name;
    private List<Lesson> lessons;
}

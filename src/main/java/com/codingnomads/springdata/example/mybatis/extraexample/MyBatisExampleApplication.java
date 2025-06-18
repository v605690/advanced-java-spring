/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.mybatis.extraexample;

import com.codingnomads.springdata.example.mybatis.extraexample.mappers.ChapterMapper;
import com.codingnomads.springdata.example.mybatis.extraexample.mappers.ImageMapper;
import com.codingnomads.springdata.example.mybatis.extraexample.mappers.LessonMapper;
import com.codingnomads.springdata.example.mybatis.extraexample.mappers.SectionMapper;
import com.codingnomads.springdata.example.mybatis.extraexample.models.Chapter;
import com.codingnomads.springdata.example.mybatis.extraexample.models.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MyBatisExampleApplication implements CommandLineRunner {

    /* Before running this app, be sure to:

       * create a new empty schema in the mysql database named "mybatis"

       * execute the SQL found "database_structure.sql" on the mybatis schema

       * update the "spring.datasource.url" property in your application.properties file to
         jdbc:mysql://localhost:3306/mybatis?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC

    */

    @Autowired
    ImageMapper imageMapper;

    @Autowired
    LessonMapper lessonMapper;

    @Autowired
    ChapterMapper chapterMapper;

    @Autowired
    SectionMapper sectionMapper;

    public static void main(String[] args) {
        SpringApplication.run(MyBatisExampleApplication.class);

    }

    @Override
    public void run(String... args) throws Exception {

//        sectionMapper.insertNewSection("American Civil War - Origins");
//        chapterMapper.insertNewChapter("American Civil War", 10L);
//        //lessonMapper.insertNewLesson("History", "American Civil War", 20L);
//        imageMapper.insertNewImage("History", toString().getBytes());
//        lessonMapper.addImageToLesson(32L, "History");

        sectionMapper.insertNewSection("Computer Science");

        System.out.println(sectionMapper.getSectionById(10L));
        Chapter chapter = Chapter.builder().name("Science").id(2L).build();
        System.out.println(chapterMapper.getByChapterId(chapter.getId()));
        chapterMapper.insertNewChapter(String.valueOf("Science"), 58L);
        System.out.println(chapterMapper.getChaptersBySectionId(chapter.getId()));
       // lessonMapper.insertNewLesson(String.valueOf("Biology"), "BIO", 36L);
        System.out.println(lessonMapper.getLessonByChapterId(chapter.getId()));
       // imageMapper.insertNewImage("Science", toString().getBytes());
        System.out.println(imageMapper.getImagesByLessonId(chapter.getId()));
        lessonMapper.addImageToLesson(35L, "Science");
        System.out.println(lessonMapper.getLessonByChapterId(chapter.getId()));
        imageMapper.insertNewImage("Biology", toString().getBytes());
        System.out.println(imageMapper.getImagesByLessonId(chapter.getId()));
        lessonMapper.getLessonById(1L);

        getData();
    }

    public void getData(){
        System.out.println(imageMapper.getImageByName());
        System.out.println(lessonMapper.getLessonById(32L));
        System.out.println(chapterMapper.getByChapterId(20L));
        System.out.println(sectionMapper.getSectionById(58L));

        Section section = sectionMapper.getSectionById(10L);
        System.out.println(section);

        for (Chapter s : section.getChapters()) {
            System.out.println(s);
        }
    }
}

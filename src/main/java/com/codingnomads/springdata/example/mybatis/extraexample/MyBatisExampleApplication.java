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
//        imageMapper.insertNewImage("Car", toString().getBytes());
//        imageMapper.insertNewImage("Bike", toString().getBytes());
//        imageMapper.insertNewImage("Truck", toString().getBytes());
//        imageMapper.insertNewImage("Van", toString().getBytes());

        lessonMapper.insertNewLesson("History", "American Civil War", 1001L);
//        lessonMapper.insertNewLesson("Science", "The Brain", 1501L);


//
//        chapterMapper.insertNewChapter("American Civil War", 1501L);
//        chapterMapper.insertNewChapter("Science", 1001L);
//
//        sectionMapper.insertNewSection("American Civil War - Origins");
//        sectionMapper.insertNewSection("Science - Biology");
//
//        imageMapper.getImageByName();
//        lessonMapper.getLessonById(1001L);
//        chapterMapper.getByChapterId(1501L);
        //sectionMapper.getSectionById(1L);
    }

//    public void getData(){
//        System.out.println(imageMapper.getImageByName());
//        System.out.println(lessonMapper.getLessonById(5L));
//        System.out.println(chapterMapper.getByChapterId(10L));
//        System.out.println(sectionMapper.getSectionById(1L));
//
//        Section section = sectionMapper.getSectionById(1L);
//        System.out.println(section);
//
//        for (Chapter s : section.getChapters()) {
//            System.out.println(s);
//        }
//    }
}

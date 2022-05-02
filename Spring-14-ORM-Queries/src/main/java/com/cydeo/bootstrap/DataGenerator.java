package com.cydeo.bootstrap;

import com.cydeo.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class DataGenerator implements CommandLineRunner {


    private final CourseRepository courseRepository;

    public DataGenerator(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("<----------Region Start---------->");


        System.out.println("<----------Course Start---------->");

         courseRepository.findByCategory("Spring").forEach(System.out::println);

        System.out.println("----------");

         courseRepository.findByCategoryOrderByName("Spring").forEach(System.out::println);

        System.out.println("----------");

        System.out.println(courseRepository.existsByName("JavaScript for All"));

        System.out.println("----------");

        System.out.println(courseRepository.countByCategory("Spring"));

        System.out.println("----------");

        courseRepository.findByNameStartsWith("Scalable").forEach(System.out::println);

        System.out.println("----------");

        courseRepository.streamByCategory("Spring").forEach(System.out::println);

        System.out.println("<----------Course End----------->");




    }
}

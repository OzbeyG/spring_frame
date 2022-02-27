package com.cydeo;

import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class CydeoApplication {

    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setText("Spring Boot");
        comment.setAuthor("Mike");

        ApplicationContext container = new AnnotationConfigApplicationContext(CydeoApplication.class);

        CommentService cs = container.getBean(CommentService.class);


          cs.publishComment(comment);

        //SpringApplication.run(CydeoApplication.class, args);
    }

}

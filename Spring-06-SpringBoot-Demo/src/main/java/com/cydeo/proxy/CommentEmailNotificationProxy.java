package com.cydeo.proxy;

import com.cydeo.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("EMAIL")
public class CommentEmailNotificationProxy implements CommentNotificationProxy{

    @Override
    public void sendNotification(Comment comment) {
        System.out.println("Send email notification: " + comment.getText());
    }
}

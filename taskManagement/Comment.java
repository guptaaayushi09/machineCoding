package machineCoding.taskManagement;


import java.util.Date;
import java.util.UUID;

public class Comment{
    private final String id;
    private final String content;
    private final User author;
    private final Date timestamp;

    public Comment(String content,User author){
        this.content = content;
        this.author = author;
        this.timestamp = new Date();
        this.id = UUID.randomUUID().toString();
    }

    public User getAuthor(){
        return author;
    }
}
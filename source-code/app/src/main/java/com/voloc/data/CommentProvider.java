package com.voloc.data;

import com.voloc.Model.Comment;

import java.util.Arrays;
import java.util.List;

public class CommentProvider {

    public List<Comment> Commentdisplay() {
        return Arrays.asList(
                new Comment("Hi nice video"),
                new Comment("Impressive"),
                new Comment("Very Nice Explaination"),
                new Comment("The videos are very informative"),
                new Comment("I love VOLOC"),
                new Comment("Can you please provide some Study Materials"),
                new Comment("Voloc")
        );
    }
}

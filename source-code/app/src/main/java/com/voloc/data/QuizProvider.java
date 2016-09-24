package com.voloc.data;

import com.voloc.Model.Quiz;

import java.util.Arrays;
import java.util.List;

public class QuizProvider {

      public List<Quiz> readQuizzes() {
        return Arrays.asList(
                new Quiz("What is the size of registers in 8086 microprocessor","8 bit","16 bit","32 bit"),
                new Quiz("What is the name of John's fathers's only son","Abraham","John","Abby"),
                new Quiz("star", "gun", "bomb","hello"),
                new Quiz("star", "gun", "bomb","hello"),
                new Quiz("star", "gun", "bomb","hello"),
                new Quiz("star", "gun", "bomb","hello"),
                new Quiz("star", "gun", "bomb","hello")
        );
    }
}

package com.voloc.Model;

public class Quiz {
    private final String question,ans1,ans2,ans3;

    public Quiz(String question,String ans1,String ans2,String ans3) {
        this.question = question;
        this.ans1=ans1;
        this.ans2=ans2;
        this.ans3=ans3;
    }

    public String getQuestion() {
        return question;
    }
    public String getAns1() {
        return ans1;
    }
    public String getAns2() {
        return ans2;
    }
    public String getAns3() {
        return ans3;
    }
}

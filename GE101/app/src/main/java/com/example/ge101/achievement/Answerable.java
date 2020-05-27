package com.example.ge101.achievement;

import java.util.ArrayList;

/**
 * an interface to show that object is answerable which means has list of questions and can do tasks
 * with them
 * @author Efe Beydoğan, Arda Önal, Berke Uçar, Mert Barkın Er, Mehmet Alper Çetin
 * @version 12.05.2020
 */
public interface Answerable
{
    public boolean answerQuestion( Answer answer);
    public ArrayList<Answer> getAnswers();
    public void setRightAnswer( Answer rightAnswer );
    public void addAnswer( Answer answer);
    public Answer getRightAnswer();
    public int getQuestionStatus();
}

package com.example.ge101.achievement;

import java.util.ArrayList;

/**
 * An interface to show that the object is achievable by containing questions and doing
 * task with them
 * @author Efe Beydoğan, Arda Önal, Berke Uçar, Mert Barkın Er, Mehmet Alper Çetin
 * @version 12.05.2020
 */
public interface Achievable
{
    public ArrayList<Question> getQuestions();
    public  int getNumCorrectQuestions();
    public int getNumQuestions();
    public Question findQuestion( String name );
    public void addQuestion( Question q);
    public void addQuestion( ArrayList<Question> l);
    public int getNumWrongQuestions();
    public String getName();
}

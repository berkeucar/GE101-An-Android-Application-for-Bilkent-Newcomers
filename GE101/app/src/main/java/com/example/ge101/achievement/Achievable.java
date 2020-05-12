package com.example.ge101.achievement;

import java.util.ArrayList;

/**
 * An interface to show that the object is achievable
 */
public interface Achievable
{
    public ArrayList<Question> getQuestions();
    public  int getNumCorrectQuestions();
    public int getNumQuestions();
    public Question findQuestion( String name );
    public Question findQuestion( Question q );
    public void AddQuestion( Question q);
}

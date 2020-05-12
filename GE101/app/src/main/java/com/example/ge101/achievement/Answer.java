package com.example.ge101.achievement;

/**
 * A simple class for the answers, no methods are available due to security reasons
 * @version 12/5/2020
 */
public class Answer
{
    // properties
    private String answer;
    private String name;

    //constructors
    public Answer( String name, String answer)
    {
        this.answer = answer;
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public boolean equals( Answer a)
    {
        return answer.equals( a.answer );
    }
}

package com.example.ge101.achievement;

/**
 * A simple class for the answers, no methods are available due to security reasons
 * @author Efe Beydoğan, Arda Önal, Berke Uçar, Mert Barkın Er, Mehmet Alper Çetin
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

    public String getAnswer() {
        return answer;
    }

    public boolean equals(Answer a)
    {
        return answer.equals( a.answer );
    }
}

package com.example.ge101.achievement;

import java.util.ArrayList;

/**
 * A class question that implements Answerable. It is the question for Achievements that you can
 * use to create a question. When initialized question status is set to NOT_ANSWERED and if the user
 * enters null as ArrayList it is set to an empty ArrayList due to bug fix
 * @author Efe Beydoğan, Arda Önal, Berke Uçar, Mert Barkın Er, Mehmet Alper Çetin
 * @version 12.05.2020
 */
public class Question implements Answerable
{
    // constants
    public static final int NOT_ANSWERED = 0;
    public static final int ANSWERED_CORRECTLY = 1;
    public static final int ANSWERED_WRONGLY = -1;

    // properties
    private String question;
    private String name;
    private ArrayList<Answer> answers;
    private Answer rightAnswer;
    private int questionStatus;

    public Question( String question, String name)
    {
        this.question = question;
        this.name = name;
        questionStatus = NOT_ANSWERED;
        answers = new ArrayList<Answer>();
    }

    /**
     * answer the question with the given answer, if answer is correct then questionStatus is
     * set to ANSWERED_CORRECTLY if it is wrong then it is set to ANSWERED_WRONGLY
     * @param answer the answer you want the question to try
     * @return return true only if answer is the right answer
     */
    public boolean answerQuestion( Answer answer)
    {
        if (answer.equals(rightAnswer) )
        {
            questionStatus = ANSWERED_CORRECTLY;
            return true;
        }

        else {
            questionStatus = ANSWERED_WRONGLY;
            return false;
        }
    }

    /**
     * answer the question with the given answer name, if answer is correct then questionStatus is
     * set to ANSWERED_CORRECTLY if it is wrong then it is set to ANSWERED_WRONGLY
     * @param answerName name of the answer you want to answer
     * @return return true only if given answerName is equal to rightAnswer's name
     */
    public boolean answerQuestion( String answerName)
    {
        if ( answerName.equals( rightAnswer.getName() ) )
        {
            questionStatus = ANSWERED_CORRECTLY;
            return true;
        }

        else {
            questionStatus = ANSWERED_WRONGLY;
            return false;
        }
    }

    /**
     * A method to get the answers to the question
     * @return answers in an ArrayList
     */
    public ArrayList<Answer> getAnswers()
    {
        return answers;
    }

    public void setRightAnswer( Answer rightAnswer )
    {
        this.rightAnswer = rightAnswer;
    }

    /**
     * Adds the answer to the questions answers
     * @param answer is the answer you want do add
     */
    public void addAnswer( Answer answer)
    {
        answers.add( answer);
    }

    public Answer getRightAnswer()
    {
        return rightAnswer;
    }

    public int getQuestionStatus() {
        return questionStatus;
    }

    public void addAnswer( ArrayList<Answer> l)
    {
        answers.addAll( l);
    }

    public String getName() {
        return name;
    }
}

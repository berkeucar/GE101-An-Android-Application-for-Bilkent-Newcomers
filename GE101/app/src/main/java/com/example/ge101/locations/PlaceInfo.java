package com.example.ge101.locations;

import com.google.android.gms.maps.model.LatLng;
import com.example.ge101.achievement.*;

import java.util.ArrayList;

public class PlaceInfo implements Achievable
{
    // properties
    private String name;
    private String description;
    private LatLng latLng;
    private int imageResource;
    private ArrayList<Question> questions;

    // constructors

    public PlaceInfo(String name, String description, LatLng latLng, int imageResource) {
        this.name = name;
        this.latLng = latLng;
        this.imageResource = imageResource;
        this.description = description;
        questions = new ArrayList<Question>();
    }

    public PlaceInfo() {

    }

    // methods

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    @Override
    public String toString() {
        return "PlaceInfo{" +
                "name='" + name + '\'' +
                ", latLng=" + latLng +
                '}';
    }


    public ArrayList<Question> getQuestions()
    {
        return questions;
    }

    /**
     * Gives number of the correct tried  questions the bag
     * @return number of answered correctly questions
     */
    public  int getNumCorrectQuestions()
    {
        int  count;

        count = 0;
        for( int i = 0; i < questions.size(); i++)
        {
            if( questions.get( i).getQuestionStatus() == Question.ANSWERED_CORRECTLY)
                count++;
        }
        return count;
    }

    /**
     * Rather user answered all of the questions fully
     * @return true only if all of the questions are answered correctly
     */
    public boolean isFullyAchieved()
    {
        return 0 <= getNumQuestions() - getNumCorrectQuestions();
    }

    /**
     * Gives number of the wrongly answered  questions in the bag
     * @return number of answered correctly questions
     */
    public int getNumWrongQuestions()
    {
        return getNumQuestions() - getNumCorrectQuestions();
    }


    public int getNumQuestions()
    {
        return questions.size();
    }

    /**
     * finds question with given Question name
     * @param name question's name
     * @return question with specified name if doesn't exists return null
     */
    public Question findQuestion( String name )
    {
        for( int i = 0; i < questions.size(); i++)
        {
            if( questions.get( i).getName().equals( name) )
                return questions.get( i);
        }
        return null;
    }

    public boolean exists( Question q)
    {
        for( int i = 0; i < questions.size(); i++)
        {
            if( questions.get( i).equals( q) )
                return true;
        }
        return false;
    }

    public void AddQuestion( Question q)
    {
        questions.add( q);
    }

    public void AddQuestion( ArrayList<Question> l)
    {
        questions.addAll( l);
    }
}

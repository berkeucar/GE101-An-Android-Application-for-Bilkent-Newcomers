package com.example.ge101.achievement;

import java.util.ArrayList;

/**
 * An interface to show that it is a list (bag) of Achievable
 */
public interface AchievableBag
{
    public Achievable findByName( String name);
    public Achievable findByQuestion( String questionName);
    public Achievable findByQuestion( Question q);
    public ArrayList getAchievables();
}

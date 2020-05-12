package com.example.ge101.achievement;

import java.util.ArrayList;

/**
 * An interface to show that it is a list (bag) of Achievable
 * @author Efe Beydoğan, Arda Önal, Berke Uçar, Mert Barkın Er, Mehmet Alper Çetin
 * @version 12.05.2020
 */
public interface AchievableBag
{
    public Achievable findByName( String name);
    public Achievable findByQuestion( String questionName);
    public Achievable findByQuestion( Question q);
    public ArrayList getAchievables();
    public int size();
    public Achievable get( int i);
}

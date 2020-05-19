package com.example.ge101.locations;

import com.example.ge101.R;
import com.example.ge101.achievement.Achievable;
import com.example.ge101.achievement.AchievableBag;
import com.example.ge101.achievement.Answer;
import com.example.ge101.achievement.Question;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * A class to hold information about all the places on the map
 * @author Efe Beydoğan, Arda Önal, Berke Uçar, Mert Barkın Er, Mehmet Alper Çetin
 * @version 07.05.2020
 */
public class Places implements AchievableBag {

    // properties
    private ArrayList<PlaceInfo> places;

    // constructors
    public Places(){
        places = new ArrayList<PlaceInfo>();

        // ARDA
        places.add(new PlaceInfo("C - School of English Language", "Description C", new LatLng(39.870664, 32.764916), R.drawable.c));
        places.add(new PlaceInfo("F - Faculty of Art, Design and Architecture", "Description F", new LatLng(39.866846, 32.749273), R.drawable.f));
        places.add(new PlaceInfo("M - Faculty of Business Administration", "Description M", new LatLng(39.867473, 32.750309), R.drawable.m));
        places.add(new PlaceInfo("V - Lecture Halls", "Description V", new LatLng(39.867073, 32.750264), R.drawable.v));
        places.add(new PlaceInfo("Dormitories Management", "çok uzak ", new LatLng(39.863249, 32.749570), R.drawable.noimageavailable));
        places.add(new PlaceInfo("Health Center (Main Campus)", "health center", new LatLng(39.868403, 32.749116), R.drawable.healthcenter));
        places.add(new PlaceInfo("T Building", "audi tt", new LatLng(39.868136, 32.749238), R.drawable.t));
        places.add(new PlaceInfo("Express Cafe (Behind G)", "cafe", new LatLng(39.868626, 32.750389), R.drawable.noimageavailable));
        places.add(new PlaceInfo("Sofa Cafe and Restaurant", "cafe", new LatLng(39.864279, 32.749192), R.drawable.sofa));
        places.add(new PlaceInfo("Mozart Cafe East Campus", "cafe", new LatLng(39.871206, 32.764030), R.drawable.mozarteast));
        places.add(new PlaceInfo("90th Dorm Cafeteria", "cafe", new LatLng(39.868464, 32.763710), R.drawable.ninetiethcafeteria));
        places.add(new PlaceInfo("75th Dorm Canteen", "cafe", new LatLng(39.864171, 32.747722), R.drawable.seventyfifthdormcanteen));
        places.add(new PlaceInfo("Fiero Cafe", "inside a building", new LatLng(39.867899, 32.749448), R.drawable.fierocafe));
        places.add(new PlaceInfo("Sports Fields (East Campus)", "spor", new LatLng(39.870995, 32.762870), R.drawable.eastsportfields));
        places.add(new PlaceInfo("54th Dormitory", "dorm", new LatLng(39.864476, 32.749738), R.drawable.fiftyfourthdorm));
        places.add(new PlaceInfo("55th Dormitory", "dorm", new LatLng(39.864331, 32.749946), R.drawable.fiftyfithdorm));
        places.add(new PlaceInfo("Yapı Kredi Bank", "dorm", new LatLng(39.871280, 32.750170), R.drawable.noimageavailable));
        places.add(new PlaceInfo("Sports International", "expensive", new LatLng(39.883306, 32.762309), R.drawable.sportsinternational));

        //EFE
        places.add( new PlaceInfo( "A Building - Faculty of Economics, \n Administrative, and Social Sciences", "A description", new LatLng(39.867608, 32.749413), R.drawable.abuilding));
        places.add( new PlaceInfo( "EB - Mithat Çoruh Auditorium and Classrooms", "EB description", new LatLng( 39.871752, 32.749718), R.drawable.mithatcoruh));
        places.add( new PlaceInfo( "KM - Library (Main Campus)", "Library description", new LatLng(39.870276, 32.749426), R.drawable.mainlibrary));
        places.add( new PlaceInfo( "Vocational School of Tourism \n and Hotel Services (Blocks A-B-C-D-E)", "desc", new LatLng( 39.874522, 32.761752), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "School of Applied Technology \n and Management (Blocks A-B-C-D-E)", "desc", new LatLng( 39.874625, 32.761876), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "Office of Int. Students and Exchange Prog.", "desc", new LatLng( 39.864763, 32.744490), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "Career Center", "desc", new LatLng( 39.872362, 32.750753), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "Table d'hôte Cafeteria and \n A la Carte Restaurant", "", new LatLng( 39.870585, 32.750547), R.drawable.cafeteria));
        places.add( new PlaceInfo( "Food Court Speed-Kıraç (Main Campus)", "desc", new LatLng( 39.865943, 32.748387), R.drawable.speed));
        places.add( new PlaceInfo( "Mozart Cafe (Middle Campus)", "desc", new LatLng( 39.869365, 32.755092), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "Coffee Break (East Campus)", "desc", new LatLng( 39.874201, 32.761962), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "FMPA Table d'hôte Cafe. (Middle Campus)", "desc", new LatLng( 39.868920, 32.755004), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "East Campus Housing Kiosk - Buffet", "desc", new LatLng( 39.868607, 32.763916), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "Sports Center (East Campus)", "desc", new LatLng( 39.869947, 32.764970), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "Taxi", "desc", new LatLng( 39.867739, 32.756612), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "Dormitory 71", "desc", new LatLng( 39.864179, 32.748628), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "Dormitory 72", "desc", new LatLng( 39.864025, 32.748588), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "Dormitory 73", "desc", new LatLng( 39.863825, 32.748510), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "Dormitory 74", "desc", new LatLng( 39.863625, 32.748516), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "Dormitory 75", "desc", new LatLng( 39.864057, 32.747880), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "Dormitory 76", "desc", new LatLng( 39.864463, 32.747566), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "Dormitory 77", "desc", new LatLng( 39.864367, 32.746592), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "Dormitory 78", "desc", new LatLng( 39.865024, 32.746074), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "Mescit - Masjid", "desc", new LatLng( 39.867307, 32.750792), R.drawable.mescit));
        places.add( new PlaceInfo( "Mescit - Masjid (East Campus)", "desc", new LatLng( 39.871503, 32.764656), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "Ankuva", "", new LatLng( 39.883461, 32.756107), R.drawable.ankuva));

        //BERKE
        places.add( new PlaceInfo( "B Building", "Description B", new LatLng(39.868653, 32.748112), R.drawable.bilkenteatings));
        places.add(new PlaceInfo("EE Building", "Description EE", new LatLng(39.872075, 32.750825), R.drawable.ee));
        places.add(new PlaceInfo("L Buildings", "Description LA", new LatLng(39.869204, 32.749873), R.drawable.lebuildings));
        places.add(new PlaceInfo("SA Building", "Description SA", new LatLng(39.867791, 32.748273), R.drawable.saandsb));
        places.add(new PlaceInfo("SB Building", "Description SB", new LatLng(39.868182, 32.748125), R.drawable.saandsb));
        places.add(new PlaceInfo("International Center", "Description YIM", new LatLng(39.871447, 32.750313), R.drawable.noimageavailable));
        places.add(new PlaceInfo("Security and Civil Defense Office", "Description SCFO", new LatLng(39.864867, 32.744301), R.drawable.noimageavailable));
        places.add(new PlaceInfo("Cafe-In", "Description Cafe-In", new LatLng(39.869930, 32.750604), R.drawable.cafein));
        places.add(new PlaceInfo("Express Cafe", "Description Express Cafe", new LatLng(39.866108, 32.749451), R.drawable.noimageavailable));
        places.add(new PlaceInfo("Le Piment Rouge Restaurant", "Description Le Piment Rouge Restaurant", new LatLng(39.874414, 32.762056), R.drawable.lepiment));
        places.add(new PlaceInfo("Mozart Cafe (East Campus)", "Description Mozart Cafe (East Campus)", new LatLng(39.870813, 32.764836), R.drawable.mozarteast));
        places.add(new PlaceInfo("Coffee Break (Main Campus Library)", "Description Coffee Break (Main Campus Library)", new LatLng(39.870417, 32.749650), R.drawable.cbmainlibrary));
        places.add(new PlaceInfo("Coffee Break (Main Campus L Buildings)", "Description Coffee Break (Main Campus L Buildings)", new LatLng(39.869301, 32.749901), R.drawable.cblbuilding));
        places.add(new PlaceInfo("Stadium", "Description Stadium", new LatLng(39.864366, 32.743395), R.drawable.stadiium));
        places.add(new PlaceInfo("Dormitory 50", "Description Dormitory 50", new LatLng(39.865083, 32.749348), R.drawable.fiftyfiftyone));
        places.add(new PlaceInfo("Dormitory 51", "Description Dormitory 51", new LatLng(39.864843, 32.749850), R.drawable.fiftyfiftyone));
        places.add(new PlaceInfo("Dormitory 52", "Description Dormitory 52", new LatLng(39.864843, 32.749850), R.drawable.fiftytwo));
        places.add(new PlaceInfo("Dormitory 90", "Description Dormitory 90", new LatLng(39.868697, 32.764198), R.drawable.ninety));
        places.add(new PlaceInfo("Dormitory 91", "Description Dormitory 91", new LatLng(39.869091, 32.763804), R.drawable.ninetyone));
        places.add(new PlaceInfo("Dormitory 92", "Description Dormitory 92", new LatLng(39.869397, 32.763338), R.drawable.ninetytwo));
        places.add(new PlaceInfo("Dormitory 93", "Description Dormitory 93", new LatLng(39.870093, 32.763220), R.drawable.ninetythree));
        places.add(new PlaceInfo("CyberPark Block A", "Description CyberPark Block A", new LatLng(39.869742, 32.744537), R.drawable.cyberaandb));
        places.add(new PlaceInfo("CyberPark Block B", "Description CyberPark Block B", new LatLng(39.869617, 32.745466), R.drawable.cyberaandb));
        places.add(new PlaceInfo("CyberPark Block C", "Description CyberPark Block C", new LatLng(39.870043, 32.744532), R.drawable.cyberparkc));
        places.add(new PlaceInfo("CyberPark Block D", "Description CyberPark Block D", new LatLng(39.878306, 32.746875), R.drawable.noimageavailable));

        //MERT
        places.add( new PlaceInfo( "D Building", "English Language School", new LatLng( 39.870547, 32.764879), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "G Building", "Faculty of Education", new LatLng( 39.868738, 32.749516), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "N Building", "School of English Language / Library", new LatLng( 39.872877, 32.763123), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "Student Activities Center", "Student Activities Center", new LatLng( 39.872676, 32.750325), R.drawable.noimageavailable));
        places.add( new PlaceInfo("Pharmacy", "Pharmacy in T building", new LatLng(39.867339, 32.749430), R.drawable.t));
        places.add( new PlaceInfo("Coffee Break", "Coffee Break in T building", new LatLng(39.868290, 32.749084), R.drawable.t));
        places.add( new PlaceInfo("Sözeri", "Sözeri Kebab", new LatLng(39.865496, 32.744361), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "Mozart Cafe (N Building)", "Mozart Cafe in N building", new LatLng( 39.872877, 32.763123), R.drawable.noimageavailable));
        places.add( new PlaceInfo("Mozart Cafe (EE Building)", "Mozart Cafe in EE building", new LatLng(39.872200, 32.750596), R.drawable.ee));
        places.add( new PlaceInfo( "76th Dorm Canteen", "76th Dorm Canteen", new LatLng( 39.864382, 32.747763), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "Sports Center", "Student Dormitories Sports Center", new LatLng(39.863848, 32.745551), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "414th Bus Stop", "414th Bus Stop", new LatLng( 39.865257, 32.748278), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "413th Bus Stop", "413th Bus Stop", new LatLng( 39.873220, 32.748966), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "412th Bus Stop", "412th Bus Stop", new LatLng( 39.871750, 32.748976), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "411th Bus Stop", "411th Bus Stop", new LatLng( 39.869473, 32.747713), R.drawable.noimageavailable));
        places.add( new PlaceInfo("Dormitory 60", "Dormitory 60", new LatLng(39.864001, 32.749770), R.drawable.noimageavailable));
        places.add( new PlaceInfo("Dormitory 61", "Dormitory 61", new LatLng(39.863851, 32.749543), R.drawable.noimageavailable));
        places.add( new PlaceInfo("Dormitory 62", "Dormitory 62", new LatLng(39.863646, 32.749726), R.drawable.noimageavailable));
        places.add( new PlaceInfo("Dormitory 63", "Dormitory 63", new LatLng(39.863516, 32.749572), R.drawable.noimageavailable));
        places.add( new PlaceInfo("Dormitory 64", "Dormitory 64", new LatLng(39.863453, 32.749101), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "Meteksan Market", "Meteksan Market in Main Campus", new LatLng( 39.873266, 32.750809), R.drawable.noimageavailable));
        places.add( new PlaceInfo( "Bilkent Hotel", "Bilkent Hotel", new LatLng( 39.875130, 32.762808), R.drawable.noimageavailable));

        //ALPER
        places.add( new PlaceInfo("EA Building", "to be written" , new LatLng(39.871064, 32.749939), R.drawable.ea ) );
        places.add( new PlaceInfo("H Building", "to be written" , new LatLng(39.868029, 32.749538), R.drawable.h) );
        places.add( new PlaceInfo("P building", "to be written" , new LatLng(39.8692297,32.7548412), R.drawable.p) );
        places.add( new PlaceInfo("ODN Building", "to be written" , new LatLng(39.875497, 32.751987), R.drawable.odn) );
        places.add( new PlaceInfo("Registrar's Office", "to be written" , new LatLng(39.8645819,32.7443788), R.drawable.registrar_s_office) );
        places.add( new PlaceInfo("Psychological Counseling and Development Center", "to be written" , new LatLng(39.8755254,32.7511509), R.drawable.pdgm) );
        places.add( new PlaceInfo("Health Center", "to be written" , new LatLng(39.871120, 32.764683), R.drawable.c) );
        places.add( new PlaceInfo("Mozart Cafe (B Building)", "to be written" , new LatLng(39.868760, 32.748059), R.drawable.mozart_cafe) );
        places.add( new PlaceInfo("Coffee Break (Building V)", "to be written" , new LatLng(39.866908, 32.749962), R.drawable.coffe_break) );
        places.add( new PlaceInfo("Bilintur Catering Centre", "to be written" , new LatLng(39.872140, 32.764232), R.drawable.bilintur) );
        places.add( new PlaceInfo("Starbucks Coffee", "to be written" , new LatLng(39.865912, 32.748988), R.drawable.starbucks_coffe) );
        places.add( new PlaceInfo("Main Sports Hall", "to be written" , new LatLng(39.866757, 32.748512), R.drawable.main_sports_hall) );
        places.add( new PlaceInfo("Dormitory 69", "to be written" , new LatLng(39.864568, 32.749128), R.drawable.d_69) );
        places.add( new PlaceInfo("Dormitory 70", "to be written" , new LatLng(39.864065, 32.749165), R.drawable.d_70) );
        places.add( new PlaceInfo("Meteksan Bookstore", "to be written" , new LatLng(39.866355, 32.748627), R.drawable.meteksan_bookstore) );
        places.add( new PlaceInfo("PTT", "to be written" , new LatLng(39.864448, 32.744608), R.drawable.noimageavailable) );
        places.add( new PlaceInfo("Bilkent Center", "to be written" , new LatLng(39.884095, 32.758720), R.drawable.bilkent_center) );
        places.add( new PlaceInfo( "Bus Stop 1 (East Campus)", "to be written", new LatLng(39.871632, 32.762936), R.drawable.buslogoblack));
        places.add( new PlaceInfo( "Bus Stop 2 (East Campus)", "to be written", new LatLng(39.870405, 32.765114), R.drawable.buslogoblack));
        PlaceInfo placeInfo =  new PlaceInfo( "Bus Stop Buffet", "to be written", new LatLng(39.869587, 32.746941), R.drawable.noimageavailable );
        places.add( placeInfo );

        // Adding a question for testing
        Question q;
        q = new Question( "Just a test question!", "building_c_q1");
        q.addAnswer( new Answer( "c_q1_a1", "This is not right answer"));
        q.addAnswer( new Answer("c_q1_a2", "This is more likely to be the right answer"));
        q.addAnswer( new Answer(" c_q1_a3", "This is the right answer"));
        q.setRightAnswer( q.getAnswers().get( 2) );
        findByName( "Starbucks Coffee").addQuestion( q);
    }

    // methods

    /**
     * The method that returns places ArrayList
     * @return the places ArrayList
     */
    public ArrayList<PlaceInfo> getPlaces() {
        return places;
    }

    /**
     * finds the achievable with given name
     * @param name name of the Achievable
     * @return Achievable with given name, return null if DNE
     */
    public Achievable findByName(String name)
    {
        for( int i = 0; i < places.size(); i++)
        {
            if( places.get( i ).getName().equals( name) )
                return places.get( i);
        }
        return null;
    }

    /**
     *  find the Achievable by question name that it contains
     * @param questionName the question's name that Achievable contains
     * @return
     */
    public Achievable findByQuestion( String questionName)
    {
        for ( int i = 0; i < places.size(); i++)
        {
            if( places.get( i).findQuestion( questionName ) != null)
                return places.get( i);
        }
        return null;
    }

    /**
     * find the Achievable by Question given
     * @param q the question that Achievable contains
     * @return the Achievable that contains question, return null if DNE
     */
    public Achievable findByQuestion( Question q )
    {
        for ( int i = 0; i < places.size(); i++)
        {
            if( places.get( i).exists( q))
                return places.get( i);
        }
        return null;
    }

    public ArrayList getAchievables()
    {
        return places;
    }
    public int size()
    {
        return places.size();
    }
    public Achievable get( int i)
    {
        return places.get( i);
    }
    /**
     * Creates a ArrayList of strings from given AchievableBag so that it can be use to make a pane
     * @param a the AchievableBag you want it to get
     * @return the string of  ArrayList of names of every single element in AchievableBag
     * with number of correct questions/ number of questions
     */
    public static ArrayList<String> makePaneString( AchievableBag a)
    {
        Achievable x;
        ArrayList<String> copy = new ArrayList<String>();
        for ( int i = 0; i < a.size(); i++)
        {
            x = a.get( i);
            copy.add( x.getName() + " " + x.getNumCorrectQuestions() + "/" + x.getNumQuestions() );
        }
        return copy;
    }
}

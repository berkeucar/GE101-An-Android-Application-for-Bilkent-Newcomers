package locations;

import com.example.ge101.R;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * A class to hold information about all the places on the map
 * @author Efe Beydoğan, Arda Önal, Berke Uçar, Mert Barkın Er, Mehmet Alper Çetin
 * @version 07.05.2020
 */
public class Places {

    // properties
    private ArrayList<PlaceInfo> places;


    // constructors
    public Places(){
        places = new ArrayList<PlaceInfo>();

        // ARDA
        places.add(new PlaceInfo("C - School of English Language", "Description C", new LatLng(39.870564, 32.764916), R.drawable.c));
        places.add(new PlaceInfo("F - Faculty of Art, Design and Architecture", "Description F", new LatLng(39.866846, 32.749273), R.drawable.f));
        places.add(new PlaceInfo("M - Faculty of Business Administration", "Description M", new LatLng(39.867473, 32.750309), R.drawable.m));
        places.add(new PlaceInfo("V - Lecture Halls", "Description V", new LatLng(39.867073, 32.750264), R.drawable.v));
        places.add(new PlaceInfo("Dormitories Management", "çok uzak aq", new LatLng(39.863249, 32.749570), R.drawable.noimageavailable));
        places.add(new PlaceInfo("Health Center (Main Campus)", "health center", new LatLng(39.868244, 32.749063), R.drawable.healthcenter));
        places.add(new PlaceInfo("T Building", "audi tt", new LatLng(39.867339, 32.749430), R.drawable.t));
        places.add(new PlaceInfo("Express Cafe (Behind G)", "cafe", new LatLng(39.868626, 32.750389), R.drawable.noimageavailable));
        places.add(new PlaceInfo("Sofa Cafe and Restaurant", "cafe", new LatLng(39.864279, 32.749192), R.drawable.sofa));
        places.add(new PlaceInfo("Mozart Cafe East Campus", "cafe", new LatLng(39.871206, 32.764030), R.drawable.mozarteast));
        places.add(new PlaceInfo("90th Dorm Cafeteria", "cafe", new LatLng(39.868464, 32.763710), R.drawable.ninetiethcafeteria));
        places.add(new PlaceInfo("75th Dorm Canteen", "cafe", new LatLng(39.864171, 32.747722), R.drawable.seventyfifthdormcanteen));
        places.add(new PlaceInfo("Fiero Cafe", "inside a building", new LatLng(39.867969, 32.749448), R.drawable.fierocafe));
        places.add(new PlaceInfo("Sports Fields (East Campus)", "spor", new LatLng(39.870995, 32.762870), R.drawable.eastsportfields));
        places.add(new PlaceInfo("54th Dormitory", "dorm", new LatLng(39.864476, 32.749738), R.drawable.fiftyfourthdorm));
        places.add(new PlaceInfo("55th Dormitory", "dorm", new LatLng(39.864331, 32.749946), R.drawable.fiftyfithdorm));
        places.add(new PlaceInfo("Yapı Kredi Bank", "dorm", new LatLng(39.871380, 32.750170), R.drawable.noimageavailable));
        places.add(new PlaceInfo("Sports International", "expensive", new LatLng(39.883306, 32.762309), R.drawable.sportsinternational));






















        //EFE








































        //BERKE
        places.add( new PlaceInfo( "B Building", "Description B", new LatLng(39.868653, 32.748112), R.drawable.bilkenteatings));
        places.add(new PlaceInfo("EE Building", "Description EE", new LatLng(39.872100, 32.750596), R.drawable.ee));
        places.add(new PlaceInfo("L Buildings", "Description LA", new LatLng(39.869304, 32.749873), R.drawable.lebuildings));
        places.add(new PlaceInfo("SA Building", "Description SA", new LatLng(39.867791, 32.748273), R.drawable.saandsb));
        places.add(new PlaceInfo("SB Building", "Description SB", new LatLng(39.868182, 32.748125), R.drawable.saandsb));
        places.add(new PlaceInfo("International Center", "Description YIM", new LatLng(39.871447, 32.750313), R.drawable.noimageavailable));
        places.add(new PlaceInfo("Security and Civil Defense Office", "Description SCFO", new LatLng(39.864867, 32.744301), R.drawable.noimageavailable));
        places.add(new PlaceInfo("Cafe-In", "Description Cafe-In", new LatLng(39.869930, 32.750604), R.drawable.cafein));
        places.add(new PlaceInfo("Express Cafe", "Description Express Cafe", new LatLng(39.866108, 32.749451), R.drawable.noimageavailable));
        places.add(new PlaceInfo("Le Piment Rouge Restaurant", "Description Le Piment Rouge Restaurant", new LatLng(39.874414, 32.762056), R.drawable.lepiment));
        places.add(new PlaceInfo("Mozart Cafe (East Campus)", "Description Mozart Cafe (East Campus)", new LatLng(39.870614, 32.764833), R.drawable.mozarteast));
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








































        //ALPER









































    }



    // methods

    /**
     * The method that returns places ArrayList
     * @return the places ArrayList
     */
    public ArrayList<PlaceInfo> getPlaces() {
        return places;
    }
}

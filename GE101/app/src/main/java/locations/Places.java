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

        places.add( new PlaceInfo( "B binası", "B building is very nice \nh\nh\nh\nh\nh\nh\nh", new LatLng(39.868653, 32.748112), R.drawable.bilkenteatings));
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

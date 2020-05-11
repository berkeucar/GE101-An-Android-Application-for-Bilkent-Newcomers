package com.example.ge101.customlabels;

import com.example.ge101.R;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * A class for labels
 * @author Efe Beydoğan, Arda Önal, Berke Uçar, Mert Barkın Er, Mehmet Alper Çetin
 * @version 11.05.2020
 */
public class CustomLabels {

    // properties
    private final float WIDTH = 100f;
    private final float HEIGHT = 20f;
    private ArrayList<GroundOverlayOptions> labels;


    // constructors

    public CustomLabels() {
        labels = new ArrayList<GroundOverlayOptions>();

        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.nobackgroundlabel)).position( new LatLng( 39.8685839,32.7494154 ), WIDTH, HEIGHT));
    }

    // methods

    /**
     * A method to get label images
     * @return labels array
     */
    public ArrayList<GroundOverlayOptions> getLabels() {
        return labels;
    }
}

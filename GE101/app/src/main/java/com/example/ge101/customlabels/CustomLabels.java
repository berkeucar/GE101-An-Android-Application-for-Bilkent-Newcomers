package com.example.ge101.customlabels;

import com.example.ge101.R;
import com.example.ge101.locations.Places;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;

import java.util.ArrayList;

/**
 * A class for labels
 * @author Efe Beydoğan, Arda Önal, Berke Uçar, Mert Barkın Er, Mehmet Alper Çetin
 * @version 11.05.2020
 */
public class CustomLabels {

    // properties
    private final float WIDTH = 110f;
    private final float HEIGHT = 30f;
    private ArrayList<GroundOverlayOptions> labels;
    private Places places;


    // constructors

    public CustomLabels() {
        labels = new ArrayList<GroundOverlayOptions>();
        places = new Places();


        // ARDA
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.clabel)).position( places.getPlaces().get(0).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.flabel)).position( places.getPlaces().get(1).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.mlabel)).position( places.getPlaces().get(2).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.vlabel)).position( places.getPlaces().get(3).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.dormmanlabel)).position( places.getPlaces().get(4).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.healthcentermainlabel)).position( places.getPlaces().get(5).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.tlabel)).position( places.getPlaces().get(6).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.expresslabel)).position( places.getPlaces().get(7).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.sofalabel)).position( places.getPlaces().get(8).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.mozartlabel)).position( places.getPlaces().get(9).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.nintiethdormcafelabel)).position( places.getPlaces().get(10).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.seventyfifthdormcanteenlabel)).position( places.getPlaces().get(11).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.fireolabel)).position( places.getPlaces().get(12).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.sportsfieldslabel)).position( places.getPlaces().get(13).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.fiftyfourthdormlabel)).position( places.getPlaces().get(14).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.fiftyfifthdormlabel)).position( places.getPlaces().get(15).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.yapikredilabel)).position( places.getPlaces().get(16).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.sportsinterlabel)).position( places.getPlaces().get(17).getLatLng(), WIDTH, HEIGHT));



        // EFE
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.abuildingmap)).position( places.getPlaces().get(18).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.ebmap)).position( places.getPlaces().get(19).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.kmmap)).position( places.getPlaces().get(20).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.schooloftourismmap)).position( places.getPlaces().get(21).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.appliedtechnologymap)).position( places.getPlaces().get(22).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.officeofstudentsmap)).position( places.getPlaces().get(23).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.careercentermap)).position( places.getPlaces().get(24).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.cafeteriamap)).position( places.getPlaces().get(25).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.speedmap)).position( places.getPlaces().get(26).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.mozartmiddlemap)).position( places.getPlaces().get(27).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.coffeebreakeastmap)).position( places.getPlaces().get(28).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.fmpamap)).position( places.getPlaces().get(29).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.eastcampuskioskmap)).position( places.getPlaces().get(30).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.sportseastmap)).position( places.getPlaces().get(31).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.taximap)).position( places.getPlaces().get(32).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.dorm71map)).position( places.getPlaces().get(33).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.dorm72map)).position( places.getPlaces().get(34).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.dorm73map)).position( places.getPlaces().get(35).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.dorm74map)).position( places.getPlaces().get(36).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.dorm75map)).position( places.getPlaces().get(37).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.dorm76map)).position( places.getPlaces().get(38).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.dorm77map)).position( places.getPlaces().get(39).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.dorm78map)).position( places.getPlaces().get(40).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.mescitmap)).position( places.getPlaces().get(41).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.mesciteastmap)).position( places.getPlaces().get(42).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.ankuvamap)).position( places.getPlaces().get(43).getLatLng(), WIDTH, HEIGHT));





        // BERKE










        // MERT








        // ALPER


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

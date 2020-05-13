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
    private final float WIDTH = 50f;
    private final float HEIGHT = 10f;
    private ArrayList<GroundOverlayOptions> labels;
    private Places places;


    // constructors

    public CustomLabels( Places places) {
        labels = new ArrayList<GroundOverlayOptions>();
        this.places = places;


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
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.blabel)).position( places.getPlaces().get(44).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.eelabel)).position( places.getPlaces().get(45).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.llabel)).position( places.getPlaces().get(46).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.salabel)).position( places.getPlaces().get(47).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.sblabel)).position( places.getPlaces().get(48).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.intcenterlabel)).position( places.getPlaces().get(49).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.seccivillabel)).position( places.getPlaces().get(50).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.cafeinlabel)).position( places.getPlaces().get(51).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.expresslabel)).position( places.getPlaces().get(52).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.lepimentlabel)).position( places.getPlaces().get(53).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.mozarteastlabel)).position( places.getPlaces().get(54).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.cblibrarylabel)).position( places.getPlaces().get(55).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.cblbuildinglabel)).position( places.getPlaces().get(56).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.stadiumlabel)).position( places.getPlaces().get(57).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.dormfiftylabel)).position( places.getPlaces().get(58).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.dormfiftyonelabel)).position( places.getPlaces().get(59).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.dormfiftytwolabel)).position( places.getPlaces().get(60).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.dormninetylabel)).position( places.getPlaces().get(61).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.dormninetyonelabel)).position( places.getPlaces().get(62).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.dormitoryninetytwolabel)).position( places.getPlaces().get(63).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.dormninetythreelabel)).position( places.getPlaces().get(64).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.cyberalabel)).position( places.getPlaces().get(65).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.cyberblabel)).position( places.getPlaces().get(66).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.cyberclabel)).position( places.getPlaces().get(67).getLatLng(), WIDTH, HEIGHT));
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.cyberdlabel)).position( places.getPlaces().get(68).getLatLng(), WIDTH, HEIGHT));










        // MERT








        // ALPER
        int counting;
        counting = 91;
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.alp2__0_)).position( places.getPlaces().get( counting).getLatLng(), WIDTH, HEIGHT));
        counting++;
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.alp2__1_)).position( places.getPlaces().get( counting).getLatLng(), WIDTH, HEIGHT));
        counting++;
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.alp2__2_)).position( places.getPlaces().get( counting).getLatLng(), WIDTH, HEIGHT));
        counting++;
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.alp2__3_)).position( places.getPlaces().get( counting).getLatLng(), WIDTH, HEIGHT));
        counting++;
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.alp2__4_)).position( places.getPlaces().get( counting).getLatLng(), WIDTH, HEIGHT));
        counting++;
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.alp2__5_)).position( places.getPlaces().get( counting).getLatLng(), WIDTH, HEIGHT));
        counting++;
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.alp2__6_)).position( places.getPlaces().get( counting).getLatLng(), WIDTH, HEIGHT));
        counting++;
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.alp2__7_)).position( places.getPlaces().get( counting).getLatLng(), WIDTH, HEIGHT));
        counting++;
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.alp2__8_)).position( places.getPlaces().get( counting).getLatLng(), WIDTH, HEIGHT));
        counting++;
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.alp2__9_)).position( places.getPlaces().get( counting).getLatLng(), WIDTH, HEIGHT));
        counting++;
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.alp2__10_)).position( places.getPlaces().get( counting).getLatLng(), WIDTH, HEIGHT));
        counting++;
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.alp2__11_)).position( places.getPlaces().get( counting).getLatLng(), WIDTH, HEIGHT));
        counting++;
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.alp2__12_)).position( places.getPlaces().get( counting).getLatLng(), WIDTH, HEIGHT));
        counting++;
        labels.add( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.alp2__13_)).position( places.getPlaces().get( counting).getLatLng(), WIDTH, HEIGHT));
        counting++;
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.alp2__14_)).position( places.getPlaces().get( counting).getLatLng(), WIDTH, HEIGHT));
        counting++;
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.alp2__15_)).position( places.getPlaces().get( counting).getLatLng(), WIDTH, HEIGHT));
        counting++;
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.alp2__16_)).position( places.getPlaces().get( counting).getLatLng(), WIDTH, HEIGHT));
        counting++;
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.bustop)).position( places.getPlaces().get( counting).getLatLng(), WIDTH, HEIGHT));
        counting++;
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.bustop)).position( places.getPlaces().get( counting).getLatLng(), WIDTH, HEIGHT));
        counting++;
        labels.add ( new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.bus_stop_buffet)).position( places.getPlaces().get( counting).getLatLng(), WIDTH, HEIGHT));








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

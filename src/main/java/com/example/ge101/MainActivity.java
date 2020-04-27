package com.example.ge101;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync( this);
    }    public void onMapReady( GoogleMap googleMap) {


        @Override
        map = googleMap;

        LatLng BilkentUni = new LatLng( 39.8685839,32.7494154);
        map.addMarker( new MarkerOptions().position(BilkentUni).title( "Bilkent University"));
        float zoomLevel = (float) 19.0;
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(BilkentUni, zoomLevel));

        LatLngBounds Bilkent = new LatLngBounds( new LatLng(39.8656549,32.7426828), new LatLng(39.8739347,32.7643047));
        map.setLatLngBoundsForCameraTarget(Bilkent);
    }

    public void onZoom( View view) {
        if(view.getId() == R.id.zoomIn) {
            map.animateCamera(CameraUpdateFactory.zoomIn());
        }
        if ( view.getId() == R.id.zoomOut) {
            map.animateCamera(CameraUpdateFactory.zoomOut());
        }
    }
}

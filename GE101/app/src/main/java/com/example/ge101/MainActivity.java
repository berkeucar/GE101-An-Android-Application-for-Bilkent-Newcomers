package com.example.ge101;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ge101.adapter.PlaceAutoSuggestAdapter;
import com.example.ge101.busSchedule.BusScheduleTab;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    // properties
    private GoogleMap map;
    private static final String TAG = "MapActivity";
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private Boolean mLocationPermissionsGranted = false;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private static final float DEFAULT_ZOOM = 15f;
    private ImageView busSchedule;

    private static final String[] COUNTRIES = new String[] { "B binası", "bull", "best"};


    // widgets
    //private EditText mSearchText;
    private ImageView mGps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mSearchText = (EditText) findViewById(R.id.input_search);
        mGps = (ImageView) findViewById(R.id.ic_gps);
        getLocationPermission();

        AutoCompleteTextView editText = (AutoCompleteTextView) findViewById(R.id.activity_chooser_view_content);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, COUNTRIES );
        editText.setAdapter(adapter);




        //AutoCompleteTextView.setAdapter(new PlaceAutoSuggestAdapter( MainActivity.this, android.R.layout.simple_list_item_1));


    }

    private void init() {
        Log.d(TAG, "init: initializing");

        //mSearchText.setOnEditorActionListener( new TextView.OnEditorActionListener() {
          //  @Override
           // public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
             //  if (actionId == EditorInfo.IME_ACTION_SEARCH
               //         || actionId == EditorInfo.IME_ACTION_DONE
                 //       || keyEvent.getAction() == KeyEvent.ACTION_DOWN
                   //     || keyEvent.getAction() == KeyEvent.KEYCODE_ENTER) {
                    // execute our method for searching
                    //geoLocate();
                //}
                //return false;
            //}
        //});

        mGps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked gps icon");
                getDeviceLocation();
            }
        });

        setBusSchedule();

        hideSoftKeyboard();
    }

    //private void geoLocate() {
      //  Log.d( TAG, "geoLocate: geolocating");

       // String searchString = mSearchText.getText().toString();

        //Geocoder geocoder = new Geocoder(MainActivity.this);
        //List<Address> list = new ArrayList<>();
        //try {
          //list = geocoder.getFromLocationName( searchString, 1);
        //}
        //catch (IOException e) {
          //  Log.e(TAG, "geoLocate: IOException " + e.getMessage());
        //}

        //if ( list.size() > 0) {
          //  Address address = list.get(0);

            //Log.d( TAG, "geoLocate: found a location " + address.toString() );
            // Toast.makeText( this, address.toString(), Toast.LENGTH_SHORT).show();

            //moveCamera( new LatLng( address.getLatitude(), address.getLongitude()), DEFAULT_ZOOM, address.getAddressLine(0));
        //}
    //}

    private void initMap() {
        Log.d( TAG, "initMap: initializing map");
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync( this);
    }

    @Override
    public void onMapReady( GoogleMap googleMap) {
        Toast.makeText( this, "Map is ready", Toast.LENGTH_SHORT).show();
        Log.d( TAG, "onMapReady: map is ready");
        map = googleMap;

        // Set Bilkent's coordinates
        LatLng BilkentUni = new LatLng( 39.8685839,32.7494154);
        // Add a marker on Bilkent University
        map.addMarker( new MarkerOptions().position(BilkentUni).title( "Bilkent University"));
        float zoomLevel = (float) 19.0;
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(BilkentUni, zoomLevel));

        // Restrict the map to only Bilkent University
        // Commenting these out for now
        // LatLngBounds Bilkent = new LatLngBounds( new LatLng(39.8656549,32.7426828), new LatLng(39.8739347,32.7643047));
        // map.setLatLngBoundsForCameraTarget(Bilkent);

        if( mLocationPermissionsGranted) {
            getDeviceLocation();

            if ( ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            map.setMyLocationEnabled( true);
            map.getUiSettings().setMyLocationButtonEnabled(false);

            init();
        }
    }

    public void onZoom( View view) {
        if(view.getId() == R.id.zoomIn) {
            map.animateCamera(CameraUpdateFactory.zoomIn());
        }
        if ( view.getId() == R.id.zoomOut) {
            map.animateCamera(CameraUpdateFactory.zoomOut());
        }
    }

    public void setBusSchedule() {
        busSchedule = (ImageView) findViewById(R.id.busSchedule);
        busSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BusScheduleTab.class);
                startActivity(intent);
            }
        });
    }


    private void getLocationPermission() {
        Log.d(TAG, "getLocationPermission: getting location permissions");
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};

        if (ContextCompat.checkSelfPermission(this.getApplicationContext(), FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(this.getApplicationContext(), COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mLocationPermissionsGranted = true;
                initMap();
            }
            else {
                ActivityCompat.requestPermissions(this, permissions, LOCATION_PERMISSION_REQUEST_CODE);
            }
        }
        else {
                ActivityCompat.requestPermissions(this, permissions, LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d( TAG, "onRequestPermissionResult: called.");
        mLocationPermissionsGranted = false;

        switch( requestCode) {
            case LOCATION_PERMISSION_REQUEST_CODE: {
                if ( grantResults.length > 0) {
                    for ( int i = 0; i < grantResults.length; i++) {
                        if ( grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                            mLocationPermissionsGranted = false;
                            Log.d( TAG, "onRequestPermissionResult: permission failed");
                            return;
                        }
                    }
                    Log.d( TAG, "onRequestPermissionResult: permission granted");
                    mLocationPermissionsGranted = true;
                    // initialize map
                    initMap();
                }
            }
        }
    }

    private void getDeviceLocation() {
        Log.d( TAG, "getDeviceLocation: getting the device's current location");

        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        try {
            if ( mLocationPermissionsGranted ) {
                Task location = mFusedLocationProviderClient.getLastLocation();
                location.addOnCompleteListener( new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if ( task.isSuccessful()) {
                            Log.d( TAG, "onComplete: found location!");
                            Location currentLocation = (Location) task.getResult();

                            moveCamera( new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()), DEFAULT_ZOOM,  "My Location");
                        }
                        else {
                            Log.d( TAG, "onComplete: current location is null");
                            Toast.makeText( MainActivity.this, "unable to get current location", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        } catch (SecurityException e) {
            Log.e( TAG, "getDeviceLocation: SecurityException: " + e.getMessage() );
        }
    }

    private void moveCamera( LatLng latLng, float zoom, String title) {
        Log.d( TAG, "moveCamera: moving the camera to: lat: " + latLng.latitude + ", lng: " + latLng.longitude);
        map.moveCamera( CameraUpdateFactory.newLatLngZoom( latLng, zoom) );

        if ( !title.equals( "My Location")) {
            MarkerOptions options = new MarkerOptions().position( latLng).title( title);
            map.addMarker( options);
        }
        hideSoftKeyboard();
    }

    private void hideSoftKeyboard() {
        this.getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}

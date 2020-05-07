package com.example.ge101;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ge101.busSchedule.BusScheduleTab;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;

import customMarkers.CustomInfoWindowAdapter;
import locations.PlaceInfo;
import locations.Places;

/**
 * This is the map class
 * @author Efe Beydoğan, Arda Önal, Mert Barkın Er, Berke Uçar, Mehmet Alper Çetin
 * @version 06.05.2020
 */

public class MainActivity extends FragmentActivity implements OnMapReadyCallback, AdapterView.OnItemClickListener {

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
    private long mLastClickTime = 0;
    private Marker marker;

    private ArrayList<String> buildings;
    private Places places;

    // widgets
    //private EditText mSearchText;
    private ImageView mGps;

    // methods

    /**
     * Fixed method that initializes variables and gets permissions
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mSearchText = (EditText) findViewById(R.id.input_search);
        // Initialize the GPS button that locks on user location when pressed
        mGps = (ImageView) findViewById(R.id.ic_gps);
        // Get the permission from user to receive location information
        getLocationPermission();

        places = new Places();
        buildings = new ArrayList<String>();
        // Add the names of every building to an ArrayList for the search bar
        for ( int i = 0; i < places.getPlaces().size(); i++) {
            buildings.add( places.getPlaces().get(i).getName());
        }

        // This is the search bar that has autocomplete text view
        AutoCompleteTextView editText = (AutoCompleteTextView) findViewById(R.id.activity_chooser_view_content);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, buildings );
        editText.setAdapter(adapter);
        editText.setOnItemClickListener( this);

        //AutoCompleteTextView.setAdapter(new PlaceAutoSuggestAdapter( MainActivity.this, android.R.layout.simple_list_item_1));
    }

    /**
     * The method that initializes the buttons on the map
     */
    private void init() {
        Log.d(TAG, "init: initializing");

        // Add a click listener on gps button for it to function
        mGps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked gps icon");
                getDeviceLocation();
            }
        });
        // Sets the bus schedule
        setBusSchedule();
        // This is useless for now
        hideSoftKeyboard();
    }


    /**
     * The method that initializes the map
     */
    private void initMap() {
        Log.d( TAG, "initMap: initializing map");
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync( this);
    }

    /**
     * The method to get the user location and initialize the map and moves the camera, sets the map styling
     * @param googleMap
     */
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

        // If the user granted permission, receive the location
        if( mLocationPermissionsGranted) {
            getDeviceLocation();

            if ( ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            // Show the user location on the map
            map.setMyLocationEnabled( true);
            map.getUiSettings().setMyLocationButtonEnabled(false);

            try {
                // Customise the styling of the base map using a JSON object defined
                // in a raw resource file.
                boolean success = googleMap.setMapStyle(
                        MapStyleOptions.loadRawResourceStyle(
                                this, R.raw.custommap));
                if (!success) {
                    Log.e(TAG, "Style parsing failed.");
                }
            } catch (Resources.NotFoundException e) {
                Log.e(TAG, "Can't find style. Error: ", e);
            }
            // Initialize the map
            init();

        }
    }

    /**
     * Sets the zoom buttons
     * @param view
     */
    public void onZoom( View view) {
        // Set the zoom in button so when it is pressed it zooms in
        if(view.getId() == R.id.zoomIn) {
            map.animateCamera(CameraUpdateFactory.zoomIn());
        }
        // Set the zoom out button so when it is pressed it zooms out
        if ( view.getId() == R.id.zoomOut) {
            map.animateCamera(CameraUpdateFactory.zoomOut());
        }
    }

    /**
     * Sets the bus schedule button that leads to bus schedule page
     */
    public void setBusSchedule() {
        // Initialize the bus schedule button
        busSchedule = (ImageView) findViewById(R.id.busSchedule);
        // Add a click listener so the button opens the bus schedule page
        busSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Preventing multiple clicks, using threshold of 1 second
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                // Start bus schedule page when the button is pressed
                Intent intent = new Intent(MainActivity.this, BusScheduleTab.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Gets the location permission from the user
     */
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

    /**
     * Checks is necessary permissions are granted and initializes the map
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
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

    /**
     * Gets the device location if permission is granted
     */
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

    /**
     * Moves camera to a specific latitude and longitude
     * @param latLng
     * @param zoom
     * @param title
     */
    private void moveCamera( LatLng latLng, float zoom, String title) {
        Log.d( TAG, "moveCamera: moving the camera to: lat: " + latLng.latitude + ", lng: " + latLng.longitude);
        // Move the cursor to the user's location
        map.moveCamera( CameraUpdateFactory.newLatLngZoom( latLng, zoom) );



        // Add a marker to the map when a location is clicked from the list
        if ( !title.equals( "My Location")) {
            MarkerOptions options = new MarkerOptions().position( latLng).title( title);
            map.addMarker( options);
        }
        hideSoftKeyboard();
    }

    /**
     * Moves camera to a specific latitude and longitude with PlaceInfo
     * @param zoom
     * @param placeInfo
     */
    private void moveCamera( float zoom, PlaceInfo placeInfo) {
        Log.d( TAG, "moveCamera: moving the camera to: lat: " + placeInfo.getLatLng().latitude + ", lng: " + placeInfo.getLatLng().longitude);
        // Move the cursor to the user's location
        map.moveCamera( CameraUpdateFactory.newLatLngZoom( placeInfo.getLatLng(), zoom) );

        map.clear();

        if ( placeInfo != null) {
            try {
                String snippet = "Name: " + placeInfo.getName();

                MarkerOptions markerOptions = new MarkerOptions().position(placeInfo.getLatLng()).title(placeInfo.getName()).snippet(snippet);

                marker = map.addMarker(markerOptions);

                map.setInfoWindowAdapter( new CustomInfoWindowAdapter( MainActivity.this, placeInfo));

            } catch (NullPointerException e) {
                Log.e(TAG, "moveCamera: NullPointerException: " + e.getMessage());
            }
        }
        else {

            map.addMarker( new MarkerOptions().position(placeInfo.getLatLng()));
        }


        hideSoftKeyboard();
    }



    /**
     * Hides the keyboard when enter is clicked but doesn't work right now
     */
    private void hideSoftKeyboard() {
        this.getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }


    /**
     * Moves the camera to a selected building from the list
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        // fetch the user selected value
        String item = parent.getItemAtPosition(position).toString();


        // move the camera to the selected building
        for ( int i = 0; i < places.getPlaces().size(); i++)
        {
            if (item.equals(places.getPlaces().get(i).getName())) {
                moveCamera(DEFAULT_ZOOM, places.getPlaces().get(i));
            }
        }
    }
}

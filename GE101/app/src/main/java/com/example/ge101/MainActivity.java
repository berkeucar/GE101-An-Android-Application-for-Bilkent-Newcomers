package com.example.ge101;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ge101.achievement.AchievementBoard;

import com.example.ge101.achievement.QrScanActivity;
import com.example.ge101.achievement.QuestionBoard;
import com.example.ge101.busschedule.BusScheduleTab;

import com.example.ge101.busschedule.BusScheduleTab;
import com.example.ge101.customlabels.CustomLabels;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;

import com.example.ge101.custommarkers.CustomInfoWindowAdapter;
import com.example.ge101.locations.PlaceInfo;
import com.example.ge101.locations.Places;

/**
 * This is the map class
 * @author Efe Beydoğan, Arda Önal, Mert Barkın Er, Berke Uçar, Mehmet Alper Çetin
 * @version 06.05.2020
 */
public class MainActivity extends FragmentActivity implements OnMapReadyCallback, AdapterView.OnItemClickListener, GoogleMap.OnGroundOverlayClickListener {

    // properties
    private GoogleMap map;
    private static final String TAG = "MapActivity";
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private Boolean mLocationPermissionsGranted = false;
    private LatLngBounds Bounds;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private static final float DEFAULT_ZOOM = 18f;
    private static final float MIN_ZOOM = 16f;
    private ImageView busSchedule;
    private long mLastClickTime = 0;
    private Marker marker;
    private ImageView clearButton;

    private ArrayList<String> buildings;
    private Places places;
    private AutoCompleteTextView editText;
    private CustomLabels customLabels;
    private ImageView achievementButton;

    private ImageView qrButton;

    private ImageView mGps;


    // widgets
    //private EditText mSearchText;

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

        // initialize the achievement button to open the achievement board
        achievementButton = (ImageView) findViewById( R.id.achievement_button);

        // initializing the qr button to used in further implementation
        qrButton = (ImageView) findViewById( R.id.qr_button);

        // Get the permission from user to receive location information
        getLocationPermission();

        places = new Places();
        buildings = new ArrayList<String>();
        customLabels = new CustomLabels( places);

        // Add the names of every building to an ArrayList for the search bar
        for (int i = 0; i < places.getPlaces().size(); i++) {
            buildings.add(places.getPlaces().get(i).getName());
        }

        clearButton = (ImageView) findViewById(R.id.ic_clear);


        // This is the search bar that has autocomplete text view
        editText = (AutoCompleteTextView) findViewById(R.id.activity_chooser_view_content);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, buildings);
        editText.setAdapter(adapter);
        editText.setOnItemClickListener(this);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });

        Log.d( TAG, "onCreate");
        //AutoCompleteTextView.setAdapter(new PlaceAutoSuggestAdapter( MainActivity.this, android.R.layout.simple_list_item_1));
    }
    // the openActivityAchievementBoard for opening the achievement board
    private void openActivityAchievementBoard()
    {

        String achievements;
        Intent i;
        ArrayList<String> achievementStrings;

        // I need to pass the string of the information about achievements so I am using Intent extra to pass
        achievements = "";
        achievementStrings = Places.makePaneString( places);

        for( String s : achievementStrings)
            achievements = achievements + s + "\n";
        i = new Intent( this, AchievementBoard.class);
        i.putExtra("ACHIEVEMENTS", achievements);
        startActivity( i);
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

        // hides the keyboard after a result is clicked
        hideSoftKeyboard();

        // just adding an anonymous class click listener to open the activity
        achievementButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openActivityAchievementBoard();
            }
        });

        // adding yet another anonymous class click listener to open the activity qr
        qrButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openActivityQrCode();
            }
        });
    }

    private void openActivityQrCode()
    {
        Intent i;
        i = new Intent( this, QrScanActivity.class);
        startActivity( i);
    }


    /**
     * The method that initializes the map
     */
    private void initMap() {
        Log.d(TAG, "initMap: initializing map");
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

    }


    /**
     * The method to get the user location and initialize the map and move the camera, set the map styling
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
        // map.addMarker( new MarkerOptions().position(BilkentUni).title( "Bilkent University"));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(BilkentUni, DEFAULT_ZOOM));


        // Add all the custom labels from the CustomLabels class on the map

        for ( int i = 0; i < customLabels.getLabels().size(); i++ ) {
            customLabels.getLabels().get(i).clickable(true); // Makes the labels clickable
            map.addGroundOverlay( customLabels.getLabels().get(i));
        }

        // Adds a listener to the labels.
        map.setOnGroundOverlayClickListener(this);

        // Restrict the map to only Bilkent University
        Bounds = new LatLngBounds( new LatLng(39.861275, 32.741088), new LatLng(39.885348, 32.764571));
        map.setLatLngBoundsForCameraTarget(Bounds);

        // Setting minimum zoom level
        map.setMinZoomPreference( MIN_ZOOM);

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

            // Get the state of the switch button from the settings screen
            SharedPreferences sharedPreferences = getSharedPreferences( "Switch", MODE_PRIVATE);

            // Change the map theme depending on the state of the switch button on the settings screen
            if ( sharedPreferences.getBoolean( "Switch" , false)) {
                try {
                    // Customise the styling of the base map using a JSON object defined
                    // in a raw resource file.
                    boolean success = googleMap.setMapStyle(
                            MapStyleOptions.loadRawResourceStyle(
                                    this, R.raw.dark_themed_map));
                    if (!success) {
                        Log.e(TAG, "Style parsing failed.");
                    }
                } catch (Resources.NotFoundException e) {
                    Log.e(TAG, "Can't find style. Error: ", e);
                }
            }
            else {
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
                        if ( task.isSuccessful())
                        {
                            Log.d( TAG, "onComplete: found location!");
                            Location currentLocation = (Location) task.getResult();

                            // If the user is in Bilkent, it moves the camera to current location.
                            if ( currentLocation.getLatitude() > Bounds.southwest.latitude && currentLocation.getLatitude() < Bounds.northeast.latitude &&
                                    currentLocation.getLongitude() > Bounds.southwest.longitude && currentLocation.getLongitude() < Bounds.northeast.longitude)
                            {
                                Log.d( TAG, "onComplete: User is in Bilkent");
                                moveCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()), DEFAULT_ZOOM, "My Location");
                            }
                            else
                            {
                                Log.d( TAG, "onComplete: User is not in Bilkent");
                                Toast.makeText( MainActivity.this, "You are not in Bilkent.", Toast.LENGTH_SHORT).show();
                            }

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
        // Move the cursor to the location
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
        // Move the cursor to the location
        map.moveCamera( CameraUpdateFactory.newLatLngZoom( placeInfo.getLatLng(), zoom) );

        if ( marker != null) {
            marker.remove();
        }

        if ( placeInfo != null) {
            try {

                MarkerOptions markerOptions = new MarkerOptions().position(placeInfo.getLatLng()).title(placeInfo.getName());

                marker = map.addMarker(markerOptions);

                map.setInfoWindowAdapter( new CustomInfoWindowAdapter( MainActivity.this, placeInfo));

            } catch (NullPointerException e) {
                Log.e(TAG, "moveCamera: NullPointerException: " + e.getMessage());
            }
        }
        else {

            map.addMarker( new MarkerOptions().position( placeInfo.getLatLng()));
        }

        hideSoftKeyboard();
    }



    /**
     * Hides the keyboard when enter is clicked
     */
    private void hideSoftKeyboard() {
        View view = this.getCurrentFocus();
        if ( view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow( view.getWindowToken(), 0);
        }
    }


    /**
     * Moves the camera to a selected building from the list
     *      * @param parent
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
            if ( item.equals(places.getPlaces().get(i).getName())) {
                moveCamera(DEFAULT_ZOOM, places.getPlaces().get(i));
            }
        }
    }


    /**
     * Default click listener for every ground overlay aka label.
     * @param groundOverlay
     */
    @Override
    public void onGroundOverlayClick(GroundOverlay groundOverlay)
    {
        LatLng position = groundOverlay.getPosition();
        Log.d(TAG, "onGroundOverlayClick: works?");

        for ( int i = 0; i < places.getPlaces().size(); i++)
        {
            if ( position.longitude == places.getPlaces().get(i).getLatLng().longitude && position.latitude == places.getPlaces().get(i).getLatLng().latitude)
            {
                moveCamera(DEFAULT_ZOOM, places.getPlaces().get(i));

            }
        }

    }
}

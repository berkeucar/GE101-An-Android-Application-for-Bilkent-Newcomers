package com.example.ge101.eatingplaces;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.ge101.R;
import com.example.ge101.customlabels.CustomLabels;
import com.example.ge101.locations.PlaceInfo;
import com.example.ge101.locations.Places;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/**
 * This is the map class
 * @author Efe Beydoğan, Arda Önal, Mert Barkın Er, Berke Uçar, Mehmet Alper Çetin
 * @version 17.05.2020
 */
public class MozartCafe extends FragmentActivity implements OnMapReadyCallback {
    // constants
    private static final float DEFAULT_ZOOM = 18f;
    private static final float MIN_ZOOM = 16f ;
    private Boolean mLocationPermissionsGranted = false;
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private static final String TAG = "MozartBMapActivity";

    // properties
    private ImageView menu;
    private long mLastClickTime = 0;
    private GoogleMap map;
    private LatLngBounds Bounds;
    private Places places;
    private CustomLabels customLabels;
    private Marker marker;

    // constructors

    // methods
    /**
     * the method that creates the activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mozart_cafe_screen);

        // gets location permission
        getLocationPermission();

        // initialization of the places and their labels
        places = new Places();
        customLabels = new CustomLabels( places);

        // Button for Mozart Cafe
        menu =(ImageView) findViewById(R.id.mozart_menu_button);
        menu.setOnClickListener(new View.OnClickListener()
        {
            /**
             * the method that makes button to open the school cafeteria's menu when clicked
             * @param v
             */
            @Override
            public void onClick (View v)
            {
                // Preventing multiple clicks, using threshold of 1 second
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                openMenu();
            }
        });
    }

    private void openMenu() {
        // creates intent (action) and opens it (for this Mozart's menu)
        Intent intent = new Intent(this, MozartCafeMenu.class);
        startActivity(intent);
    }

    /**
     * The method that initializes the map
     */
    private void initMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_mozart_cafe);
        mapFragment.getMapAsync(this);
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
     * The method to get the user location and initialize the map and move the camera, set the map styling
     * @param googleMap
     */
    @Override
    public void onMapReady( GoogleMap googleMap) {
        map = googleMap;
        // B Building Mozart
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(39.868760, 32.748059), DEFAULT_ZOOM));

        // sets the bounds
        Bounds = new LatLngBounds(new LatLng(39.861275, 32.741088), new LatLng(39.885348, 32.764571));
        map.setLatLngBoundsForCameraTarget(Bounds);

        // Add all the custom labels from the CustomLabels class on the map
        for ( int i = 0; i < customLabels.getLabels().size(); i++ ) {
            customLabels.getLabels().get(i).clickable(true); // Makes the labels clickable
            map.addGroundOverlay( customLabels.getLabels().get(i));
        }

        // adds marker to the Target
        PlaceInfo placeInfo = new PlaceInfo("Mozart Cafe (B Building)", "to be written" , new LatLng(39.868760, 32.748059), R.drawable.mozart_cafe);
        MarkerOptions markerOptions = new MarkerOptions().position(placeInfo.getLatLng()).title(placeInfo.getName());

        marker = map.addMarker(markerOptions);

        // sets the zoom restrictions
        map.setMinZoomPreference(MIN_ZOOM);

        // If the user granted permission, receive the location
        if (mLocationPermissionsGranted) {
            getDeviceLocation();

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            // Show the user location on the map
            map.setMyLocationEnabled(true);
            map.getUiSettings().setMyLocationButtonEnabled(false);
        }

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
    }

    /**
     * Checks is necessary permissions are granted and initializes the map
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        mLocationPermissionsGranted = false;

        switch( requestCode) {
            case LOCATION_PERMISSION_REQUEST_CODE: {
                if ( grantResults.length > 0) {
                    for ( int i = 0; i < grantResults.length; i++) {
                        if ( grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                            mLocationPermissionsGranted = false;

                            return;
                        }
                    }

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
                                map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(39.868760, 32.748059), DEFAULT_ZOOM));
                            }
                            else
                            {
                                Log.d( TAG, "onComplete: User is not in Bilkent");
                                Toast.makeText( MozartCafe.this, "You are not in Bilkent.", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else {
                            Log.d( TAG, "onComplete: current location is null");
                            Toast.makeText( MozartCafe.this, "unable to get current location", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        } catch (SecurityException e) {
            Log.e( TAG, "getDeviceLocation: SecurityException: " + e.getMessage() );
        }
    }

    // we can fix to the CB if it doesn't work
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
    }
}

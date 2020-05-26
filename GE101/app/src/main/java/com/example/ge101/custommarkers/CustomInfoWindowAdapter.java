package com.example.ge101.custommarkers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.ge101.R;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import com.example.ge101.locations.PlaceInfo;

/**
 * A class to display information on buildings
 * @author Efe Beydoğan, Arda Önal, Mert Barkın Er, Berke Uçar, Mehmet Alper Çetin
 * @version 17.05.2020
 */

public class CustomInfoWindowAdapter extends Fragment implements GoogleMap.InfoWindowAdapter {

    // properties
    private final View mWindow;
    private Context mContext;
    private PlaceInfo placeInfo;


    // constructors

    public CustomInfoWindowAdapter(Context mContext, PlaceInfo placeInfo)
    {
        this.mContext = mContext;
        this.placeInfo = placeInfo;
        mWindow = LayoutInflater.from( mContext).inflate( R.layout.custom_info_window, null);
    }


    // methods
    /**
     * A class to display information on buildings
     * @param marker takes a marker parameter because this info window is constructed on markers
     * @param view
     */
    private void renderWindowText( Marker marker, View view)
    {
        TextView tvTitle = (TextView) view.findViewById( R.id.custom_marker_title);

        // Gets the title of the place from PlaceInfo class
        tvTitle.setText( placeInfo.getName());

        TextView tvSnippet = (TextView) view.findViewById( R.id.custom_marker_snippet);

        // Gets the description of the place from PlaceInfo class
        tvSnippet.setText( placeInfo.getDescription());

        ImageView imageView = (ImageView) view.findViewById(R.id.busLogoTest);

        // Changes the image of every custom info window from PlaceInfo class
        imageView.setImageResource( placeInfo.getImageResource());
    }


    /**
     * A class to display information on buildings
     * @param marker takes a marker parameter because this info window is constructed on markers
     * @return returns the Window created with the renderWindowText method.
     */
    @Override
    public View getInfoWindow(Marker marker)
    {
        renderWindowText( marker, mWindow);
        return mWindow;
    }

    /**
     * A class to display information on buildings
     * @param marker takes a marker parameter because this info window is constructed on markers
     * @return returns the info contents.
     */
    @Override
    public View getInfoContents(Marker marker) {
        renderWindowText( marker, mWindow);
        return mWindow;
    }
}

package customMarkers;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.ge101.R;
<<<<<<< HEAD

import com.example.ge101.eatingPlaces.SchoolCafeteria;

=======
import com.example.ge101.eatingPlaces.SchoolCafeteria;
>>>>>>> aac48e7a9589074b877dcf905617c00ff5fd236a
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import locations.PlaceInfo;

import static com.example.ge101.R.drawable.bus;
import static com.example.ge101.R.drawable.logo;

/**
 * A class to display information on buildings
 * @author Efe Beydoğan, Arda Önal, Mert Barkın Er, Berke Uçar, Mehmet Alper Çetin
 * @version 06.05.2020
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

    private void renderWindowText( Marker marker, View view) {

        TextView tvTitle = (TextView) view.findViewById( R.id.custom_marker_title);

        tvTitle.setText( placeInfo.getName());

        TextView tvSnippet = (TextView) view.findViewById( R.id.custom_marker_snippet);

        tvSnippet.setText( placeInfo.getDescription());

        ImageView imageView = (ImageView) view.findViewById(R.id.busLogoTest);

        imageView.setImageResource( placeInfo.getImageResource());
    }

    @Override
    public View getInfoWindow(Marker marker) {
        renderWindowText( marker, mWindow);
        return mWindow;
    }

    @Override
    public View getInfoContents(Marker marker) {
        renderWindowText( marker, mWindow);
        return mWindow;
    }
}

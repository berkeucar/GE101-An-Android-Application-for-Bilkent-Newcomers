package locations;

import com.google.android.gms.maps.model.LatLng;

public class PlaceInfo
{
    // properties
    private String name;
    private String description;
    private LatLng latLng;
    private int imageResource;

    // constructors

    public PlaceInfo(String name, String description, LatLng latLng, int imageResource) {
        this.name = name;
        this.latLng = latLng;
        this.imageResource = imageResource;
        this.description = description;
    }

    public PlaceInfo() {

    }

    // methods

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    @Override
    public String toString() {
        return "PlaceInfo{" +
                "name='" + name + '\'' +
                ", latLng=" + latLng +
                '}';
    }
}

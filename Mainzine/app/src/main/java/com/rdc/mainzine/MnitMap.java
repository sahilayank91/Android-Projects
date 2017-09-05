package com.rdc.mainzine;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MnitMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mnit_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng jaipur = new LatLng(26.8643, 75.8122);
        LatLng prabha = new LatLng(26.864282,75.8102895);
        LatLng park = new LatLng(26.8643666,75.8101752);
        LatLng zinelab = new LatLng(26.8618971,75.8089755);
        LatLng disp = new LatLng(26.8621943,75.8099932);
        LatLng gargi = new LatLng(26.8645789,75.8145875);
        LatLng pmc=new LatLng(26.8640894,75.8100898);
        LatLng anna=new LatLng(26.8644413,75.809592);
        LatLng lt = new LatLng(26.8617601,75.8099328);

        LatLng lib = new LatLng(26.8626174,75.8103253);
        LatLng cenlawn = new LatLng(26.862082,75.810005);
        mMap.getMinZoomLevel();
        mMap.addMarker(new MarkerOptions().position(cenlawn).title("MNIT Library"));
        mMap.addMarker(new MarkerOptions().position(cenlawn).title("Annapurna Canteen"));
        mMap.addMarker(new MarkerOptions().position(anna).title("Annapurna Canteen"));
        mMap.addMarker(new MarkerOptions().position(pmc).title("PMC"));
        mMap.addMarker(new MarkerOptions().position(lt).title("Lecture Halls"));
        mMap.addMarker(new MarkerOptions().position(gargi).title("Gargi Girls Hostel"));
        mMap.addMarker(new MarkerOptions().position(disp).title("MNIT Dispensary"));
        mMap.addMarker(new MarkerOptions().position(zinelab).title("Zine Lab"));
        mMap.addMarker(new MarkerOptions().position(park).title("Children's Park"));
        mMap.addMarker(new MarkerOptions().position(jaipur).title("MNIT Jaipur"));
        mMap.addMarker(new MarkerOptions().position(prabha).title("Prabha Bhawan"));
        CameraUpdate zoom=CameraUpdateFactory.zoomTo(15);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jaipur));
        mMap.animateCamera(zoom);
    }
}

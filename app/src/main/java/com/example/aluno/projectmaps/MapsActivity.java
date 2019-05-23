package com.example.aluno.projectmaps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {


    double lat = -23.6677646;
    double longi = -46.7713755;
    LatLng ll = new LatLng(lat, longi);

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    private void setUpMap(){
        mMap.addMarker(new MarkerOptions().position(new LatLng(lat, longi)).title("Capão Redondo"));

        CameraUpdate location = CameraUpdateFactory.newLatLngZoom(ll, 20);
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(20);

        mMap.moveCamera(location);
        mMap.animateCamera(zoom, 3000, null);

        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    public void streetView(View v){
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        CameraUpdate location = CameraUpdateFactory.newLatLngZoom(ll, 15);
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(20);

        mMap.moveCamera(location);
        mMap.animateCamera(zoom, 300, null);
    }

    public void normalView(View v){
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        CameraUpdate location = CameraUpdateFactory.newLatLngZoom(ll, 15);
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(20);

        mMap.moveCamera(location);
        mMap.animateCamera(zoom, 300, null);
    }
}



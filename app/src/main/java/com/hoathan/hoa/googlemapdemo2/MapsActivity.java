package com.hoathan.hoa.googlemapdemo2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng khtnHCM = new LatLng(10.762660, 106.681984);
        LatLng nga3 = new LatLng(10.761222, 106.683315);
        LatLng dhSG = new LatLng(10.758554, 106.681566);
        mMap.addMarker(new MarkerOptions()
                .position(khtnHCM)
                .title("khoa hoc tu nhien")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_person_pin_circle_pink_600_24dp))
        );
        mMap.addPolyline(new PolylineOptions().add(
                khtnHCM,
                nga3,
                new LatLng(10.760283, 106.680847),
                dhSG
        )
                        .width(10)
                .color(Color.RED)
        );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(khtnHCM, 18));
       // mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);// kieu ban do
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat
                .checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);// cho phep nguoi dung hien thi vi tri cua minh
    }
}

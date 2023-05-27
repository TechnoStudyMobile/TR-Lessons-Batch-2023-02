package com.example.w14d5_location

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolygonOptions
import com.google.android.gms.maps.model.PolylineOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // val textView : TextView = findViewById(R.id.textViewLocation)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment?.getMapAsync(this)



        /*if (ActivityCompat.checkSelfPermission(
                this, android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this, android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 100
            )
        }
*/
        /* fusedLocationProviderClient.lastLocation.addOnSuccessListener { location: Location? ->
             val userLocation =
                 "Konum - Latitude: ${location?.latitude} -------  Longitude: ${location?.longitude}"
             //textView.text = userLocation
         }*/
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "KONUM İZNİ VERİLDİ!", Toast.LENGTH_LONG).show()
                showToMyLocation()
            } else {
                Toast.makeText(this, "KONUM İZNİ GEREKLİDİR!", Toast.LENGTH_LONG).show()
            }
        }
    }

    @SuppressLint("MissingPermissions")
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        // map.isMyLocationEnabled = true
        map.mapType = GoogleMap.MAP_TYPE_NORMAL

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 100
            )
            return
        }
        showToMyLocation()
    }


    private fun showToMyLocation(){
        fusedLocationProviderClient.lastLocation.addOnSuccessListener { location: Location ->
            map.moveCamera(
                CameraUpdateFactory.newLatLngZoom(
                    LatLng(location.latitude, location.longitude), 10f
                )
            )

            val marker = map.addMarker(
                MarkerOptions()
                    .position(LatLng(location.latitude, location.longitude))
                    .title("Buradasın!")
            )

            map.setOnMarkerClickListener { marker ->
                Toast.makeText(this, "${marker.title} marker'a tıklandı!", Toast.LENGTH_SHORT).show()
                true
            }

            val line = PolylineOptions().apply {
                add(LatLng(40.9595, 29.1010))
                add(LatLng(40.9090, 29.2020))
                width(15f)
                color(Color.RED)
            }
            map.addPolyline(line)


            val polygon = PolygonOptions().apply {
                add(LatLng(40.9888, 29.0285))
                add(LatLng(40.9778, 29.0275))
                add(LatLng(40.9868, 29.0265))
                add(LatLng(40.9858, 29.0255))
                strokeColor(Color.RED)
                fillColor(Color.BLUE)
            }
            map.addPolygon(polygon)
        }

    }

}
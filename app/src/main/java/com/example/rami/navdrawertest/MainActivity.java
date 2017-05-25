package com.example.rami.navdrawertest;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    ListView listView;
    ArrayAdapter<String> listAdapter;
    String fragmentArray[] = {"Fragment 1", "Fragment 2"};

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        ////////////////////////////////////////////////////////////////////////////
//        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        toggle = new ActionBarDrawerToggle(this, drawerLayout,
                android.R.drawable.ic_menu_delete,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(true);

        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        /////////////////////////////////////////////navView///////////////////////////////////////////
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Handle navigation view item clicks here.
                int id = item.getItemId();
                Fragment fragment;
                if (id == R.id.nav_incoming_trips) {
                    // Handle my trips action
                    ////////////////////////////////////+++++////////////////////////////////////////
                    fragment = new FragmentOne();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.relativeLayout, fragment).commit();
                    drawerLayout.closeDrawers();
                    ////////////////////////////////////+++++////////////////////////////////////////
                    Log.i("MyTrips: ", "MyTrips Selected");
                } else if (id == R.id.nav_past_trips) {
                    // Handle past trips action
                    ////////////////////////////////////+++++////////////////////////////////////////
                    fragment = new FragmentTwo();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.relativeLayout, fragment).commit();
                    drawerLayout.closeDrawers();
                    ////////////////////////////////////+++++////////////////////////////////////////
                    Log.i("PastTrips: ", "Past Trips Selected");
                } else if (id == R.id.nav_logout) {
                    // Handle logout action
                    ////////////////////////////////////+++++////////////////////////////////////////
                    fragment = new FragmentThree();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.relativeLayout, fragment).commit();
                    drawerLayout.closeDrawers();
                    ////////////////////////////////////+++++////////////////////////////////////////
                }
                return true;
            }
        });
        /////////////////////////////////////////////navView///////////////////////////////////////////
    }
}

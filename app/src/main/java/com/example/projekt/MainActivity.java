package com.example.projekt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;

    // Make sure to be using androidx.appcompat.app.ActionBarDrawerToggle version.
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nvView);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle mtoggle = new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.open, R.string.close);
        mDrawer.addDrawerListener(mtoggle);
        mtoggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flContent, new OfferFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_offer_fragment);
        }


    }

    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_offer_fragment:
                getSupportFragmentManager().beginTransaction().replace(R.id.flContent, new OfferFragment()).commit();
                break;
            case R.id.nav_about_us_fragment:
                getSupportFragmentManager().beginTransaction().replace(R.id.flContent, new AboutUsFragment()).commit();
                break;
            case R.id.nav_price_list_fragment:
                getSupportFragmentManager().beginTransaction().replace(R.id.flContent, new PriceListFragment()).commit();
                break;
            case R.id.nav_contact_fragment:
                getSupportFragmentManager().beginTransaction().replace(R.id.flContent, new ContactFragment()).commit();
                break;
            case R.id.nav_login_fragment:
                getSupportFragmentManager().beginTransaction().replace(R.id.flContent, new LoginFragment()).commit();
                break;
            case R.id.nav_register_fragment:
                getSupportFragmentManager().beginTransaction().replace(R.id.flContent, new RegisterFragment()).commit();
                break;
        }
        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onBackPressed(){
        if(mDrawer.isDrawerOpen(GravityCompat.START)){
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

}
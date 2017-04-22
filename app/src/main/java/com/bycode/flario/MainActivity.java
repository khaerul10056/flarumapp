package com.bycode.flario;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.bycode.flario.fragments.AddWebsiteDialogFragment;
import com.bycode.flario.fragments.WebsitesFragment;
import com.bycode.flario.listAdapters.WebsitesAdapter;
import com.bycode.flario.models.localDatabase.Website;

public class MainActivity extends AppCompatActivity
        implements
            NavigationView.OnNavigationItemSelectedListener,
            WebsitesFragment.OnFragmentInteractionListener,
            AddWebsiteDialogFragment.OnFragmentInteractionListener {

    private WebsitesAdapter adapter = new WebsitesAdapter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        WebsitesFragment websitesFragment = new WebsitesFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(
                R.id.relativelayout_for_fragment,
                websitesFragment,
                websitesFragment.getTag()
        ).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        Class fragmentClass = null;
        boolean isFramgent = true;

        switch (item.getItemId()) {
            case R.id.websites:
                fragmentClass = WebsitesFragment.class;
                break;
            default:
                break;

        }

        if (isFramgent) {
            assert fragmentClass != null;
            // if(!currentFragment.equals(fragmentClass.getName())) {
            FragmentManager fragmentManager = getSupportFragmentManager();

            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }

            assert fragment != null;
            fragmentManager.beginTransaction().replace(R.id.relativelayout_for_fragment,
                    fragment).commit();

            //currentFragment = fragment.getClass().getName();

            setTitle(item.getTitle());
            // }
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void addWebsite(Website website) {
        adapter.addWebsite(website);
    }

    @Override
    public WebsitesAdapter getWebsiteAdapter() {
        return adapter;
    }
}

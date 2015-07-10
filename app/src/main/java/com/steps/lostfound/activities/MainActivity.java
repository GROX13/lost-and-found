package com.steps.lostfound.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.steps.lostfound.R;
import com.steps.lostfound.model.AdapterFactory;

public class MainActivity extends AppCompatActivity {

    DrawerLayout mDrawerLayout;
    private LinearLayout contentFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        contentFrame = (LinearLayout) findViewById(R.id.display_content);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_home:
                        contentFrame.removeAllViews();
                        // TODO: Implement!
                        return true;
                    case R.id.action_matched_items:
                        setListViewUp((ListView)
                                getLayoutInflater().inflate(R.layout.list_matched_items, null),
                                contentFrame, menuItem.getItemId());
                        return true;
                    case R.id.action_lost_items:
                        setListViewUp((ListView)
                                getLayoutInflater().inflate(R.layout.list_lost_items, null),
                                contentFrame, menuItem.getItemId());
                        return true;
                    case R.id.action_found_items:
                        setListViewUp((ListView)
                                getLayoutInflater().inflate(R.layout.list_found_items, null),
                                contentFrame, menuItem.getItemId());
                        return true;
                    case R.id.history:
                        setListViewUp((ListView)
                                getLayoutInflater().inflate(R.layout.list_resolved_items, null),
                                contentFrame, menuItem.getItemId());
                        return true;
                    case R.id.action_settings:
                        // TODO: Implement!
                        return true;
                }
                return false;
            }
        });

        ActionBarDrawerToggle actionBarDrawerToggle =
                new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                        R.string.openDrawer, R.string.closeDrawer) {
                    @Override
                    public void onDrawerClosed(View drawerView) {
                        super.onDrawerClosed(drawerView);
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        super.onDrawerOpened(drawerView);
                    }
                };

        mDrawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private void setListViewUp(ListView listView, LinearLayout contentFrame, int itemId) {
        contentFrame.removeAllViews();
        listView.setAdapter(AdapterFactory
                .getAdapterFor(MainActivity.this, itemId));
        this.contentFrame.addView(listView);
    }


}
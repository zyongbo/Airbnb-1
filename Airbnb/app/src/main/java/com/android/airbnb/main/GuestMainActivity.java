package com.android.airbnb.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.airbnb.R;

import static com.android.airbnb.R.id.main_container;

public class GuestMainActivity extends AppCompatActivity {

    private GuestSearchFragment guestSearchFragment;
    private WishListDetailFragment wishFragment;
    private GuestTravelFragment guestTravelFragment;
    private GuestMessageFragment guestMessageFragment;
    private GuestProfileFragment guestProfileFragment;

    private TabLayout mainTabLayout;
    private static final int SEARCH = 0;
    private static final int WISH = 1;
    private static final int TRAVEL = 2;
    private static final int MESSAGE = 3;
    private static final int PROFILE = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_main);
        setFragments();
        setViews();
        setListeners();
    }

    private void setViews(){
        mainTabLayout = (TabLayout) findViewById(R.id.mainTabLayout);
        getSupportFragmentManager().beginTransaction()
                .add(main_container, guestSearchFragment)
                .commit();
    }

    private void setListeners(){

        // TabLayout Listener
        mainTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.w("test============" , tab.getPosition()+"");
                switch (tab.getPosition()){
                    case SEARCH :
                        getSupportFragmentManager().beginTransaction()
                                .replace(main_container, guestSearchFragment)
                                .commit();
                        break;
                    case WISH :
                        getSupportFragmentManager().beginTransaction()
                                .replace(main_container, wishFragment)
                                .addToBackStack(null)
                                .commit();
                        break;
                    case TRAVEL :
                        getSupportFragmentManager().beginTransaction()
                                .replace(main_container, guestTravelFragment)
                                .addToBackStack(null)
                                .commit();
                        break;
                    case MESSAGE :
                        getSupportFragmentManager().beginTransaction()
                                .replace(main_container, guestMessageFragment)
                                .addToBackStack(null)
                                .commit();
                        break;

                    case PROFILE :
                        getSupportFragmentManager().beginTransaction()
                                .replace(main_container, guestProfileFragment)
                                .addToBackStack(null)
                                .commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setFragments(){
        guestSearchFragment = new GuestSearchFragment();
        wishFragment = new WishListDetailFragment();
        guestTravelFragment = new GuestTravelFragment();
        guestMessageFragment = new GuestMessageFragment();
        guestProfileFragment = new GuestProfileFragment();
    }

}
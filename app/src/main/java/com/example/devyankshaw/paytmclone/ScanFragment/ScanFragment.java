package com.example.devyankshaw.paytmclone.ScanFragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.devyankshaw.paytmclone.NavigationDrawer.DrawerListAdapter;
import com.example.devyankshaw.paytmclone.NavigationDrawer.NavItem;
import com.example.devyankshaw.paytmclone.R;

import java.util.ArrayList;

public class ScanFragment extends Fragment {
    private DrawerLayout drawer;

    ListView mDrawerList;
    ArrayList<NavItem> mNavItems = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scan, container, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar_scan);
        //Adding navigation drawer to this fragment
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        //Adding hamburger icon(=) to the action bar
        drawer = view.findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(), drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //Listing the icons, title, subtitle and sign in this fragment to the navigation drawer
        mNavItems.add(new NavItem("Paytm First", "Say hello to the Good Life!", R.drawable.ic_paytm_first));
        mNavItems.add(new NavItem("My Orders", "Shopping, Movie Tickets, Utility Bills", R.drawable.ic_my_orders));
        mNavItems.add(new NavItem("My Passbook", "Wallets, Paytm Payments Bank Balance", R.drawable.ic_my_passbook));
        mNavItems.add(new NavItem("Payment Reminders", "Set Reminder for your Frequent Payments", R.drawable.ic_payment_reminders));
        mNavItems.add(new NavItem("My Favourite Stores", "Pay using Paytm at nearby stores", R.drawable.ic_my_favourite_stores));
        mNavItems.add(new NavItem("My Loyalty Cards", "Loyalty Points on Loyalty Cards", R.drawable.ic_my_loyalty_cards));

        mDrawerList = view.findViewById(R.id.navList);
        DrawerListAdapter adapter = new DrawerListAdapter(getContext(), mNavItems);
        mDrawerList.setAdapter(adapter);

        //Connecting fragment.xml with fragment.java
        return view;
    }
}

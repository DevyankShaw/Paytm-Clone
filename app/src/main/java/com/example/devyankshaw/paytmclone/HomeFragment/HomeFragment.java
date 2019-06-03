package com.example.devyankshaw.paytmclone.HomeFragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.devyankshaw.paytmclone.NavigationDrawer.DrawerListAdapter;
import com.example.devyankshaw.paytmclone.NavigationDrawer.NavItem;
import com.example.devyankshaw.paytmclone.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private DrawerLayout drawer;
    private View view;

    ListView mDrawerList;
    ArrayList<NavItem> mNavItems = new ArrayList<>();

    RecyclerView recyclerView, recyclerBannerView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        //Adding navigation drawer to this fragment
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(null);

        //Adding hamburger icon(=) to the action bar
        drawer = view.findViewById(R.id.drawer_layout_home);

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

        getImages();
        getBannerImages();

        //Connecting fragment.xml with fragment.java
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //allows to the inflate cashback menu item on the action bar
        setHasOptionsMenu(true);



    }

    @Override
    public void onCreateOptionsMenu (Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.home_action_bar_menu, menu);

    }

    private void getImages() {

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        ArrayList<RecycleItem> recycledata = new ArrayList<>();

        recycledata.add(new RecycleItem(R.drawable.ic_payment_64, "Pay"));
        recycledata.add(new RecycleItem(R.drawable.ic_monetization_64, "UPI Money Transfer"));
        recycledata.add(new RecycleItem(R.drawable.ic_account_64, "Passbook"));
        recycledata.add(new RecycleItem(R.drawable.ic_store_64, "Favourite Stores"));
        recycledata.add(new RecycleItem(R.drawable.ic_location_64, "Nearby KYC Points"));


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(), recycledata);
        recyclerView.setAdapter(adapter);

    }

    private void getBannerImages() {

        recyclerBannerView = view.findViewById(R.id.recycler_banner_view);
        recyclerBannerView.setHasFixedSize(true);
        ArrayList<RecycleBannerItem> recycleBannerData = new ArrayList<>();

        recycleBannerData.add(new RecycleBannerItem(R.drawable.paytm1));
        recycleBannerData.add(new RecycleBannerItem(R.drawable.paytm2));
        recycleBannerData.add(new RecycleBannerItem(R.drawable.paytm3));
        recycleBannerData.add(new RecycleBannerItem(R.drawable.paytm4));


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_banner_view);
        recyclerView.setLayoutManager(layoutManager);
        RecycleBannerViewAdapter adapter = new RecycleBannerViewAdapter(getActivity(), recycleBannerData);
        recyclerView.setAdapter(adapter);

    }

}

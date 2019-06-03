package com.example.devyankshaw.paytmclone.MallFragment;

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
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.devyankshaw.paytmclone.NavigationDrawer.DrawerListAdapter;
import com.example.devyankshaw.paytmclone.NavigationDrawer.NavItem;
import com.example.devyankshaw.paytmclone.R;

import java.util.ArrayList;

public class MallFragment extends Fragment {
    private DrawerLayout drawer;
    private View view;

    ListView mDrawerList;
    ArrayList<NavItem> mNavItems = new ArrayList<>();

    RecyclerView recyclerBannerMallView1, recyclerBannerMallView2, recyclerBannerMallView3;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mall, container, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar_mall);
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

        getBanner1Images();
        getBanner2Images();
        getBanner3Images();

        //Connecting fragment.xml with fragment.java
        return view;
    }

    private void getBanner1Images() {

        recyclerBannerMallView1 = view.findViewById(R.id.recycler_mall_view_1);
        recyclerBannerMallView1.setHasFixedSize(true);
        ArrayList<RecyclerBannerMallItem1> recycleBannerData = new ArrayList<>();

        recycleBannerData.add(new RecyclerBannerMallItem1(R.drawable.paytm1));
        recycleBannerData.add(new RecyclerBannerMallItem1(R.drawable.paytm2));
        recycleBannerData.add(new RecyclerBannerMallItem1(R.drawable.paytm3));
        recycleBannerData.add(new RecyclerBannerMallItem1(R.drawable.paytm4));


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_mall_view_1);
        recyclerView.setLayoutManager(layoutManager);
        RecycleBannerMallItem1Adapter adapter = new RecycleBannerMallItem1Adapter(getActivity(), recycleBannerData);
        recyclerView.setAdapter(adapter);

    }

    private void getBanner2Images() {

        recyclerBannerMallView2 = view.findViewById(R.id.recycler_mall_view_2);
        recyclerBannerMallView2.setHasFixedSize(true);
        ArrayList<RecyclerBannerMallItem2> recycleBannerData = new ArrayList<>();

        recycleBannerData.add(new RecyclerBannerMallItem2("Mobiles",R.drawable.ic_phone_48, "Electronics", R.drawable.ic_camera_48));
        recycleBannerData.add(new RecyclerBannerMallItem2("Books & Stationery",R.drawable.ic_library_books_48, "Sunday Bazaar", R.drawable.ic_watch_48));
        recycleBannerData.add(new RecyclerBannerMallItem2("Home & Kitchen",R.drawable.ic_photo_album_48, "Grocery", R.drawable.ic_add_shopping_cart_48));
        recycleBannerData.add(new RecyclerBannerMallItem2("Cars & Bike",R.drawable.ic_directions_car_48, "Smart Retail", R.drawable.ic_store_mall_48));
        recycleBannerData.add(new RecyclerBannerMallItem2("Laptop & PCs",R.drawable.ic_laptop_windows_48, "TVs, ACs & Appliances", R.drawable.ic_tv_48));



        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_mall_view_2);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerBannerMallItem2Adapter adapter = new RecyclerBannerMallItem2Adapter(getActivity(), recycleBannerData);
        recyclerView.setAdapter(adapter);

    }

    private void getBanner3Images() {

        recyclerBannerMallView3 = view.findViewById(R.id.recycler_mall_view_3);
        recyclerBannerMallView3.setHasFixedSize(true);
        ArrayList<RecycleBannerMallItem3> recycleBannerData = new ArrayList<>();

        recycleBannerData.add(new RecycleBannerMallItem3(R.drawable.ic_phone_52, "Best Prices"));
        recycleBannerData.add(new RecycleBannerMallItem3(R.drawable.ic_headset_64, "Starting at ₹749"));
        recycleBannerData.add(new RecycleBannerMallItem3(R.drawable.voucher_64, "CashBack Offers"));
        recycleBannerData.add(new RecycleBannerMallItem3(R.drawable.ic_keyboard_64, "Starting ₹249"));


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_mall_view_3);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerBannerMallItem3Adapter adapter = new RecyclerBannerMallItem3Adapter(getActivity(), recycleBannerData);
        recyclerView.setAdapter(adapter);

    }
}

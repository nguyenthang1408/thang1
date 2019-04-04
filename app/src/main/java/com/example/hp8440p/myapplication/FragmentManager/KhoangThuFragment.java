package com.example.hp8440p.myapplication.FragmentManager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TableLayout;

import com.example.hp8440p.myapplication.R;
import com.example.hp8440p.myapplication.Tag_Fragment.tab_KhoangThu_Fragment;
import com.example.hp8440p.myapplication.Tag_Fragment.tab_LoaiThu_Fragment;

public class KhoangThuFragment extends Fragment {
    private AppBarLayout appBar;
    private TabLayout tabs;
    private ViewPager viewPager;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.khoangthu_fragment,container,false);

        View contenedor = (View) container.getParent();
        appBar = (AppBarLayout) contenedor.findViewById(R.id.appbar);
        tabs = new TabLayout(getActivity());
        tabs.setTabTextColors(Color.parseColor("red"),Color.parseColor("red"));
        appBar.addView(tabs);

        viewPager = (ViewPager) view.findViewById(R.id.pager);
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(viewPager);


        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        appBar.removeView(tabs);
    }
    public class ViewPagerAdapter extends FragmentStatePagerAdapter{
        public  ViewPagerAdapter (FragmentManager fragmentManager){
            super(fragmentManager);
        }
        String[] tituloTabs = {"Khoản Thu","Khoản Thu Thêm"};

        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 1: return new tab_LoaiThu_Fragment();
                case 0: return new tab_KhoangThu_Fragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tituloTabs[position] ;
        }
    }
}

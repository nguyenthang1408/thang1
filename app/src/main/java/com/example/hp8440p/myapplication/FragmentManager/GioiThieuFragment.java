package com.example.hp8440p.myapplication.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.hp8440p.myapplication.R;

public class GioiThieuFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.gioithieu_fragment,container,false);
        @SuppressLint("ResourceType") Animation animation = AnimationUtils.loadAnimation(getActivity(),R.animator.animal);
        TextView coderbyME = view.findViewById(R.id.tvCodebyme);
        coderbyME.startAnimation(animation);
        return view;
    }
}

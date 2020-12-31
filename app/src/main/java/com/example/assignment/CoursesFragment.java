package com.example.assignment;

import android.content.Context;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;


public class CoursesFragment extends Fragment {

    Button btnone, btntwo, btnthree, btnfour, btnfive, btnsix;
    VideoView videoView;
    Uri uri;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_courses, container, false);

        btnone = view.findViewById(R.id.btn_one);
        btntwo = view.findViewById(R.id.btn_two);
        btnthree = view.findViewById(R.id.btn_three);
        btnfour = view.findViewById(R.id.btn_four);
        btnfive = view.findViewById(R.id.btn_five);
        btnsix = view.findViewById(R.id.btn_six);

        videoView = (VideoView) view.findViewById(R.id.video_player);


        return view;
    }

}

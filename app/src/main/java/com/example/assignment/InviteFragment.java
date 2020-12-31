package com.example.assignment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;


public class InviteFragment extends Fragment {

    ImageButton imgFacebook, imgWhatsapp, imgTwitter, imgTelegram;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_invite, container, false);

        imgFacebook = view.findViewById(R.id.img_facebook);
        imgWhatsapp = view.findViewById(R.id.img_whatsapp);
        imgTwitter = view.findViewById(R.id.img_twitter);
        imgTelegram = view.findViewById(R.id.img_telegram);

        imgWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWhatsapp();
            }
        });

        imgFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFacebook();
            }
        });

        imgTelegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTelegram();
            }
        });

        imgTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTwitter();
            }
        });
        return view;
    }

    private void openWhatsapp() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Invitation");
        sendIntent.setType("text/plain");
        sendIntent.setPackage("com.whatsapp");
        if (sendIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(sendIntent);
        } else {
            Toast.makeText(getActivity(), "whatsapp not install please install whatsapp", Toast.LENGTH_LONG).show();
        }
    }

    private void openFacebook() {
        Intent FBIntent = new Intent(Intent.ACTION_SEND);
        FBIntent.setType("text/plain");
        FBIntent.setPackage("com.facebook.katana");
        FBIntent.putExtra(Intent.EXTRA_TEXT, "Invitation");
        try {
            getActivity().startActivity(FBIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(), "Facebook have not been installed.", Toast.LENGTH_SHORT).show();
        }
    }


    private void openTwitter() {
        Intent intent = null;
        try {
            getActivity().getPackageManager().getPackageInfo("com.twitter.android", 0);
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=USERID"));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        } catch (Exception e) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/USERID_OR_PROFILENAME"));
        }
        this.startActivity(intent);
    }

    private void openTelegram() {
        Intent myIntent = new Intent(Intent.ACTION_SEND);
        myIntent.setType("text/plain");
        myIntent.setPackage("org.telegram.messenger");
        myIntent.putExtra(Intent.EXTRA_TEXT, "Invitation");
        try {
            getActivity().startActivity(myIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(), "Telegram not Installed", Toast.LENGTH_SHORT).show();
        }
    }
}

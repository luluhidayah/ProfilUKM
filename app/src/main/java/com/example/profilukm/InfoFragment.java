package com.example.profilukm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class InfoFragment extends Fragment {
    CardView card1, card2, card3, card4, card5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_info, container, false);

        card1 = v.findViewById(R.id.card1);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://instagram.com/politeknik_negeri_lampung?igshid=YmMyMTA2M2Y=";
                Intent b = new Intent(Intent.ACTION_VIEW);
                b.setData(Uri.parse(url));
                startActivity(b);
            }
        });

        card2 = v.findViewById(R.id.card2);
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://youtube.com/@politekniknegerilampung9459";
                Intent c = new Intent(Intent.ACTION_VIEW);
                c.setData(Uri.parse(url));
                startActivity(c);
            }
        });

        card3 = v.findViewById(R.id.card3);
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://polinela.ac.id/";
                Intent d = new Intent(Intent.ACTION_VIEW);
                d.setData(Uri.parse(url));
                startActivity(d);
            }
        });

        card4 = v.findViewById(R.id.card4);
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://vm.tiktok.com/ZSN4VpxfK/" ;
                Intent e = new Intent(Intent.ACTION_VIEW);
                e.setData(Uri.parse(url));
                startActivity(e);
            }
        });

        card5 = v.findViewById(R.id.card5);
        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "humas@polinela.ac.id" ;
                Intent f = new Intent(Intent.ACTION_VIEW);
                f.setData(Uri.parse(url));
                startActivity(f);
            }
        });



        return v;
    }
}
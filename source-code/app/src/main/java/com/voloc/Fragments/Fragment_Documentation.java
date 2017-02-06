package com.voloc.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.voloc.R;


public class Fragment_Documentation extends Fragment{
    View view;
    Button download_doc_btn ;
    public Fragment_Documentation() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        view =  inflater.inflate(R.layout.fragment_documentation, container, false);
        // Adding toasting in the download Document button
        init();
        download_doc_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(v, " Downloading Started", Snackbar.LENGTH_LONG);
                View view = snackbar.getView();
                TextView tv = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
                tv.setTextColor(Color.WHITE);
                snackbar.setAction("Action", null).show();
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

    void init() {
        download_doc_btn = (Button)view.findViewById(R.id.download_doc_btn);
    }


}


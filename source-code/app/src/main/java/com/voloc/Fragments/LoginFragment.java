package com.voloc.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.voloc.Activities.Home;
import com.voloc.Activities.LoginSignup;
import com.voloc.R;


public class LoginFragment extends Fragment {

    View view;
    Button bt_login_next;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_login, container, false);
        init();

        bt_login_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getApplicationContext(),Home.class);
                startActivity(i);
            }
        });

        return view;
    }

    void init() {
        bt_login_next = (Button) view.findViewById(R.id.bt_login_next);
    }

}
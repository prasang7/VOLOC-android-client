package com.voloc.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.voloc.Model.CustomList;
import com.voloc.R;
import com.voloc.Activities.play_video;


public class Fragment_Video extends Fragment{
    ListView list;
    String[] web = {
            "Video 1: Introduction",
            "Video 2: Getting Started ",
            "Video 3: Index",
            "Video 4:Key Terms And Concepts",
            "Video 5:Practise Set",
            "Video 6:Points To Remember",
            "Video 7: Summing Up"
    } ;
    Integer[] imageId = {
            R.mipmap.data_scientist,
            R.mipmap.data_scientist,
            R.mipmap.data_scientist,
            R.mipmap.data_scientist,
            R.mipmap.data_scientist,
            R.mipmap.data_scientist,
            R.mipmap.data_scientist
    };
    boolean[] animationStates=new boolean[7];

    View view;
    public Fragment_Video() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_video, container, false);
        CustomList adapter = new
                CustomList(getActivity(), web, imageId);
        list=(ListView)view.findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getActivity().getApplicationContext(), "You Clicked at " + web[+position], Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getActivity(),play_video.class);
                startActivity(intent);
            }
        });
        return view;
    }




}
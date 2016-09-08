package com.voloc.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.voloc.Activities.CourseOpenerActivity;
import com.voloc.Adapter.RVAdapter;
import com.voloc.Data;
import com.voloc.R;

import java.util.ArrayList;
import java.util.List;


public class Welcome extends Fragment {

    View view;
    private List<Data> courseList = new ArrayList<>();
    private RecyclerView recyclerView;
    Context context;
    private RVAdapter mAdapter;
    public Welcome() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_welcome, container, false);

        init();
        recycler_view();
        // Inflate the layout for this fragment
        return view;
    }

    void init() {
        recyclerView = (RecyclerView)view.findViewById(R.id.rv);

    }
    void recycler_view()
    {
        mAdapter = new RVAdapter(courseList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareCourseData();
    }
    private void prepareCourseData()
    {
        String courseName[]={"Data science","machine Learning","Microprocessor","Algorithms"};
        int photoId []={R.mipmap.data_scientist,R.mipmap.data_scientist,R.mipmap.data_scientist,R.mipmap.data_scientist};
        String courseFaculty []={"prof,xyz","prof.abcd","prof,mnbv","prof.gjks"};

        for (int i=0;i<photoId.length;i++)
        {
            Data course=new Data(courseName[i],courseFaculty[i],photoId[i]);
            courseList.add(course);
        }
        mAdapter.notifyDataSetChanged();


    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
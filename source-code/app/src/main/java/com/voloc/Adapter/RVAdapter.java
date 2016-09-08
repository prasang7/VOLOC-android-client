package com.voloc.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.voloc.Activities.CourseOpenerActivity;
import com.voloc.Data;
import com.voloc.R;

import java.util.List;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder> {
    private List<Data> coursesList;
    private RecyclerView recyclerView;
    CardView cv;
    private final static int FADE_DURATION = 1000;
    private int lastPosition = -1;//
    Context context;//

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView courseName, courseFaculty;
        public ImageView photoId;
        LinearLayout container;
        public MyViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
     //       container = (LinearLayout) itemView.findViewById(R.id.linear_layout); //
            courseName = (TextView) itemView.findViewById(R.id.course_name);
            courseFaculty = (TextView) itemView.findViewById(R.id.course_faculty);
            photoId = (ImageView) itemView.findViewById(R.id.course_image);
            recyclerView = (RecyclerView)itemView.findViewById(R.id.rv);
            photoId.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            Context context = itemView.getContext();
            int position=getAdapterPosition();
            Toast.makeText(context,"position ="+ position,Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, CourseOpenerActivity.class);
            context.startActivity(intent);
        }
    }

    public RVAdapter(List<Data> coursesList) {
        this.coursesList = coursesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
       // context = parent.getContext();//

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Data course = coursesList.get(position);
        holder.courseName.setText(course.getCourseName());
        holder.courseFaculty.setText(course.getCourseFaculty());
        holder.photoId.setImageResource(course.getPhotoId());
       // setAnimation(holder.container, position);//
    }

   /* private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context,android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }*/
    @Override
    public int getItemCount() {
        return coursesList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
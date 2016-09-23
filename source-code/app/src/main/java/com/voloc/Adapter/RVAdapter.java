package com.voloc.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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
    Context context;//

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView courseName, courseFaculty;
        public ImageView photoId,menu_options;
        LinearLayout container;
        public MyViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
     //       container = (LinearLayout) itemView.findViewById(R.id.linear_layout); //
            courseName = (TextView) itemView.findViewById(R.id.course_name);
            courseFaculty = (TextView) itemView.findViewById(R.id.course_faculty);
            photoId = (ImageView) itemView.findViewById(R.id.course_image);
            recyclerView = (RecyclerView)itemView.findViewById(R.id.rv);
            menu_options=(ImageView) itemView.findViewById(R.id.nut);
            cv.setOnClickListener(this);
            //photoId.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
                Context context = itemView.getContext();
                int position = getAdapterPosition();
                Toast.makeText(context, "position =" + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, CourseOpenerActivity.class);
                context.startActivity(intent);

        }
    }

    public RVAdapter(List<Data> coursesList,Context context) {
        this.coursesList = coursesList;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
       // context = parent.getContext();//

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Data course = coursesList.get(position);
        holder.courseName.setText(course.getCourseName());
        holder.courseFaculty.setText(course.getCourseFaculty());
        holder.photoId.setImageResource(course.getPhotoId());
        holder.menu_options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(holder.menu_options,position);
            }
        });
    }
    @Override
    public int getItemCount() {
        return coursesList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    private void showPopupMenu(View view , int position) {
        PopupMenu popup = new PopupMenu(context, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_courses, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener(position));
        popup.show();
    }
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {
            int position;
        public MyMenuItemClickListener(int position) {
            this.position=position;
        }
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(context, "interested"+position, Toast.LENGTH_SHORT).show();

                    return true;
                case R.id.action_play_next:
                    Toast.makeText(context, "about courses", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

}
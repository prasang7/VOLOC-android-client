package com.voloc.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.voloc.Model.Quiz;
import com.voloc.R;
import com.voloc.data.QuizProvider;

import java.util.List;
import java.util.Random;

public class Fragment_Quiz extends Fragment{
    private Context acontext;private int lastPosition = 0;

    public Fragment_Quiz() {
        // Required empty public constructor
    }
    View view;
    TextView QuestionNO,Question;
    Button Answer1,Answer2,Answer3,Answer4;
    int a=1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_quiz, container, false);

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.quiz_list);
        rv.setLayoutManager(new LinearLayoutManager((getActivity())));
        rv.setAdapter(new QuizListAdapter(new QuizProvider().readQuizzes()));
        return view;
    }
    class QuizListAdapter extends RecyclerView.Adapter<QuizViewHolder> {
        private final List<Quiz> quizzes;
        QuizListAdapter(List<Quiz> quizzes) {
            this.quizzes = quizzes;
        }
        @Override
        public QuizViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            final LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
            final View v = layoutInflater.inflate(R.layout.quiz_card, viewGroup, false);
            return new QuizViewHolder(v);
        }
        public void removeItem(int position) {
            quizzes.remove(position);
            notifyItemRemoved(position);
        }

        @Override
        public void onBindViewHolder(QuizViewHolder quizViewHolder, int i) {
            quizViewHolder.quizQuestion.setText(quizzes.get(i).getQuestion());
            quizViewHolder.Answer1.setText(quizzes.get(i).getAns1());
            quizViewHolder.Answer2.setText(quizzes.get(i).getAns2());
            quizViewHolder.Answer3.setText(quizzes.get(i).getAns3());
            setAnimation(quizViewHolder.card, i);
        }

        @Override
        public int getItemCount() {
            return quizzes.size();
        }
    }

    class QuizViewHolder extends RecyclerView.ViewHolder{
        TextView quizQuestion;
        Button Answer1,Answer2,Answer3;
        LinearLayout container;
        CardView card;
        QuizViewHolder(View itemView) {
            super(itemView);
            quizQuestion = (TextView) itemView.findViewById(R.id.quiz_question);
            Answer1 = (Button) itemView.findViewById((R.id.answer1));
            Answer2=(Button)itemView.findViewById((R.id.answer2));
            Answer3=(Button)itemView.findViewById((R.id.answer3));
            container = (LinearLayout) itemView.findViewById(R.id.container);
            card=(CardView) itemView.findViewById(R.id.card);

        }

    }
    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            anim.setDuration(new Random().nextInt(501));//to make duration random number between [0,501)
            viewToAnimate.startAnimation(anim);
            lastPosition = position;
        }
    }


}



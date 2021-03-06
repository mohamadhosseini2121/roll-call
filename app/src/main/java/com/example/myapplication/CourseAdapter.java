package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.myapplication.db.entity.Course;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    public static final String KEY_INTENT_ID_COURSE = "course_id_key";
    private Context context;
    private List<Course> courses;
    private boolean isCheckBoxVisible;

    private SparseBooleanArray booleanArray = new SparseBooleanArray();

    public CourseAdapter(Context context, List<Course> courseList) {

        this.context = context;
        this.courses = courseList;
    }


    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_course_list, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Course course = courses.get(position);
        holder.tvName.setText(course.getName());
        holder.tvGroup.setText(String.valueOf("گروه: " + course.getGroup()));
        holder.tvSemester.setText(String.valueOf("نیمسال: " + course.getSemester()));
        holder.tvAcademicYear.setText(course.getAcademicYear());

        if (isCheckBoxVisible) {
            holder.checkBox.setVisibility(View.VISIBLE);
            holder.checkBox.setChecked(booleanArray.get(position , false));
        }

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }


    private Course getItem(int position) {
        return courses.get(position);
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        @BindView(R.id.tv_name_course_item)
        TextView tvName;
        @BindView(R.id.tv_group_course_item)
        TextView tvGroup;
        @BindView(R.id.tv_semester_course_item)
        TextView tvSemester;
        @BindView(R.id.tv_academic_year_course_item)
        TextView tvAcademicYear;
        @BindView(R.id.ch_course_item)
        CheckBox checkBox;
        @BindView(R.id.card_item_course)
        CardView cardView;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            cardView.setOnClickListener(this);
            cardView.setOnLongClickListener(this);}


        @Override
        public void onClick(View v) {
            if (isCheckBoxVisible) {
                if (booleanArray.get(getAdapterPosition(), false)) {
                    booleanArray.delete(getAdapterPosition());
                    checkBox.setChecked(false);
                } else {
                    booleanArray.put(getAdapterPosition(), true);
                    checkBox.setChecked(true);
                }
            }

            else {
                Intent intent = new Intent(context, SessionActivity.class);
                Course course = getItem(getAdapterPosition());
                intent.putExtra(KEY_INTENT_ID_COURSE, course.getCid());
                context.startActivity(intent);
            }

        }

        @Override
        public boolean onLongClick(View v) {
            if (!isCheckBoxVisible) {
                isCheckBoxVisible = true;
                booleanArray.put(getAdapterPosition() , true);
                notifyDataSetChanged();

            }
            return true;
        }
    }
}

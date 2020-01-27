package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.myapplication.db.entity.Course;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class InputCourseAdapter extends RecyclerView.Adapter<InputCourseAdapter.InputCourseViewHolder> {

    private Context context;
    private List<Course> courses;


    private int lastSelectedPosition = -1;
    private Course selectedCourse;


    public InputCourseAdapter(Context context, List<Course> courseList) {

        this.context = context;
        this.courses = courseList;
    }


    @NonNull
    @Override
    public InputCourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_input_course_list, parent, false);
        return new InputCourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InputCourseViewHolder holder, int position) {
        Course course = courses.get(position);
        holder.tvName.setText(course.getName());
        holder.tvGroup.setText(String.valueOf("گروه: " + course.getGroup()));
        holder.tvSemester.setText(String.valueOf("نیمسال: " + course.getSemester()));
        holder.tvAcademicYear.setText(course.getAcademicYear());
        holder.rbSelectionState.setChecked(lastSelectedPosition == position);

    }

    public Course getSelectedCourse() {
        if (lastSelectedPosition > -1)
            return courses.get(lastSelectedPosition);
        else
            return null;
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public class InputCourseViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_name_course_input_item)
        TextView tvName;
        @BindView(R.id.tv_group_course_input_item)
        TextView tvGroup;
        @BindView(R.id.tv_semester_course_input_item)
        TextView tvSemester;
        @BindView(R.id.tv_academic_year_course_input_item)
        TextView tvAcademicYear;
        @BindView(R.id.rb_selection_state_course_input_item)
        RadioButton rbSelectionState;

        public InputCourseViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            rbSelectionState.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lastSelectedPosition = getAdapterPosition();
                    notifyDataSetChanged();
                }
            });
        }
    }
}

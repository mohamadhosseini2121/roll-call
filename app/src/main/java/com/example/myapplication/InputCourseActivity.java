package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.db.AppDatabase;
import com.example.myapplication.db.ServerDatabase;
import com.example.myapplication.db.entity.Course;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.view.View;
import android.widget.Button;

import java.util.List;

public class InputCourseActivity extends AppCompatActivity {

    @BindView(R.id.btn_add_course)
    Button btnAddCourse;
    @BindView(R.id.recycler_input_course_ac)
    RecyclerView recyclerView;
    @BindView(R.id.coordinator_layout_input_course_ac)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.toolbar_input_course_ac)
    Toolbar toolbar;

    private AppDatabase appDb;
    private ServerDatabase serverDb;
    private InputCourseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_course);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        setupToolbar();
        appDb = AppDatabase.getInstance(this);
        serverDb = ServerDatabase.getInstance(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this , RecyclerView.VERTICAL , false ));
        ShowCourses();

    }

    private void setupToolbar() {
        toolbar.setTitle("درس ها");
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.title_texts_color));
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    public void ShowCourses (){

        List<Course> allCourses = serverDb.getCourseDao().getAllCourses();
        adapter = new InputCourseAdapter(this,allCourses);
        recyclerView.setAdapter(adapter);

    }


    @OnClick(R.id.btn_add_course)
    public void addCourse(){

        if (adapter.getSelectedCourse() == null)
            Snackbar.make(coordinatorLayout,"درسی انتخاب نشده است",Snackbar.LENGTH_SHORT).show();
        else{
            appDb.getCourseDao().addCourse(adapter.getSelectedCourse());
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }

    }

}

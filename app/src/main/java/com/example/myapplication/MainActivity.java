package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.db.AppDatabase;
import com.example.myapplication.db.entity.Course;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_courses_ac)
    RecyclerView recyclerView;
    @BindView(R.id.toolbar_courses_ac)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    //@BindView(R.id.navigation_view) NavigationView navigationView;

    //private CourseDataSource courseDataSource;
    private AppDatabase appDatabase;
    private List<Course> courses;
    private CourseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        setupToolbar();
        recyclerView.setLayoutManager(new LinearLayoutManager(this , RecyclerView.VERTICAL , false ));
        appDatabase = AppDatabase.getInstance(getApplicationContext());
        courses = appDatabase.getCourseDao().getAllCourses();
        adapter = new CourseAdapter(this , courses);
        recyclerView.setAdapter(adapter);

    }

    private void setupToolbar(){
        toolbar.setTitle("کلاس ها");
        toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.title_texts_color));
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,
                toolbar,0,0);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void fabOnClick(View view) {
        Intent intent = new Intent(this , InputCourseActivity.class);
        startActivity(intent);
    }
}

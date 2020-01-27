package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.db.AppDatabase;
import com.example.myapplication.db.entity.Session;
import com.example.myapplication.utility.date.DateConverter;
import com.example.myapplication.utility.date.JalaliDate;
import com.example.myapplication.utility.date.JalaliDateFormatter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.View;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SessionActivity extends AppCompatActivity {

    @BindView(R.id.recycler_session_ac)
    RecyclerView recyclerView;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.toolbar_session_ac)
    Toolbar toolbar;


    private AppDatabase appDatabase;
    private Long courseId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        init();
        updateSessions();
    }

    private void init(){

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Session> sessionList = appDatabase.getSessionDao().getSessionsOfCourse(courseId);
                Session session = new Session(sessionList.size() + 1, getJalaliDate(), courseId);
                appDatabase.getSessionDao().addSession(session);
                updateSessions();
            }
        });
        appDatabase = AppDatabase.getInstance(this);
        courseId = getIntent().getLongExtra(CourseAdapter.KEY_INTENT_ID_COURSE, -1);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        setupToolbar();

    }

    private void setupToolbar() {
        toolbar.setTitle("جلسه ها");
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.title_texts_color));
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }


    public void updateSessions(){

        List<Session> sessionList = appDatabase.getSessionDao().getSessionsOfCourse(courseId);
        SessionAdapter adapter = new SessionAdapter(this,sessionList);
        recyclerView.setAdapter(adapter);

    }

    public String getJalaliDate(){

        Calendar calendar = Calendar.getInstance();
        DateConverter dateConverter = new DateConverter();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        JalaliDate jalaliDate = dateConverter.gregorianToJalali(year,month,day);
        return jalaliDate.toString();
    }

}

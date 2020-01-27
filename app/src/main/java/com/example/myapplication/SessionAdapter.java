package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.db.entity.Session;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SessionAdapter extends RecyclerView.Adapter<SessionAdapter.SessionViewHolder> {


    private Context context;
    private List<Session> allSessions;

    public SessionAdapter (Context context, List<Session> allSessions){

        this.context = context;
        this.allSessions = allSessions;
    }

    @NonNull
    @Override
    public SessionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_session_list, parent, false);
        return new SessionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SessionViewHolder holder, int position) {
        Session session = allSessions.get(position);
        holder.tvSessionNumber.setText(String.valueOf("جلسه " + session.getSessionNumber()));
        holder.tvDate.setText(String.valueOf(session.getDate()));

    }

    @Override
    public int getItemCount() {
        return allSessions.size();
    }

    public class SessionViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_session_number_session_item)
        TextView tvSessionNumber;
        @BindView(R.id.tv_date_session_item)
        TextView tvDate;


        public SessionViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

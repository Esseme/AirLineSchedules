package com.airlineschedules.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.airlineschedules.R;
import com.airlineschedules.model.Schedule;

import java.time.LocalDateTime;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Ed Ssemuwemba on 5/14/19.
 * esseme@gmail.com
 */
public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {

    private List<Schedule> scheduleList;
    private Context mContext;

    public ScheduleAdapter(List<Schedule> scheduleList, Context context) {
        this.scheduleList = scheduleList;
        mContext = context;
    }

    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_schedule, parent, false);
        return new ScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {
        holder.aiportTxt.setText(scheduleList.get(position).getAirPortCode());
        holder.terminalTxt.setText(scheduleList.get(position).getTerminal());
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//            holder.dateTxt.setText(String.format(mContext.getString(R.string.schedule_date), LocalDateTime.parse(scheduleList.get(position).getScheduleTime())));
//        }
        holder.dateTxt.setText(scheduleList.get(position).getScheduleTime());

    }

    @Override
    public int getItemCount() {
        return scheduleList.size();
    }


    class ScheduleViewHolder extends RecyclerView.ViewHolder{
        TextView aiportTxt,terminalTxt, dateTxt;

        ScheduleViewHolder(View view){
            super(view);
            aiportTxt = view.findViewById(R.id.txt_airport_code);
            terminalTxt = view.findViewById(R.id.txt_terminal);
            dateTxt = view.findViewById(R.id.txt_time);
        }
    }
}

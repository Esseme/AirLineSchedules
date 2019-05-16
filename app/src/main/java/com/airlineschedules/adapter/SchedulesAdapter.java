package com.airlineschedules.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.airlineschedules.R;
import com.airlineschedules.model.Schedule;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by Ed Ssemuwemba on 5/16/19.
 * esseme@gmail.com
 */
public class SchedulesAdapter extends ArrayAdapter<Schedule> {
    private final Context mContext;
    private List<Schedule> scheduleList;

    public SchedulesAdapter(List<Schedule> scheduleList, Context context){
        super(context, 0, scheduleList);
        this.scheduleList = scheduleList;
        mContext = context;

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView aiportTxt,terminalTxt, dateTxt;
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.row_schedule, parent, false);

        aiportTxt = listItem.findViewById(R.id.txt_airport_code);
        aiportTxt.setText(scheduleList.get(position).getAirPortCode());
        terminalTxt = listItem.findViewById(R.id.txt_terminal);
        terminalTxt.setText(scheduleList.get(position).getTerminal());
        dateTxt = listItem.findViewById(R.id.txt_time);
        dateTxt.setText(scheduleList.get(position).getScheduleTime());
        return listItem;
    }


}

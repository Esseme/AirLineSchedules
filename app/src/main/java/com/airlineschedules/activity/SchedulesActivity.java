package com.airlineschedules.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.airlineschedules.R;
import com.airlineschedules.adapter.SchedulesAdapter;
import com.airlineschedules.model.Schedule;
import com.airlineschedules.model.Token;
import com.airlineschedules.network.AirLineApiInterface;
import com.airlineschedules.network.RetrofitInstance;

import java.util.List;
import java.util.Locale;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ed Ssemuwemba on 5/14/19.
 * esseme@gmail.com
 */
public class SchedulesActivity extends AppCompatActivity {

    public static final String TAG = SchedulesActivity.class.getSimpleName();
//    private ScheduleAdapter adapter;
    private SchedulesAdapter adapter;
    private Context context = SchedulesActivity.this;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @BindView(R.id.scheduleList)
    ListView schedulesListView;
    private ProgressDialog progressDialog;
    private String CLIENT_ID = "evea7xfzps8a9w8y9pnttmse";
    private String CLIENT_SECRET = "mwMucZnCEZ";
    private String GRANT_TYPE = "client_credentials";
    private String ACCEPT = "application/json";
    private String BREARER = "Bearer ";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_schedules);
        setContentView(R.layout.activity_schedules_list);
        ButterKnife.bind(this);
        preferences = context.getSharedPreferences("MyPreferences", 0);
        createProgressDialog();
        progressDialog.show();
        getAuth();

    }


    /* Obtaining Auth */
    public void getAuth(){

        AirLineApiInterface lineApiInterface = RetrofitInstance.getRetrofitInstance().create(AirLineApiInterface.class);
        Call<Token> tokenCall = lineApiInterface.getToken(CLIENT_ID, CLIENT_SECRET, GRANT_TYPE);
        tokenCall.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                Token token = response.body();
                if (response.isSuccessful() && token != null){
                    String accessToken = token.getAccesToken();
                    Log.d(TAG, "Obtaining Token");
                    Log.d(TAG, "The token is " + accessToken);

                    AirLineApiInterface lineApiInterface = RetrofitInstance.getRetrofitInstance().create(AirLineApiInterface.class);
                    Call<List<Schedule>> listCall = lineApiInterface.getSchedules(BREARER + accessToken, ACCEPT, preferences.getString("ORIGIN_AIR", ""), preferences.getString("DEST_AIR", ""), "2019-05-14");
                    listCall.enqueue(new Callback<List<Schedule>>() {
                        @Override
                        public void onResponse(Call<List<Schedule>> call, Response<List<Schedule>> response) {
                            progressDialog.dismiss();
                            List<Schedule> schedules = response.body();
                            Log.d(TAG, "SchedulesList size is " + schedules.size());
                            if (schedules != null && !schedules.isEmpty()){
                                generateScheduleList(schedules);


                            } else {
                                Toast.makeText(SchedulesActivity.this, "Nothing found!", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<List<Schedule>> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(SchedulesActivity.this, "Unable to contact server. Please Try Later", Toast.LENGTH_LONG).show();

                        }
                    });

                }

            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                progressDialog.dismiss();
                Log.d(TAG, "Error is " + t.getMessage());
                Toast.makeText(SchedulesActivity.this, "Unable to connect", Toast.LENGTH_LONG).show();

            }
        });


    }

    /* Method to generate Schedule List */
    private void generateScheduleList(final List<Schedule> dataList){
        adapter = new SchedulesAdapter(dataList, context);
//

        schedulesListView.setAdapter(adapter);
    }

    private void createProgressDialog() {
        progressDialog = new ProgressDialog(SchedulesActivity.this);
        Log.d(TAG, "The progress dialog has been set");
        progressDialog.setTitle("Loading...");
        progressDialog.setMessage("Obtaining Schedules");
        progressDialog.setCancelable(false);

    }

    /* Method For Obtaining Airport Code From Provided Country */
    private String getAirportCode(String countryName){
        String[] isoCountryCodes = Locale.getISOCountries();
        for (String code : isoCountryCodes) {
            Locale locale = new Locale("", code);
            if (countryName.equalsIgnoreCase(locale.getDisplayCountry())) {
                return code;
            }
        }
        return "";
    }
}

package com.airlineschedules;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Ed Ssemuwemba on 11/05/19.
 * esseme@gmail.com
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.originEditText)
    EditText originEdit;
    @BindView(R.id.destEditText)
    EditText destEdit;
    @BindView(R.id.submitButton)
    Button submit;
    private String origin, destination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    /* For Submitting Details */
    private void submitDetails(){
        origin = originEdit.getText().toString().trim();
        destination = destEdit.getText().toString().trim();
        boolean validOrigin = isOriginValid(origin);
        boolean validDest = isDestValid(destination);
        if (!validOrigin || !validDest) return;



    }

    /* Validations */
    private boolean isOriginValid(String origin){
        if (origin.equals("")){
            originEdit.setError("Please Type An Origin");
            return false;
        }
        return true;
    }

    private boolean isDestValid(String dest){
        if (dest.equals("")){
            destEdit.setError("Please Type A Destination");
            return false;
        }
        return true;

    }



}

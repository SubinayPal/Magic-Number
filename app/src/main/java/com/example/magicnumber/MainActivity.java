package com.example.magicnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etID;
    Button btnSubmit;
    TextView tvResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = findViewById(R.id.etID);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResults = findViewById(R.id.tvResults);
        tvResults.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idNumber = etID.getText().toString().trim();
                String dob = idNumber.substring(0,6);

                //seperating dob as yy mm dd

                String yy = dob.substring(0,2);
                String mm = dob.substring(2,4);
                String dd = dob.substring(4,6);

                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));
                String sGender;
                if(gender < 5){
                    sGender = getString(R.string.female);
                }
                else{
                    sGender = getString(R.string.male);
                }

                int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));
                String sNationality;
                if(nationality == 0){
                    sNationality = getString(R.string.indian);
                }
                else{
                    sNationality = getString(R.string.others);
                }

                String result = getString(R.string.dob) + dd + "/" + mm + "/" + yy + "\n"+
                        getString(R.string.gender) + sGender + "\n"+
                        getString(R.string.nationality) + sNationality;

                tvResults.setText(result);
                tvResults.setVisibility(View.VISIBLE);
            }
        });
    }
}
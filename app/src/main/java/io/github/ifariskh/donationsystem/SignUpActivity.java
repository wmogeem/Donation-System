package io.github.ifariskh.donationsystem;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity {

    private EditText dob;
    private Button signInBt;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final Calendar CALENDER = Calendar.getInstance();
        final int YEAR = CALENDER.get(Calendar.YEAR);
        final int MONTH = CALENDER.get(Calendar.MONTH);
        final int DAY = CALENDER.get(Calendar.DAY_OF_MONTH);

        dob = findViewById(R.id.dob);
        signInBt = (Button) findViewById(R.id.sign_in_button);

        signInBt.setOnClickListener(view -> {
            openSignUpActivity();
        });

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        SignUpActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                i1 = i1 + 1;
                                String date = i2 + "/" + i1 +"/" + i;
                                dob.setText(date);
                            }
                        }, YEAR, MONTH, DAY);
                datePickerDialog.show();
            }
        });
    }

    private void openSignUpActivity() {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }
}
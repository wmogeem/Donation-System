package io.github.ifariskh.donationsystem.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

import io.github.ifariskh.donationsystem.R;
import io.github.ifariskh.donationsystem.core.User;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    private TextInputLayout fullName, email, id, password, phone;
    private EditText dob;
    private Button signInBt, singUpBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fullName = findViewById(R.id.full_name);
        email = findViewById(R.id.email);
        id = findViewById(R.id.id);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone);
        dob = findViewById(R.id.dob);
        signInBt = findViewById(R.id.sign_in_button);
        singUpBt = findViewById(R.id.sign_up_button);

        initCalender();

        signInBt.setOnClickListener(this);
        singUpBt.setOnClickListener(this);
    }

    private void initCalender() {
        final Calendar CALENDER = Calendar.getInstance();
        final int YEAR = CALENDER.get(Calendar.YEAR);
        final int MONTH = CALENDER.get(Calendar.MONTH);
        final int DAY = CALENDER.get(Calendar.DAY_OF_MONTH);

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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sign_in_button:
                Intent intent = new Intent(this, SignInActivity.class);
                startActivity(intent);
                break;
            case R.id.sign_up_button:
                User user = new User(
                        fullName.getEditText().getText().toString().trim(),
                        email.getEditText().getText().toString().trim(),
                        id.getEditText().getText().toString().trim(),
                        phone.getEditText().getText().toString().trim(),
                        dob.getText().toString().trim()
                );
                user.register(password.getEditText().getText().toString().trim(), this);
                break;
        }
    }
}
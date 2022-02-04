package io.github.ifariskh.donationsystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import io.github.ifariskh.donationsystem.R;

public class SignInActivity extends AppCompatActivity {

    private Button signUpBt;
    private Button signInBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        signUpBt = (Button) findViewById(R.id.sign_up_button);
        signInBt = (Button) findViewById(R.id.sign_in_button);

        signUpBt.setOnClickListener(view -> {
            openSignUpActivity();
        });

        signInBt.setOnClickListener(view -> {
            openNavigationActivity();
        });
    }

    private void openNavigationActivity() {
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }

    private void openSignUpActivity() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }


}
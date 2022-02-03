package io.github.ifariskh.donationsystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {

    private Button signUpBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        signUpBt = (Button) findViewById(R.id.sign_up_button);

        signUpBt.setOnClickListener(view -> {
            openSignUpActivity();
        });
    }

    private void openSignUpActivity() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }


}
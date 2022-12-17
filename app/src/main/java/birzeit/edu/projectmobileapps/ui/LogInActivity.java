package birzeit.edu.projectmobileapps.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import birzeit.edu.projectmobileapps.R;

public class LogInActivity extends AppCompatActivity {

    private Button btn_login;
    private Button btn_guest;
    private Button btn_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        extracted();


    }

    private void extracted() {
        btn_login=findViewById(R.id.btn_login);
        btn_guest=findViewById(R.id.btn_guest);
        btn_signup=findViewById(R.id.btn_signup);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LogInActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();

            }
        });

        btn_guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LogInActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });


        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LogInActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
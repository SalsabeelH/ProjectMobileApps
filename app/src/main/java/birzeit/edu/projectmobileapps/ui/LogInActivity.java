package birzeit.edu.projectmobileapps.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.SigningInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import birzeit.edu.projectmobileapps.R;
import birzeit.edu.projectmobileapps.SharedPreferences.SharedPrefManager;

public class LogInActivity extends AppCompatActivity {

    private Button btn_login;
    private ImageView btn_guest;
    private Button btn_signup;
    private TextView ediTxtEmail;
    private TextView ediTxtPassword;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        extracted();


    }

    private void extracted() {
        btn_login = findViewById(R.id.btn_login);
        btn_guest = findViewById(R.id.btn_guest);
        btn_signup = findViewById(R.id.btn_signup);
        ediTxtEmail = findViewById(R.id.txtEmail);
        ediTxtPassword = findViewById(R.id.txtPassword);
        sharedPrefManager=SharedPrefManager.getInstance(this);
        boolean logeIn = sharedPrefManager.readBoolean("logeIn",false);

        if (logeIn == true){
            ediTxtEmail.setText(sharedPrefManager.readString("email",""));
            ediTxtPassword.setText(sharedPrefManager.readString("password",""));
        }

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ediTxtEmail.getText().toString().equals(sharedPrefManager.readString("email","")) && ediTxtPassword.getText().toString().equals(sharedPrefManager.readString("password",""))){
                    if(logeIn == false){
                        sharedPrefManager.writeBoolean("logeIn",true);
                    }
                    Intent intent=new Intent(LogInActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(LogInActivity.this ,"wrong password or email", Toast.LENGTH_LONG).show();
                }
            }
        });

        btn_guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent intent=new Intent(LogInActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();

                */
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
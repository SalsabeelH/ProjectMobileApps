package birzeit.edu.projectmobileapps.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import birzeit.edu.projectmobileapps.R;
import birzeit.edu.projectmobileapps.SharedPreferences.SharedPrefManager;

public class SignUpActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextName;
    private RadioGroup rdGroup;
    private EditText editTextAge;
    private EditText editTextHeight;
    private EditText editTextWeight;
    private EditText editTextTarget;
    private ImageView btnReturnToMain;
    private Button signup_home;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();
        setActionListeners();
    }

    private void init() {
        editTextEmail = findViewById(R.id.txt_email);
        editTextPassword = findViewById(R.id.txt_password);
        editTextName = findViewById(R.id.txt_name);
        editTextAge = findViewById(R.id.txt_age);
        editTextHeight = findViewById(R.id.txt_height);
        editTextWeight = findViewById(R.id.txt_weight);
        rdGroup = findViewById(R.id.radioGroup);
        editTextTarget = findViewById(R.id.txt_target);
        signup_home = findViewById(R.id.btn_signup_home);
        btnReturnToMain = findViewById(R.id.btn_to_main);
        sharedPrefManager = SharedPrefManager.getInstance(this);
    }

    private void setActionListeners() {
        signup_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                String name = editTextName.getText().toString();
                int age = 0;
                if(!editTextAge.getText().toString().isEmpty())
                    age = Integer.parseInt(editTextAge.getText().toString());

                int height = 0;
                if(!editTextHeight.getText().toString().isEmpty())
                    height = Integer.parseInt(editTextHeight.getText().toString());

                float weight = 0;
                if(!editTextWeight.getText().toString().isEmpty())
                    weight = Float.parseFloat(editTextWeight.getText().toString());

                float targetWeight = 0;
                if(!editTextTarget.getText().toString().isEmpty())
                    targetWeight = Float.parseFloat(editTextTarget.getText().toString());

                String gender = "";
                int id = rdGroup.getCheckedRadioButtonId();
                if(id != -1){
                    RadioButton selectedRd = findViewById(id);
                    gender = selectedRd.getHint().toString();
                }

                String validationDataMessage = dataValidation(email, password, name, gender, age, height, weight, targetWeight);
                if (validationDataMessage == "pass"){
                    writeToSharedPref(email, password, name, gender, age, height, weight, targetWeight);
                    Intent intent=new Intent(SignUpActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(SignUpActivity.this , validationDataMessage, Toast.LENGTH_LONG).show();
                }
            }
        });

        btnReturnToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignUpActivity.this, LogInActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private String dataValidation(String email, String password, String name, String gender, int age, int height, float weight, float targetWeight){
        if (email.length() == 0 || !email.contains("@"))
            return "you need to enter a valid email";
        if (password.length() < 5 )
            return "Password must be 8 digits at least";
        if (name.length() == 0)
            return "Missed name field";
        if (gender == "")
            return "Please choose the gender";
        if (age == 5 || age < 5 || age > 120)
            return "You need to enter your real age";
        if (height < 50 || height > 300)
            return "You need to enter your real height in cm";
        if (weight < 20 || weight > 500)
            return "You need to enter your real weight in kg";
        if (targetWeight < 20 || targetWeight > 500)
            return "The Target Weight must be entered in kg";
        return "pass";
    }
    private void writeToSharedPref(String email, String password, String name, String gender, int age, int height, float weight, float targetWeight){
        sharedPrefManager.writeString("email",email);
        sharedPrefManager.writeString("password",password);
        sharedPrefManager.writeString("name",name);
        sharedPrefManager.writeString("gender",gender);
        sharedPrefManager.writeInt("age",age);
        sharedPrefManager.writeInt("height",height);
        sharedPrefManager.writeFloat("weight",weight);
        sharedPrefManager.writeFloat("targetWeight",targetWeight);
    }

}
package birzeit.edu.projectmobileapps.ui;

import birzeit.edu.projectmobileapps.R;
import birzeit.edu.projectmobileapps.model.Calculation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class CalculationActivity extends AppCompatActivity {

    private TextView equation;
    private ImageView past_page;
    private ImageView next_equ;
    private ImageView correct;
    private ImageView incorrect;
    private ProgressBar mProgressBar;
    private CountDownTimer mCountDownTimer;
    private int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);
        extracted();
        displayEquation();
    }

    private void extracted() {
        equation=findViewById(R.id.tvEquation);
        past_page=findViewById(R.id.pastPage);
        next_equ=findViewById(R.id.nextEquation);
        correct=findViewById(R.id.correct);
        incorrect=findViewById(R.id.incorrect);
        mProgressBar=(ProgressBar)findViewById(R.id.progressBar);

        past_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CalculationActivity.this,MentalFragment.class);
                startActivity(intent);
                finish();
            }
        });

        next_equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayEquation();

            }
        });

        correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CalculationActivity.this,"Correct answer",Toast.LENGTH_LONG).show();
            }
        });

        incorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CalculationActivity.this,"Incorrect answer",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void displayEquation(){
        /*Prepare data*/
       Calculation calc=new Calculation();
       calc.generateRandom();
       calc.getResult();
       String equ=calc.getNum1()+" * "+calc.getNum2()+" = "+calc.getAns();
       equation.setText(equ);




    }
}
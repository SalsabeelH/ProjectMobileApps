package birzeit.edu.projectmobileapps.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.ImageButton;
import android.widget.ImageView;

import birzeit.edu.projectmobileapps.R;
import birzeit.edu.projectmobileapps.model.Difference;

public class DifferenceActivity extends AppCompatActivity {

    private Button choice1;
    private Button choice2;
    private Button choice3;
    private Button choice4;
    private ImageView differenceImg;
    private ImageView back;
    private ImageButton next;
    private Difference difference;
    private int index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difference);

        extracted();
        nextDispaly();
    }

    private void extracted() {
        choice1=findViewById(R.id.choice1);
        choice2=findViewById(R.id.choice2);
        choice3=findViewById(R.id.choice3);
        choice4=findViewById(R.id.choice4);
        differenceImg=findViewById(R.id.differenceImg);
        back=findViewById(R.id.back);
        next=findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextDispaly();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DifferenceActivity.this,MentalFragment.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void nextDispaly(){
        int diff_num,img_after,img_before;
        diff_num=Difference.differences[index].getDifferenceNumber();
        img_after=Difference.differences[index].getImgAfter();
        img_before=Difference.differences[index].getImgBefore();

        Drawable drawable = getResources().getDrawable(img_before);
        differenceImg.setImageDrawable(drawable);
        choice1.setText(diff_num-1+"");
        choice2.setText(diff_num-2+"");
        choice3.setText(diff_num+"");
        choice4.setText(diff_num+1+"");

        choice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable drawable = getResources().getDrawable(img_after);
                differenceImg.setImageDrawable(drawable);
            }
        });

        index++;
        if(index>Difference.differences.length-1){
            index=0;
        }

    }
}
package birzeit.edu.projectmobileapps.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import birzeit.edu.projectmobileapps.R;
import birzeit.edu.projectmobileapps.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

    final double INITIAL_WEIGHT = 100;
    final double TARGET_WEIGHT = 60;
    final double CURRENT_WEIGHT = 65;
    final double HEIGHT = 1.60;

    TextView BMIIndex;
    ProgressBar progressBar;
    TextView progressTxt;
    private FragmentHomeBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        setup(root);
        setBMIValue(CURRENT_WEIGHT,HEIGHT);
        updateProgressBar(INITIAL_WEIGHT,CURRENT_WEIGHT,TARGET_WEIGHT);
        return root;
    }

    private void setup(View root) {
        BMIIndex = root.findViewById(R.id.BMI_index);
        progressBar = root.findViewById(R.id.progress_bar);
        progressTxt = root.findViewById(R.id.progress_bar_txt);
    }

    private void updateProgressBar(double initial_weight, double current_weight, double target_weight) {
        double totalDifferance = initial_weight - target_weight;
        double currentDifferance = initial_weight - current_weight;
        double ratio = (currentDifferance/totalDifferance) * 100;
        progressBar.setProgress((int)ratio);
        progressTxt.setText((int)ratio + "%");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    void setBMIValue(double weight, double height) {

        double BMI = weight / (height * height);
        if (BMI < 18.5) {
            BMIIndex.setTextColor(getResources().getColor(R.color.blue));
            BMIIndex.setText(String.format("%.2f",BMI) + " (Underweight)");
        } else if (BMI < 25) {
            BMIIndex.setTextColor(Color.GREEN);
            BMIIndex.setText(String.format("%.2f",BMI) + " (Normal)");
        } else if (BMI < 30) {
            BMIIndex.setTextColor(getResources().getColor(R.color.app_color));
            BMIIndex.setText(String.format("%.2f",BMI) + " (Overweight)");
        } else {
            BMIIndex.setTextColor(Color.RED);
            BMIIndex.setText(String.format("%.2f",BMI) + " (Obese)");
        }
    }
}
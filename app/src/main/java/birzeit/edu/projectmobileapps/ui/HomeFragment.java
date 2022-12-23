package birzeit.edu.projectmobileapps.ui;

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
import birzeit.edu.projectmobileapps.SharedPreferences.SharedPrefManager;
import birzeit.edu.projectmobileapps.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

    float currentWeight = 70f;
    float targetWeight;
    float initialWeight;
    int height;
    TextView BMIIndex;
    ProgressBar progressBar;
    TextView progressTxt;
    private FragmentHomeBinding binding;
    SharedPrefManager sharedPrefManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        sharedPrefManager = SharedPrefManager.getInstance(root.getContext());
        setup(root);
        setBMIValue(currentWeight, height);
        updateProgressBar(initialWeight, currentWeight, targetWeight);
        return root;
    }

    private void setup(View root) {
        BMIIndex = root.findViewById(R.id.BMI_index);
        progressBar = root.findViewById(R.id.progress_bar);
        progressTxt = root.findViewById(R.id.progress_bar_txt);
        initialWeight = sharedPrefManager.readFloat("weight", 100f);
        targetWeight = sharedPrefManager.readFloat("targetWeight", 60f);
        height = sharedPrefManager.readInt("height", 160);
    }

    private void updateProgressBar(double initial_weight, double current_weight, double target_weight) {
        double totalDifferance = initial_weight - target_weight;
        double currentDifferance = initial_weight - current_weight;
        double ratio = (currentDifferance / totalDifferance) * 100;
        progressBar.setProgress((int) ratio);
        progressTxt.setText((int) ratio + "%");
    }

    void setBMIValue(double weight, int height) {

        double BMI = weight / ((double) ((height * height) / 10000));
        if (BMI < 18.5) {
            BMIIndex.setTextColor(getResources().getColor(R.color.blue));
            BMIIndex.setText(String.format("%.2f", BMI) + " (Underweight)");
        } else if (BMI < 25) {
            BMIIndex.setTextColor(Color.GREEN);
            BMIIndex.setText(String.format("%.2f", BMI) + " (Normal)");
        } else if (BMI < 30) {
            BMIIndex.setTextColor(getResources().getColor(R.color.app_color));
            BMIIndex.setText(String.format("%.2f", BMI) + " (Overweight)");
        } else {
            BMIIndex.setTextColor(Color.RED);
            BMIIndex.setText(String.format("%.2f", BMI) + " (Obese)");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
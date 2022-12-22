package birzeit.edu.projectmobileapps.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import birzeit.edu.projectmobileapps.R;
import birzeit.edu.projectmobileapps.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

    final double INITIAL_WEIGHT = 75;
    final double TARGET_WEIGHT = 60;
    final double CURRENT_WEIGHT = 65;
    final double HEIGHT = 1.60;

    TextView BMIIndex;
    private FragmentHomeBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        BMIIndex = root.findViewById(R.id.BMI_index);
        setBMIValue(CURRENT_WEIGHT,HEIGHT);
        return root;
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
            BMIIndex.setText(String.format("%.2f",BMI) + "\nUnderweight");
        } else if (BMI < 25) {
            BMIIndex.setTextColor(Color.GREEN);
            BMIIndex.setText(String.format("%.2f",BMI) + "\nNormal");
        } else if (BMI < 30) {
            BMIIndex.setTextColor(getResources().getColor(R.color.app_color));
            BMIIndex.setText(String.format("%.2f",BMI) + "\nOverweight");
        } else {
            BMIIndex.setTextColor(Color.RED);
            BMIIndex.setText(String.format("%.2f",BMI) + "\nObese");
        }
    }
}
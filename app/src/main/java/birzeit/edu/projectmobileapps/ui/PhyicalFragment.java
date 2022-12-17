package birzeit.edu.projectmobileapps.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import birzeit.edu.projectmobileapps.databinding.FragmentPhysicalBinding;


public class PhyicalFragment extends Fragment {

    private FragmentPhysicalBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentPhysicalBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
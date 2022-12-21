package birzeit.edu.projectmobileapps.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import birzeit.edu.projectmobileapps.R;
import birzeit.edu.projectmobileapps.model.PhysicalExercise;
import pl.droidsonroids.gif.GifImageView;

public class PhysicalRecyclerAdapter extends RecyclerView.Adapter<PhysicalRecyclerAdapter.ViewHolder> {

    private PhysicalExercise[] exercises;

    public PhysicalRecyclerAdapter(PhysicalExercise[] exercises) {
        this.exercises = exercises;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.physical_item, parent, false);
        return new PhysicalRecyclerAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PhysicalRecyclerAdapter.ViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        GifImageView exerciseGif = cardView.findViewById(R.id.physical_exercise_gif);
        exerciseGif.setImageResource(exercises[position].getGifID());
        TextView exerciseName = cardView.findViewById(R.id.physical_exercise_name);
        exerciseName.setText(exercises[position].getName());
        TextView exerciseDuration = cardView.findViewById(R.id.physical_exercise_duration);
        exerciseDuration.setText(exercises[position].getDuration() + " min");
        cardView.setOnClickListener(v -> {
            //
        });
    }

    @Override
    public int getItemCount() {
        return exercises.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(CardView cardView) {
            super(cardView);
            this.cardView = cardView;
        }

    }
}

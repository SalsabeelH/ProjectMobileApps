package birzeit.edu.projectmobileapps.model;

import birzeit.edu.projectmobileapps.R;

public class PhysicalExercise {
    private String name;
    private int gifID;
    private int duration;

    public static final PhysicalExercise[] physicalExercises = {
            new PhysicalExercise("Push Up", R.drawable.physicalexercise_pushup, 1),
            new PhysicalExercise("Jumping Jack", R.drawable.physicalexercise_jumpingjack, 2),
            new PhysicalExercise("Sit Up", R.drawable.physicalexercise_situp, 3)
    };

    private PhysicalExercise(String name, int gifID, int duration) {
        this.name = name;
        this.gifID = gifID;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getGifID() {
        return gifID;
    }

    public int getDuration() {
        return duration;
    }
}

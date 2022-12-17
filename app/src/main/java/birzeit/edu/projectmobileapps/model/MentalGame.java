package birzeit.edu.projectmobileapps.model;

import birzeit.edu.projectmobileapps.R;

public class MentalGame {

    private String name;
    private int imageID;

    public static final MentalGame[] mental_games = {
            new MentalGame ("Calculations", R.drawable.calc),
            new MentalGame ("Puzzels", R.drawable.puzzle),
            new MentalGame ("Find the difference", R.drawable.find)

    };
    private MentalGame (String name, int imageID){
        this.name = name;
        this.imageID = imageID;
    }
    public String getName(){return name;}
    public int getImageID(){return imageID;}

}
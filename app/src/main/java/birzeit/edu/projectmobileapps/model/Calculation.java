package birzeit.edu.projectmobileapps.model;

import java.util.Random;

/**
 * vars 2numbers,result,operation
 * 2 methods
 * 1-generate random num from 0-99
 * 2-generate random numbers from 0-999
 * 3-random operation
 */
public class Calculation {
    private int num1;
    private int num2;
    private int ans;
    private final int upper=20;
    /**
     * Locally choose num1,num2
     */
     public void generateRandom(){
         Random random = new Random();
         num1=random.nextInt(upper);
         num2=random.nextInt(upper);
     }
     public void getResult(){
         ans=num1*num2;
     }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public int getAns() {
        return ans;
    }

    public Calculation() {
    }
}

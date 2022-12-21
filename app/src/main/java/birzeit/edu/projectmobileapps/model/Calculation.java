package birzeit.edu.projectmobileapps.model;

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
private int num3;
private int ans;

    public Calculation(int num1, int num2, int num3, int ans) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.ans = ans;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getNum3() {
        return num3;
    }

    public void setNum3(int num3) {
        this.num3 = num3;
    }

    public int getAns() {
        return ans;
    }

    public void setAns(int ans) {
        this.ans = ans;
    }
}

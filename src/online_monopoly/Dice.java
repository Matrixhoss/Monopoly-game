package online_monopoly;

import java.util.Random;

public class Dice {

    private int[] d = new int[2];           //D stands for dice, array of d is an array of 2 dices
    private int dd;                         // dd stands for DoubleDice
    private boolean roll;
    private boolean jail;
    private Random rand;
    
    

    public boolean test = false;

    public Dice() {
        this.d[0] = 0;
        this.d[1] = 0;
        this.dd = 0;
        this.roll = true;
        this.rand = new Random();
    }

    public boolean checkFlag() {
        return this.roll;
    }

    public int[] rollDice(Player p) {

        this.d[0] = (rand.nextInt(6) + 1);   //random(6)+1 to avoid 0
        this.d[1] = (rand.nextInt(6) + 1);
        if (p.checkInJail() == true) {
            if (this.d[0] == this.d[1]) {
                p.exitFromJail();
                this.roll = false;
            } else {
                this.d[0] = 0;
                this.d[1] = 0;
            }
        } else {
            if (this.d[0] == this.d[1]) {       //if both dices have the same value 
                dd += 1;                        //add +1 to double dice 
                System.out.println("DD " + dd);
                if (dd == 3) {                  // if player rolls 3 doubles, send him to jail and disable roll                
                    p.goToJail();
                    this.roll = false;
                }
            } else {
                dd = 0;                         // after normal roll, disable the roll button
                this.roll = false;
                System.out.println("DD " + dd);
            }
        }
        return d;

    }

    public void enableRolling() {
        this.roll = true;
    }

    public void disableRolling() {
        this.roll = true;
    }

}

package online_monopoly;

import java.util.ArrayList;

public class Endgame {
    ArrayList playerprop = new ArrayList();
    private int playerno[] = new int[4];
    private int playermoney[] = new int[4];
    //private int playerproperty[]= new int[4];
    private int playerhouse[]= new int[4];
    private int playerhotels[]= new int[4];
    private int total[]= new int[4];
    private int win;
    
    public Endgame(){
        for (int i = 0; i < playerno.length; i++) {
            playerno[i]=0;
        }
        for (int i = 0; i < playermoney.length; i++) {
            playermoney[i]=0;
        }
//        for (int i = 0; i < playerproperty.length; i++) {
//            playerproperty[i]=0;
//        }
        for (int i = 0; i < playerhouse.length; i++) {
            playerhouse[i]=0;
        }
        for (int i = 0; i < playerhotels.length; i++) {
            playerhotels[i]=0;
        }
        for (int i = 0; i < total.length; i++) {
            total[i]=0;
        }
        for (int i = 0; i < playerprop.size(); i++) {
            playerprop.add(i);
        }
        this.win=playerno[0];
    }
    public void addtotal(){
        int chos=0;
        switch(playerno[chos]){
            case 0:
                for (int i = 0; i < 10; i++) {
                    total[0]+=playermoney[i];    
                }
//                for (int i = 0; i < 10; i++) {
//                    total[0]+=playerproperty[i];    
//                }
                for (int i = 0; i < 10; i++) {
                    total[0]+=playerhouse[i];    
                }
                for (int i = 0; i < 10; i++) {
                    total[0]+=playerhotels[i];    
                }
                for (int i = 0; i < 10; i++) {
                    total[0]=total[0]+playerprop.indexOf(i);
                }
                break;
            case 1:
                for (int i = 0; i < 10; i++) {
                    total[1]+=playermoney[i];    
                }
//                for (int i = 0; i < 10; i++) {
//                    total[1]+=playerproperty[i];    
//                }
                for (int i = 0; i < 10; i++) {
                    total[1]+=playerhouse[i];    
                }
                for (int i = 0; i < 10; i++) {
                    total[1]+=playerhotels[i];    
                }
                for (int i = 0; i < 10; i++) {
                    total[0]=total[0]+playerprop.indexOf(i);
                }
                break;
            case 2:
                for (int i = 0; i < 10; i++) {
                    total[2]+=playermoney[i];    
                }
//                for (int i = 0; i < 10; i++) {
//                    total[2]+=playerproperty[i];    
//                }
                for (int i = 0; i < 10; i++) {
                    total[2]+=playerhouse[i];    
                }
                for (int i = 0; i < 10; i++) {
                    total[2]+=playerhotels[i];    
                }
                for (int i = 0; i < 10; i++) {
                    total[0]=total[0]+playerprop.indexOf(i);
                }
                break;
            case 3:
                for (int i = 0; i < 10; i++) {
                    total[3]+=playermoney[i];    
                }
//                for (int i = 0; i < 10; i++) {
//                    total[3]+=playerproperty[i];    
//                }
                for (int i = 0; i < 10; i++) {
                    total[3]+=playerhouse[i];    
                }
                for (int i = 0; i < 10; i++) {
                    total[3]+=playerhotels[i];    
                }
                for (int i = 0; i < 10; i++) {
                    total[0]=total[0]+playerprop.indexOf(i);
                }
                break;
        }
    }
    public int winner(){
        for (int i = 0; i < 4; i++) {
            if(playerno[i]>win){
                win =playerno[i];
            }
        }
        return win;
    }
}
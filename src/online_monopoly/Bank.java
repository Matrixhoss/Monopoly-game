/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_monopoly;

/**
 *
 * @author fadia
 */
public class Bank {
    int hotelsAvailable;
    int housesAvailable;
    int money;
    public boolean buyHotel(){
        if(hotelsAvailable>0)
        {
            hotelsAvailable--;
            return true;
        }
        return false;
    }
    public boolean buyHouse(){
        if(hotelsAvailable>0)
        {
            housesAvailable--;
            return true;
        }
        return false;
    }
    public boolean areHotelsAvailable(int num){
        return hotelsAvailable>=num;
    }
    public boolean areHousesAvailable(int num){
        return housesAvailable>=num;
    }
}

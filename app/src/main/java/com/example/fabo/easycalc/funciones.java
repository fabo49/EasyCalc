package com.example.fabo.easycalc;
/**
 * Created by Fabian on 24/5/15.
 */
public class funciones {

    private double s1;
    private double s2;

    public void setS1(String str){
        s1 = Double.parseDouble(str);
    }

    public void setS2(String str){
        s2 = Double.parseDouble(str);
    }

    public String suma(){
        return Double.toString(s1+s2);
    }

    public String resta(){
        return Double.toString(s1-s2);
    }

    public String division(){
        if(s2 != 0){
            return Double.toString(s1/s2);
        }else{
            return "ERROR";
        }
    }

    public String multi(){
        return Double.toString(s1*s2);
    }
}

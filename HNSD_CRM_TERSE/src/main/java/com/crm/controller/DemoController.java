package com.crm.controller;

public class DemoController {

    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        while (true){
            a++;
            if(b<10){
                b = b + 3;
                if(b>=10){
                    break;
                }else{
                    b = b-2;
                }
            }else{
                break;
            }
        }
        System.out.println(a);

    }

}

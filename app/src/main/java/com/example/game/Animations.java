package com.example.game;

public class Animations implements Runnable{
    private int var;
    public Animations(int var){
        this.var = var;
    }
    public void run(){
        System.out.println("RODANDO THREAD");
    }
}

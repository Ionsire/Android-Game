package com.example.game;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import static com.example.game.GameView.screenRatioX;
import static com.example.game.GameView.screenRatioY;

import java.util.ArrayList;

public class Player {

    int frameIndex = 0;

    // Posicao 2D inicial na tela
    int velocity = 10;
    int posX = 0;
    int posY = 0;

    // Dimensoes do player
    int width, height;

    // Imagens da animacao
    Bitmap sprite1, sprite2, sprite3;

    //ArrayList<Bitmap> spriteArray = new ArrayList<Bitmap>();

    Player(Resources res){
        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        sprite1 = BitmapFactory.decodeResource(res, R.drawable.player);
        sprite2 = BitmapFactory.decodeResource(res, R.drawable.player2);
        sprite3 = BitmapFactory.decodeResource(res, R.drawable.player3);

        width = sprite1.getWidth();
        height = sprite1.getHeight();

        // diminuindo o tamanho do player
        width /= 12;
        height /= 12;


        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        sprite1 = Bitmap.createScaledBitmap(sprite1, width, height,false);
        sprite2 = Bitmap.createScaledBitmap(sprite2, width, height,false);
        sprite3 = Bitmap.createScaledBitmap(sprite3, width, height,false);
//        spriteArray.add(sprite1);
//        spriteArray.add(sprite2);
//        spriteArray.add(sprite3);


    }
    Bitmap walkAnimation(){
        if (frameIndex == 0){
            frameIndex++;
            return sprite1;
        }
        else if(frameIndex == 1){
            frameIndex++;
            return sprite2;
        }

        // Reset sprite index
        frameIndex=0;
        return sprite3;

    }

}

package com.example.game;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import static com.example.game.GameView.screenRatioX;
import static com.example.game.GameView.screenRatioY;

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

    Player(Resources res){
        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        sprite1 = BitmapFactory.decodeResource(res, R.drawable.player);

        width = sprite1.getWidth();
        height = sprite1.getHeight();

        // diminuindo o tamanho do player
        width /= 12;
        height /= 12;


        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        sprite1 = Bitmap.createScaledBitmap(sprite1, width, height,false);

    }
    Bitmap walkAnimation(){
        if (frameIndex == 0){
            frameIndex++;
            return sprite1;
        }
        frameIndex--;

        return sprite2;
    }

}

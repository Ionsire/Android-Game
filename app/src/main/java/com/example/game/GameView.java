package com.example.game;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable{

    private Thread thread;
    private final GameActivity activity;
    private final int screenX;
    private final int screenY;
    public static float screenRatioX, screenRatioY;
    private final Paint paint;

    private final Player player;



    private int directionX = 0;
    private int directionY = 0;
    private int velocity = 10; // quantia de pixels de movimento
    private int positionX = 50;
    private int positionY = 50;

    private Bitmap button;
    private Bitmap button_R, button_L, button_D, button_U;
    private Ui ui;


    public GameView(GameActivity activity, int screenX, int screenY) {
        super(activity);


        button = BitmapFactory.decodeResource(getResources(), R.drawable.player);

        // Ui for move
        ui = new Ui(getResources());

        button_R = ui.getButton_R();
        button_L = ui.getButton_L();
        button_D = ui.getButton_D();
        button_U = ui.getButton_U();

        this.activity = activity;

        this.screenX = screenX;
        this.screenY = screenY;
        screenRatioX = 1920f / screenX;
        screenRatioY = 1080f / screenY;

        player = new Player(getResources());

        paint = new Paint();
        paint.setTextSize(128);
        paint.setColor(Color.WHITE);



    }

    @Override
    public void run() {
        while (true) {

            update ();
            draw ();


        }
    }

    // Usado para iniciar a Thread que roda o jogo
    public void resume () {

        //isPlaying = true;
        thread = new Thread(this);
        thread.start();

    }

    private void update () {
        /*System.out.println(screenX + "x" +screenY);
        if (player.isMoveX){
            player.x += 3 * screenRatioX;
        }
        if (player.isMoveY){
            player.y += 3 * screenRatioY;
        }

        if (player.x < 0)
            player.x = 0;

        if (player.x >= screenX - player.width)
            player.x = screenX - player.width;*/


    }
    private void draw () {

        // Responsavel por desenhar na tela
        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();

            // pintando o fundo de branco
            canvas.drawColor(Color.WHITE);


            // Drawn the Ui buttons
            canvas.drawBitmap(button_R, 310,730, null);
            canvas.drawBitmap(button_L, 50,730, null);
            canvas.drawBitmap(button_D, 180,860, null);
            canvas.drawBitmap(button_U, 180,600, null);

            //positionX = positionX + (directionX * velocity);
            //positionY = positionY + (directionY * velocity);

            // Calc the player sprite position
            player.posX = player.posX + (directionX * player.velocity);
            player.posY = player.posY + (directionY * player.velocity);


            // Drawning the player on screen
            canvas.drawBitmap(player.sprite1, player.posX, player.posY, null);
//            canvas.drawBitmap(player.sprite1, player.x,player.y, paint);

            getHolder().unlockCanvasAndPost(canvas);

        }
        invalidate();

    }


    // Detectar toque na tela
    @Override
    public boolean onTouchEvent(MotionEvent event) {

//        SurfaceHolder holder = getHolder();
//        Canvas canvas = holder.lockCanvas();
//        if(canvas != null){
//            canvas.drawColor(Color.WHITE);
//
//            canvas.drawBitmap(button, 50 + cont, 50, null);
//
//            holder.unlockCanvasAndPost(canvas);
        //cont += 10;
//            invalidate();
//
//        }

        switch (event.getAction()) {
            // Se clicar na tela
            case MotionEvent.ACTION_DOWN:


                int xTouch = (int) event.getX();
                int yTouch = (int) event.getY();

                // Test for button Right
                if ( xTouch >= 310 && xTouch < (310 + button_R.getWidth())
                        && yTouch >= 730 && yTouch < (730 + button_R.getHeight())){
                    System.out.println("TOCOU EM R");
                    directionX = 1;
                }
                // Test for button Left
                if ( xTouch >= 50 && xTouch < (50 + button_R.getWidth())
                        && yTouch >= 730 && yTouch < (730 + button_R.getHeight())){
                    System.out.println("TOCOU EM L");
                    directionX = -1;
                }
                // Test for button Down
                if ( xTouch >= 180 && xTouch < (180 + button_R.getWidth())
                        && yTouch >= 860 && yTouch < (860 + button_R.getHeight())){
                    System.out.println("TOCOU EM D");
                    directionY = 1;
                }
                // Test for button Up
                if ( xTouch >= 180 && xTouch < (180 + button_R.getWidth())
                        && yTouch >= 600 && yTouch < (600 + button_R.getHeight())){
                    System.out.println("TOCOU EM U");
                    directionY = -1;
                }




                //if (event.getX() < screenX / 2) {
                    //player.isMoveX = true;
                //}
                //else if (event.getX() > screenX / 2){
                    //player.isMoveY = true;
                //}
                //invalidate();
                break;
            // Se tirar o dedo da tela
            case MotionEvent.ACTION_UP:

                directionX = 0;
                directionY = 0;

                //player.isMoveX = false;
                //player.isMoveY = false;
                //if (event.getX() > screenX / 2)
                    //flight.toShoot++;

                break;
        }

        return true;
    }
}

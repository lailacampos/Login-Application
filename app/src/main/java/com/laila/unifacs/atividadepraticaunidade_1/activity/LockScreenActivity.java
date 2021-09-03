package com.laila.unifacs.atividadepraticaunidade_1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;

import com.laila.unifacs.atividadepraticaunidade_1.R;

public class LockScreenActivity extends AppCompatActivity {

    // Notification activity that is called after too many failed login attempts

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock_screen);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setTitle("");
        setFinishOnTouchOutside(false);

        // A Handler allows you to send and process Message and Runnable objects associated with a thread's MessageQueue.
        // Um Handlers é um objeto que "posta" uma operação de UI na fila de operações a serem executadas pelo thread principal.
        Handler handler = new Handler();

        // Runnable is an interface that contains the method run(). Inside run() should be all the procedures that need to be executed in parallel.
        // Runnable é uma interface que possui um método run. Dentro do método run devem ficar os procedimentos que se deseja executar paralelamente.
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finishAffinity();
//                finishAndRemoveTask();
                System.exit(0);
            }
        }, 5000);
//        this.setFinishOnTouchOutside(false);
    }
}
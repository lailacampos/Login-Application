package com.laila.unifacs.atividadepraticaunidade_1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.laila.unifacs.atividadepraticaunidade_1.R;
import com.laila.unifacs.atividadepraticaunidade_1.model.Usuario;

public class MainScreenActivity extends AppCompatActivity {

//    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }

    public void changeToConfigScreen(View view) {

//        Intent getLoginDataIntent = getIntent();
//        Bundle bundle = getLoginDataIntent.getExtras();
//
//        if (bundle != null) {
//            this.usuario = (Usuario) bundle.getSerializable("userObj");
//        }

        Intent intent = new Intent(getApplicationContext(), ConfigScreenActivity.class);
//        intent.putExtra("userObj", this.usuario);
        startActivity(intent);
    }

    public void exitApplication(View view) {

        finishAffinity();
        System.exit(0);
    }

}
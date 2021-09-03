package com.laila.unifacs.atividadepraticaunidade_1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.laila.unifacs.atividadepraticaunidade_1.R;
import com.laila.unifacs.atividadepraticaunidade_1.model.Usuario;

public class ConfigScreenActivity extends AppCompatActivity {

    private EditText usuarioEditText, senhaEditText, confirmarSenhaEditText;
    private SharedPreferences sharedPreferences;
    private final String PREFERENCE_NAME = "myPref";
    private final String NEW_USER = "userKey";
    private final String NEW_PASSWORD = "passwordKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_screen);

        this.sharedPreferences = getSharedPreferences(this.PREFERENCE_NAME, 0);

        this.usuarioEditText = findViewById(R.id.novo_usuario_EditText);
        this.senhaEditText = findViewById(R.id.nova_senha_EditText);
        this.confirmarSenhaEditText = findViewById(R.id.confirmar_senha_EditText);
    }

    public void changeToMainScreen(View view) {
        Intent intentMainScreen = new Intent(getApplicationContext(), MainScreenActivity.class);
        startActivity(intentMainScreen);
    }

    public void changePasswordAndUser(View view) {

        // Gets user and password from edit texts
        String novoUsuario = this.usuarioEditText.getText().toString();
        String novaSenha = this.senhaEditText.getText().toString();
        String confirmarSenha = this.confirmarSenhaEditText.getText().toString();

        if (novaSenha.trim().equals("") || novoUsuario.trim().equals("")) {

            String message = getString(R.string.dados_vazios);
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        } else if (novaSenha.equals(confirmarSenha)) {

            // Stores new user and password using SharedPreferences
            // Salva novo usuário e senha com SharedPreferences
            SharedPreferences.Editor editor = this.sharedPreferences.edit();
            editor.putString(this.NEW_USER, novoUsuario);
            editor.putString(this.NEW_PASSWORD, novaSenha);
            editor.commit();

            Intent intentLoginScreen = new Intent(this, MainActivity.class);
            startActivity(intentLoginScreen);

        } else {
            String message = getString(R.string.senha_incorreta);
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        }


    }

}
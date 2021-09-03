package com.laila.unifacs.atividadepraticaunidade_1.activity;

// Useful sites:
// https://steemit.com/utopian-io/@godwyn/passing-data-between-activities-in-android-using-shared-preferences
// https://www.journaldev.com/9412/android-shared-preferences-example-tutorial

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.laila.unifacs.atividadepraticaunidade_1.R;
import com.laila.unifacs.atividadepraticaunidade_1.model.Usuario;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;
    private EditText usuarioEditText, senhaEditText;
    private Usuario usuarioObj;
    private String usuario, senha;
    private SharedPreferences sharedPreferences;
    private final String USER = "userKey";
    private final String PASSWORD = "passwordKey";
    private final String PreferenceName = "myPref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getData();

        // Binds class variables to layout elements
        // Vincula as variáveis da classe aos elementos do layout
        this.usuarioEditText = findViewById(R.id.usuario_login_EditText);
        this.senhaEditText = findViewById(R.id.senha_login_EditText);

    }

    public void getData() {

        this.sharedPreferences = getSharedPreferences(this.PreferenceName, 0);  // 0 - for private mode
        this.usuario = this.sharedPreferences.getString(this.USER, null);
        this.senha = this.sharedPreferences.getString(this.PASSWORD, null);

        if (usuario == null || senha == null) {

            // Sets default user and password
            // Configura usuário e senha iniciais
            this.usuarioObj = new Usuario("admin", "admin");

        } else {
            this.usuarioObj = new Usuario(usuario, senha);
        }
    }

    // Realiza o login
    public void login(View view) {

        // Gets values of user and password from EditText elements
        // Captura valores do usuário e senha digitados
        String user = usuarioEditText.getText().toString();
        String password = senhaEditText.getText().toString();

        // Validates if user and password are correct
        // Checa se o usuário e senha estão corretos
        if (user.equals(usuarioObj.getUsuario()) && password.equals(usuarioObj.getSenha())) {

            // Resets counter
            // Reseta o counter
            counter = 0;

            // Saves data with SharedPreferences
            // Salva dados com SharedPreferences
            SharedPreferences.Editor editor = this.sharedPreferences.edit();
            editor.putString(this.USER, user);
            editor.putString(this.PASSWORD, password);
            editor.commit();

            // Intents are asynchronous messages which allow Android components to request functionality from other components of the Android system.
            // Intents são objetos responsáveis por passar informações, como se fossem mensagens, para os principais componentes da API do Android.
            Intent intentMainScreen = new Intent(getApplicationContext(), MainScreenActivity.class);

            // startActivity() instantiates an object of the class specified in the Intent
            // startActivity() inicia uma instância da classe especificada pela Intent
            startActivity(intentMainScreen);

            // If counter = 2 (3 tries), close app
            // Se o counter = 2 (3 tentativas), fecha o aplicativo
        } else if (counter == 2) {

            // New intent for starting Lock Screen activity
            // Novo Intent para chamar a activity de bloqueio de tela
            Intent intent = new Intent(this, LockScreenActivity.class);

            // Instantiates an object for the lock screen class
            // Instancia um objeto da classe de bloqueio de tela
            startActivity(intent);

            // If user and/or password incorrect:
            // Se o usuário e senha estiverem incorretos:
        } else {

            // Increase count
            // Aumenta o counter em 1
            counter += 1;

            // Shows a notification about wrong user and/or password. Shows number of attempts left.
            // Mostra uma notificação a sobre usuário e/ou senha incorretos. Mostra o número de tentativas restantes.
            String message = getString(R.string.dados_incorretos, (3 - counter));
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        }

    }

}
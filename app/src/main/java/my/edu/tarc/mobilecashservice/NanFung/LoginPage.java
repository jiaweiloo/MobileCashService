package my.edu.tarc.mobilecashservice.NanFung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import my.edu.tarc.mobilecashservice.HomePage;
import my.edu.tarc.mobilecashservice.R;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

    }

    public void BtnLogin(View view) {
        EditText username = (EditText)findViewById(R.id.editTextUserName);
        String usernamestr = username.getText().toString();
        EditText password = (EditText)findViewById(R.id.editTextPassword);
        String passwordstr = password.getText().toString();

        /*
        String pass = databaseSource.searchPass(usernamestr);
        if(passwordstr.equals(pass)){
            Toast temp = Toast.makeText(LoginPage.this , "Login Successfully", Toast.LENGTH_SHORT);
            temp.show();
            Intent intentLogin = new Intent(this, HomePage.class);
            startActivityForResult(intentLogin, 1);
        }else{
            Toast temp = Toast.makeText(LoginPage.this , "Username and Password dont match", Toast.LENGTH_SHORT);
            temp.show();
        }
        */
    }

    public void BtnToRegister(View view) {
        //Intent intentRegister = new Intent(this, AddRegisterAcc.class);
        //startActivityForResult(intentRegister,1);
    }
}

package com.robby.lesson04_android_intent;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.txtEmail)
    EditText txtEmail;
    @BindView(R.id.txtPassword)
    EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSignIn)
    public void actionSignIn() {
        if (TextUtils.isEmpty(txtEmail.getText().toString().trim()) ||
                TextUtils.isEmpty(txtPassword.getText().toString().trim())) {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
            alertBuilder.setTitle(this.getResources().getString(R.string.error_title));
            alertBuilder.setMessage(this.getResources().getString(R.string.error_message));
            alertBuilder.setPositiveButton(this.getResources().getString(R.string.alert_close_message),
                    null);
            alertBuilder.show();
        } else {
            UserTask userTask = new UserTask(this);
            String email = txtEmail.getText().toString();
            String password = txtPassword.getText().toString();
            userTask.execute(email, password);
        }
    }

    public void loginShowStatus(boolean loginValid) {
        if (loginValid) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            this.startActivity(intent);
            this.finish();
        } else {
            Toast.makeText(this, "Login attempt unsuccessful", Toast.LENGTH_SHORT).show();
        }
    }
}

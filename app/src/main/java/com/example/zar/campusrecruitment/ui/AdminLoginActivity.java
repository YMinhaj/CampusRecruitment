package com.example.zar.campusrecruitment.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zar.campusrecruitment.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AdminLoginActivity extends AppCompatActivity {

    EditText adEmail,adPass;
    String email,pass;
    ProgressDialog mAuthProgressDialog;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        intComponent();
    }
    public void intComponent()
    {
        adEmail= (EditText) findViewById(R.id.admin_edit_email);
        adPass= (EditText) findViewById(R.id.admin_edit_pass);
        mFirebaseAuth=FirebaseAuth.getInstance();
        mAuthProgressDialog = new ProgressDialog(this);
        mAuthProgressDialog.setTitle(getResources().getString(R.string.progress_dialog_loading));
        mAuthProgressDialog.setMessage(getResources().getString(R.string.progress_dialog_creating_user_with_firebase));
        mAuthProgressDialog.setCancelable(false);
    }

    public void login(View view)
    {
        email=adEmail.getText().toString();
        pass=adPass.getText().toString();

        boolean validEmail=isEmailValid(email);
        boolean validPass=isPasswordValid(pass);

        if (!validEmail && !validPass)return;

        mAuthProgressDialog.show();

        mFirebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful())
                {
                    mAuthProgressDialog.dismiss();
                    Intent i=new Intent(AdminLoginActivity.this,AdminActivity.class);
                    startActivity(i);
                }
                else {

                    mAuthProgressDialog.dismiss();
                    makeToast("Invalid data");
                }
            }
        });


    }

    public void makeToast(String message)
    {
        Toast.makeText(AdminLoginActivity.this,message,Toast.LENGTH_SHORT).show();
    }
    private boolean isEmailValid(String email) {

        boolean isGoodEmail=(email!=null && Patterns.EMAIL_ADDRESS.matcher(email).matches());
        if (!isGoodEmail)
        {
            adEmail.setError(String.format(getString(R.string.error_invalid_email_not_valid),email));
            return false;
        }

        return isGoodEmail;
    }



    private boolean isPasswordValid(String password) {

        if (password.length()<6){
            adPass.setError(getResources().getString(R.string.error_invalid_password_not_valid));
            return false;
        }
        return true;
    }

}

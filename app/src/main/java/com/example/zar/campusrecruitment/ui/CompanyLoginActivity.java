package com.example.zar.campusrecruitment.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zar.campusrecruitment.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CompanyLoginActivity extends AppCompatActivity {

    TextView signup;
    EditText compEmail,compPass;
    String email,pass;
    FirebaseAuth mAuth;
    ProgressDialog mAuthProgressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_login);
        intiComponent();
        setClickListner();
    }
    public  void intiComponent()
    {
        signup= (TextView) findViewById(R.id.comp_txt_signup);
        compEmail= (EditText) findViewById(R.id.comp_edit_email);
        compPass= (EditText) findViewById(R.id.comp_edit_pass);
        mAuth=FirebaseAuth.getInstance();
        mAuthProgressDialog = new ProgressDialog(this);
        mAuthProgressDialog.setTitle(getResources().getString(R.string.progress_dialog_loading));
        mAuthProgressDialog.setMessage(getResources().getString(R.string.progress_dialog_creating_user_with_firebase));
        mAuthProgressDialog.setCancelable(false);

    }
    public void setClickListner()
    {
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CompanyLoginActivity.this,CompanySignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    public void login(View view)
    {
        email=compEmail.getText().toString();
        email="c"+email;
        pass=compPass.getText().toString();

        boolean validEmail=isEmailValid(email);
        boolean validPass=isPasswordValid(pass);

        if (!validEmail && !validPass)return;
        mAuthProgressDialog.show();
        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    mAuthProgressDialog.dismiss();
                    Intent i=new Intent(CompanyLoginActivity.this,StudentInUniActivity.class);
                    startActivity(i);
                }
                else {
                    mAuthProgressDialog.dismiss();
                    makeToast("Invalid Company");
                }
            }
        });


    }

    public void makeToast(String message)
    {
        Toast.makeText(CompanyLoginActivity.this,message,Toast.LENGTH_SHORT).show();
    }
    private boolean isEmailValid(String email) {

        boolean isGoodEmail=(email!=null && Patterns.EMAIL_ADDRESS.matcher(email).matches());
        if (!isGoodEmail)
        {
            compEmail.setError(String.format(getString(R.string.error_invalid_email_not_valid),email));
            return false;
        }

        return isGoodEmail;
    }



    private boolean isPasswordValid(String password) {

        if (password.length()<6){
            compPass.setError(getResources().getString(R.string.error_invalid_password_not_valid));
            return false;
        }
        return true;
    }
}

package com.example.zar.campusrecruitment.ui;

import android.app.ProgressDialog;
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

public class CompanySignUpActivity extends AppCompatActivity {
    EditText compName,compEmail,compPass;
    String name,email,pass;
    FirebaseAuth mFirebaseAuth;
    ProgressDialog mAuthProgressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_sign_up);
        intiComp();
    }

    public void intiComp()
    {
        compName= (EditText) findViewById(R.id.comp_signup_edit_name);
        compEmail= (EditText) findViewById(R.id.comp_signup_edit_email);
        compPass= (EditText) findViewById(R.id.comp_signup_edit_pass);
        mFirebaseAuth=FirebaseAuth.getInstance();

        mAuthProgressDialog = new ProgressDialog(this);
        mAuthProgressDialog.setTitle(getResources().getString(R.string.progress_dialog_loading));
        mAuthProgressDialog.setMessage(getResources().getString(R.string.progress_dialog_creating_user_with_firebase));
        mAuthProgressDialog.setCancelable(false);

    }

    public void createCompany(View view)
    {
        name=compName.getText().toString();
        email=compEmail.getText().toString();
        email="c"+email;
        pass=compPass.getText().toString();

        boolean validEmail=isEmailValid(email);
        boolean validName=isUserNameValid(name);
        boolean validPass=isPasswordValid(pass);

        if (!validEmail && !validName && !validPass)return;
        mAuthProgressDialog.show();
        mFirebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    mAuthProgressDialog.dismiss();
                    makeToast("Company added");
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
        Toast.makeText(CompanySignUpActivity.this,message,Toast.LENGTH_SHORT).show();
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

    private boolean isUserNameValid(String userName) {
        if (userName.equals(""))
        {
            compName.setError(getResources().getString(R.string.error_cannot_be_empty));
            return false;
        }
        return true;
    }

    private boolean isPasswordValid(String password) {

        if (password.length()<6){
            compPass.setError(getResources().getString(R.string.error_invalid_password_not_valid));
            return false;
        }
        return true;
    }

}

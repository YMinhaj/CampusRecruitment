package com.example.zar.campusrecruitment.ui;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.zar.campusrecruitment.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class StudentSignUpActivity extends AppCompatActivity {
EditText stdEmail,stdPass,stdName;
    Button stdSignup;
    FirebaseAuth mfirebaseAuth;
    ProgressDialog mAuthProgressDialog;
    String email,pass,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sign_up);
        intiComponent();

    }


    public void intiComponent()
    {
        stdEmail= (EditText) findViewById(R.id.std_signup_edit_email);
        stdName= (EditText) findViewById(R.id.std_signup_edit_name);
        stdPass= (EditText) findViewById(R.id.std_signup_edit_pass);
        stdSignup= (Button) findViewById(R.id.std_signup_btn_signup);
        mfirebaseAuth=FirebaseAuth.getInstance();

        mAuthProgressDialog = new ProgressDialog(this);
        mAuthProgressDialog.setTitle(getResources().getString(R.string.progress_dialog_loading));
        mAuthProgressDialog.setMessage(getResources().getString(R.string.progress_dialog_creating_user_with_firebase));
        mAuthProgressDialog.setCancelable(false);
    }
    public void createUser(View view)
    {
        name=stdName.getText().toString();
        pass=stdPass.getText().toString();
        email=stdEmail.getText().toString();
        email="s"+email;

        boolean validName=isUserNameValid(name);
        boolean validEmail=isEmailValid(email);
        boolean validPass=isPasswordValid(pass);

        if (!validEmail && !validName && !validPass)return;
        mAuthProgressDialog.show();
        mfirebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(StudentSignUpActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    mAuthProgressDialog.dismiss();
                    makeToast("User Created");
                }
                else if (!task.isSuccessful()){
                    mAuthProgressDialog.dismiss();
                    makeToast("invalid data");
                }
            }

        });


    }


    public void makeToast(String message)
    {
        Toast.makeText(StudentSignUpActivity.this,message,Toast.LENGTH_SHORT).show();
    }
    private boolean isEmailValid(String email) {

        boolean isGoodEmail=(email!=null && Patterns.EMAIL_ADDRESS.matcher(email).matches());
        if (!isGoodEmail)
        {
            stdEmail.setError(String.format(getString(R.string.error_invalid_email_not_valid),email));
            return false;
        }

        return isGoodEmail;
    }

    private boolean isUserNameValid(String userName) {
        if (userName.equals(""))
        {
            stdName.setError(getResources().getString(R.string.error_cannot_be_empty));
            return false;
        }
        return true;
    }

    private boolean isPasswordValid(String password) {

        if (password.length()<6){
            stdPass.setError(getResources().getString(R.string.error_invalid_password_not_valid));
            return false;
        }
        return true;
    }

}

package fpoply.thanhdvph33594.asm_ph33594;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Activity extends AppCompatActivity {
    private EditText edtEmail,edtPass;
    private Button btnLogin;
    private TextView txtRegister;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth =FirebaseAuth.getInstance();
        edtEmail=findViewById(R.id.edtUserName);
        edtPass=findViewById(R.id.edtPassword);
        btnLogin=findViewById(R.id.btnLogin);
        txtRegister=findViewById(R.id.txtSignUp);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerSignUp();
            }
        });
    }

    private void  registerSignUp() {
        Intent intent = new Intent(Login_Activity.this, Register_Activity.class);
        startActivity(intent);
    }

    private void login() {
        String email,pass;
        email=edtEmail.getText().toString();
        pass=edtPass.getText().toString();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Vui lòng nhập Email",Toast.LENGTH_SHORT).show();
                return;
        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this,"Vui lòng nhập Pass",Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(Login_Activity.this, MainActivity.class);
                    startActivity(intent1);
                }else{
                    Toast.makeText(getApplicationContext(),"Đăng nhập không thành công",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
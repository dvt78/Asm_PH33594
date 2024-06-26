package fpoply.thanhdvph33594.asm_ph33594;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register_Activity extends AppCompatActivity {
    private EditText edtName,edtPass1,edtPass2;
    private Button btnRegister;
    private ImageView imgAvartar;
    private FirebaseAuth mAuth;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth=FirebaseAuth.getInstance();
        edtName=findViewById(R.id.edtUsernameRegis);
        edtPass1=findViewById(R.id.edtPasswordRegis);
        edtPass2=findViewById(R.id.edtRetypePasswordRegis);
        btnRegister=findViewById(R.id.btnRegis);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }
    private void register() {
        String email,pass;
        email=edtName.getText().toString();
        pass=edtPass2.getText().toString();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Vui lòng nhập Name",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this,"Vui lòng nhập Pass",Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Đăng ký thành công",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register_Activity.this, MainActivity.class);
                    startActivity(intent);
                }else if(pass.length() <= 6){
                    Toast.makeText(getApplicationContext(),"Mật khẩu phải có ít nhất 6 ký tự ",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Tạo tài khoản không thành công",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
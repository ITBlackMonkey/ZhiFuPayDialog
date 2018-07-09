package com.lmj.myinputpwdview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.lmj.mypwdinputlibrary.InputPwdView;
import com.lmj.mypwdinputlibrary.MyInputPwdUtil;

public class MainActivity extends AppCompatActivity {

    private MyInputPwdUtil myInputPwdUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myInputPwdUtil = new MyInputPwdUtil(this);
        myInputPwdUtil.getMyInputDialogBuilder().setAnimStyle(R.style.dialog_anim);
        myInputPwdUtil.setListener(new InputPwdView.InputPwdListener() {
            @Override
            public void hide() {
                myInputPwdUtil.hide();
            }

            @Override
            public void forgetPwd() {
                Toast.makeText(MainActivity.this, "忘记密码", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void finishPwd(String pwd) {
                Toast.makeText(MainActivity.this, pwd, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void show(View view){
        myInputPwdUtil.show();
    }
}

package com.example.mloong.yidonghulian.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.BatteryManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mloong.yidonghulian.R;
import com.example.mloong.yidonghulian.common.Share;
import com.example.mloong.yidonghulian.entity.MemberEntity;
import com.example.mloong.yidonghulian.http.ProgressDialogSubscriber;
import com.example.mloong.yidonghulian.presenter.MemberPresenter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.titleText)
    TextView titleText;
    @BindView(R.id.common_title)
    RelativeLayout commonTitle;
    @BindView(R.id.login_page_input_name)
    TextView loginPageInputName;
    @BindView(R.id.login_input_name)
    EditText loginInputName;
    @BindView(R.id.login_page_input_name_layout)
    RelativeLayout loginPageInputNameLayout;
    @BindView(R.id.login_divider_line0)
    View loginDividerLine0;
    @BindView(R.id.login_page_input_email)
    TextView loginPageInputEmail;
    @BindView(R.id.login_input_email)
    EditText loginInputEmail;
    @BindView(R.id.login_page_input_email_layout)
    RelativeLayout loginPageInputEmailLayout;
    @BindView(R.id.login_divider_line)
    View loginDividerLine;
    @BindView(R.id.login_page_input_password)
    TextView loginPageInputPassword;
    @BindView(R.id.login_input_password)
    EditText loginInputPassword;
    @BindView(R.id.login_page_input_password_layout)
    RelativeLayout loginPageInputPasswordLayout;
    @BindView(R.id.login_divider_line1)
    View loginDividerLine1;
    @BindView(R.id.login_page_input_repassword)
    TextView loginPageInputRepassword;
    @BindView(R.id.login_input_repassword)
    EditText loginInputRepassword;
    @BindView(R.id.login_page_input_repassword_layout)
    RelativeLayout loginPageInputRepasswordLayout;
    @BindView(R.id.login_divider_verification_line)
    View loginDividerVerificationLine;
    @BindView(R.id.login_editor_layout)
    RelativeLayout loginEditorLayout;
    @BindView(R.id.register_button)
    Button registerButton;
    @BindView(R.id.login_relative)
    RelativeLayout loginRelative;
    @BindView(R.id.login_scroller)
    ScrollView loginScroller;
    @BindView(R.id.login_layout)
    RelativeLayout loginLayout;

    private Integer status = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    //验证用户名
    private void checkUsername(String username) {
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(RegisterActivity.this, "用户名不能为空！", Toast.LENGTH_SHORT).show();
            status = 1;
            return;
        }

        if (username.length() < 4 || username.length() > 20) {
            Toast.makeText(RegisterActivity.this, "用户名的长度为4-20个字符！", Toast.LENGTH_SHORT).show();
            status = 1;
            return;
        }

        if (username.contains("@")) {
            Toast.makeText(RegisterActivity.this, "用户名中不能包含@等特殊字符！", Toast.LENGTH_SHORT).show();
            status = 1;
            return;
        }
    }

    //验证邮箱
    private void checkEmail(String email) {
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(RegisterActivity.this, "邮箱不能为空！", Toast.LENGTH_SHORT).show();
            status = 1;
            return;
        }
        Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher m = p.matcher(email);
        if (!m.matches()) {
            Toast.makeText(RegisterActivity.this, "邮箱格式不正确！", Toast.LENGTH_SHORT).show();
            status = 1;
            return;
        }
    }

    //验证密码
    private void checkPWD(String password, String rePassword) {
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(RegisterActivity.this, "密码不能为空！", Toast.LENGTH_SHORT).show();
            status = 1;
            return;
        }

        if (!password.equals(rePassword)) {
            Toast.makeText(RegisterActivity.this, "两次输入密码不一致！", Toast.LENGTH_SHORT).show();
            status = 1;
            return;
        }
    }

    @OnClick({R.id.title_back, R.id.register_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.register_button:
                register();
                break;
        }
    }

    private void register() {
        String username = loginInputName.getText().toString().trim();
        String email = loginInputEmail.getText().toString().trim();
        String password = loginInputPassword.getText().toString().trim();
        String rePassword = loginInputRepassword.getText().toString().trim();

//        username = "123123";
//        email = "2060344029@qq.com";
//        password = "123";
//        rePassword = "123";
        MemberEntity member = new MemberEntity();
        member.setPassword(password);
        member.setEmail(email);
        member.setImage("https://08imgmini.eastday.com/mobile/20181102/20181102_d68715b849aacb216e11378a3dca477b_wmk.jpeg");
        member.setSex(Integer.valueOf(Share.MALE));
        member.setUname(username);


        checkUsername(username);
        if (status != 0) {
            return;
        }
        checkEmail(email);
        if (status != 0) {
            return;
        }
        checkPWD(password, rePassword);
        if (status != 0) {
            return;
        }

//        regist(username, password, email);
//        registAdd(getMember());
        registAdd(member);

    }

    public MemberEntity getMember() {
        MemberEntity member = new MemberEntity();
        member.setPassword("password");
        member.setEmail("20603441@qq.com");
        member.setImage("https://08imgmini.eastday.com/mobile/20181102/20181102_d68715b849aacb216e11378a3dca477b_wmk.jpeg");
        member.setSex(Integer.valueOf(Share.MALE));
        member.setUname("chen1");
        return member;
    }

    private void registAdd(MemberEntity memberEntity) {
        MemberPresenter.registerAdd(new ProgressDialogSubscriber<MemberEntity>(this) {
            @Override
            public void onNext(MemberEntity memberEntity) {
                Toast.makeText(RegisterActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor localEditor = getSharedPreferences("user", 0).edit();
                localEditor.putInt("member_id", memberEntity.getMemberId()); //用户id
                localEditor.putString("uname", memberEntity.getUname());//用户名
                localEditor.putString("email", memberEntity.getEmail());//用户邮箱
                localEditor.putString("image", memberEntity.getImage());//用户头像
                localEditor.commit();

                //返回到之前的页面并回传数据
                Intent returnIntent = new Intent();
                returnIntent.putExtra("logined", true);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        }, memberEntity);
    }

    private void regist(String username, String password, String email) {
        MemberPresenter.register(new ProgressDialogSubscriber<MemberEntity>(this) {
            @Override
            public void onNext(MemberEntity memberEntity) {
                Toast.makeText(RegisterActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor localEditor = getSharedPreferences("user", 0).edit();
                localEditor.putInt("member_id", memberEntity.getMemberId()); //用户id
                localEditor.putString("uname", memberEntity.getUname());//用户名
                localEditor.putString("email", memberEntity.getEmail());//用户邮箱
                localEditor.putString("image", memberEntity.getImage());//用户头像
                localEditor.commit();

                //返回到之前的页面并回传数据
                Intent returnIntent = new Intent();
                returnIntent.putExtra("logined", true);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        }, username, password, email);
    }

    public class BatteryChangedReceiver extends BroadcastReceiver {

        private static final String TAG = "BatteryChangedReceiver";

        @Override
        public void onReceive(Context context, Intent intent) {
            int currentLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);  //当前电量
            int totalLevel = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 1);      //总电量
            int percent = currentLevel * 100 / totalLevel;
            Log.i(TAG, "battery: " + percent + "%");
        }

    }
}

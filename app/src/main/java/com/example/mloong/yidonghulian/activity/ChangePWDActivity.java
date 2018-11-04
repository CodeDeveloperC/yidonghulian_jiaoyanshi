package com.example.mloong.yidonghulian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.example.mloong.yidonghulian.entity.HttpResult;
import com.example.mloong.yidonghulian.entity.MemberEntity;
import com.example.mloong.yidonghulian.http.ProgressDialogSubscriber;
import com.example.mloong.yidonghulian.presenter.MemberPresenter;
import com.example.mloong.yidonghulian.presenter.MemberPresenter2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangePWDActivity extends BaseActivity {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.titleText)
    TextView titleText;
    @BindView(R.id.common_title)
    RelativeLayout commonTitle;
    @BindView(R.id.login_page_input_name)
    TextView loginPageInputName;
    @BindView(R.id.password_input_oldpass)
    EditText passwordInputOldpass;
    @BindView(R.id.login_page_input_name_layout)
    RelativeLayout loginPageInputNameLayout;
    @BindView(R.id.login_divider_line)
    View loginDividerLine;
    @BindView(R.id.login_page_input_password)
    TextView loginPageInputPassword;
    @BindView(R.id.password_input_newpass)
    EditText passwordInputNewpass;
    @BindView(R.id.login_page_input_password_layout)
    RelativeLayout loginPageInputPasswordLayout;
    @BindView(R.id.login_divider_line1)
    View loginDividerLine1;
    @BindView(R.id.login_page_input_repassword)
    TextView loginPageInputRepassword;
    @BindView(R.id.password_input_repass)
    EditText passwordInputRepass;
    @BindView(R.id.login_page_input_repassword_layout)
    RelativeLayout loginPageInputRepasswordLayout;
    @BindView(R.id.login_divider_verification_line)
    View loginDividerVerificationLine;
    @BindView(R.id.login_editor_layout)
    RelativeLayout loginEditorLayout;
    @BindView(R.id.change_button)
    Button changeButton;
    @BindView(R.id.login_relative)
    RelativeLayout loginRelative;
    @BindView(R.id.login_scroller)
    ScrollView loginScroller;
    @BindView(R.id.login_layout)
    RelativeLayout loginLayout;
    @BindView(R.id.login_page_input_name2)
    TextView loginPageInputName2;
    @BindView(R.id.password_input_email)
    EditText passwordInputEmail;
    @BindView(R.id.login_page_input_name_layout2)
    RelativeLayout loginPageInputNameLayout2;
    @BindView(R.id.login_divider_line2)
    View loginDividerLine2;

    private Integer flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pwd);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.title_back, R.id.change_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.change_button:
//                Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
                changePassword();
                break;
        }
    }

    private void changePassword() {
        String email = passwordInputEmail.getText().toString().trim();
        String old_password = passwordInputOldpass.getText().toString().trim();
        String new_password = passwordInputNewpass.getText().toString().trim();
        String new_rePassword = passwordInputRepass.getText().toString().trim();

        checkPassword(old_password, new_password, new_rePassword);
        if (flag != 0) {
            return;
        }

        Integer member_id = getSharedPreferences("user", 0).getInt("member_id", 0);
        if (TextUtils.isEmpty(member_id.toString())) {
            Toast.makeText(this, "取出本地用户id失败，请重新登录！", Toast.LENGTH_SHORT).show();
            return;
        }

//        email = "20603441@qq.com";
//        old_password = "1234";
//        new_password = "1234";
        change(email, old_password, new_password);

        //修改密码
//        MemberPresenter.updateById(new ProgressDialogSubscriber<MemberEntity>(this) {
//            @Override
//            public void onNext(MemberEntity memberEntity) {
//
//                Toast.makeText(ChangePWDActivity.this, "修改密码成功,请您重新登录！", Toast.LENGTH_SHORT).show();
//                Share.logout(ChangePWDActivity.this);
//                //返回到PersonFragment页面重新登录
//                Intent returnIntent = new Intent();
//                returnIntent.putExtra("changepass", true);
//                setResult(RESULT_OK, returnIntent);
//                finish();
//
//            }
//        }, member_id, old_password, new_password);
    }

    private void change(String email, String password, String new_password) {
        //联网请求
        MemberPresenter.findEmailPwd(new ProgressDialogSubscriber<MemberEntity>(this) {
            @Override
            public void onNext(MemberEntity memberEntity) {

//                startActivity(new Intent(ChangePWDActivity.this,ChangePWDActivity.class));
//                //退出历史登录
//                Share.logout(FindPWDActivity.this);
//
//                Toast.makeText(FindPWDActivity.this, "操作成功，请登录注册邮箱使用新的密码进行登录", Toast.LENGTH_LONG).show();
//                //重新登录
//                startActivity(new Intent(FindPWDActivity.this, LoginActivity.class));

                memberEntity.setPassword(new_password);


                changePassword2(memberEntity);

                finish();
            }
        }, email, password);
    }

    private void changePassword2(MemberEntity memberEntity) {
        MemberPresenter2.updateById2(new ProgressDialogSubscriber<HttpResult<MemberEntity>>(ChangePWDActivity.this) {
            @Override
            public void onNext(HttpResult<MemberEntity> httpResult) {
                if (httpResult.getStatus().equals(Share.SUCCESS)) {
                    Toast.makeText(ChangePWDActivity.this, "修改密码成功,请您重新登录！", Toast.LENGTH_SHORT).show();
                    Share.logout(ChangePWDActivity.this);
                    //返回到PersonFragment页面重新登录
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("changepass", true);
                    setResult(RESULT_OK, returnIntent);
                    finish();
                }

            }
        }, memberEntity);
    }


    private void changePassword(MemberEntity memberEntity) {
        MemberPresenter.updateById(new ProgressDialogSubscriber<MemberEntity>(ChangePWDActivity.this) {
            @Override
            public void onNext(MemberEntity memberEntity) {
                Toast.makeText(ChangePWDActivity.this, "修改密码成功,请您重新登录！", Toast.LENGTH_SHORT).show();
                Share.logout(ChangePWDActivity.this);
                //返回到PersonFragment页面重新登录
                Intent returnIntent = new Intent();
                returnIntent.putExtra("changepass", true);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        }, memberEntity);
    }

    private void checkPassword(String old_password, String new_password, String new_rePassword) {
        if (TextUtils.isEmpty(old_password) || TextUtils.isEmpty(new_password) || TextUtils.isEmpty(new_rePassword)) {
            Toast.makeText(this, "密码不能为空！", Toast.LENGTH_SHORT).show();
            flag = 1;
            return;
        }
        if (!new_password.equals(new_rePassword)) {
            Toast.makeText(this, "两次输入的新密码不一致！", Toast.LENGTH_SHORT).show();
            flag = 1;
            return;
        }
    }
}

package com.example.mloong.yidonghulian.http;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2016/10/12.
 */

public  class ProgressDialogSubscriber<T> implements Observer<T> {
    private Context mContext;
    private ProgressDialog mDialog;
    public ProgressDialogSubscriber(Context context) {
        this.mContext = context;
    }

//    @Override
//    public void onCompleted() {
//        dismissProgressDialog();
//    }
//
//    @Override
//    public void onError(Throwable e) {
//        if (e instanceof SocketTimeoutException) {
//            Toast.makeText(mContext, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
//        } else if (e instanceof ConnectException) {
//            Toast.makeText(mContext, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(mContext, "error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
//            System.out.print("error:" + e.getMessage());
//        }
//        dismissProgressDialog();
//    }
//
//    @Override
//    public void onStart() {
//        showProgressDialog();
//    }

    private void showProgressDialog() {
        if (mDialog == null) {
            mDialog = new ProgressDialog(mContext);
            mDialog.setCancelable(true);
            mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialogInterface) {
                    //取消订阅，取消请求
//                    ProgressDialogSubscriber.this
                    Exception exception = new Exception("您已经取消了");
                    try {
                        throw exception;
                    } catch (Exception e) {

                    }
                }
            });
        }
        if (mDialog != null && !mDialog.isShowing()) {
            mDialog.show();
        }
    }

    private void dismissProgressDialog() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
            mDialog = null;
        }
    }

    @Override
    public void onSubscribe(Disposable d) {
        showProgressDialog();
    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof SocketTimeoutException) {
            Toast.makeText(mContext, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
        } else if (e instanceof ConnectException) {
            Toast.makeText(mContext, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext, "error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
            System.out.print("error:" + e.getMessage());
        }
        dismissProgressDialog();
    }

    @Override
    public void onComplete() {
        dismissProgressDialog();
    }
}

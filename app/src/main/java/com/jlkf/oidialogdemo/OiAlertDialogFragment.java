package com.jlkf.oidialogdemo;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.TypedValue;
import android.view.WindowManager;

import static android.util.TypedValue.COMPLEX_UNIT_DIP;

/**
 * Created by oi on 2018/2/10 email:630869889@qq.com
 */
public class OiAlertDialogFragment extends DialogFragment {

    public static OiAlertDialogFragment newInstance() {
        return new OiAlertDialogFragment();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity()).setTitle("这是标题").setMessage("这个简介")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dismiss();
                        Snackbar.make(getActivity().findViewById(android.R.id.content), "确定点击", Snackbar.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("取消", null).create();
    }


    @Override
    public void onResume() {
        super.onResume();
        //设置window的宽高
        getDialog().getWindow().setLayout(dp2px(getContext(), 300), WindowManager.LayoutParams.WRAP_CONTENT);
    }

    public static int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(COMPLEX_UNIT_DIP, dpVal,context.getResources().getDisplayMetrics());
    }
}

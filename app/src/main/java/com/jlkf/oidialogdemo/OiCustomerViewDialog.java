package com.jlkf.oidialogdemo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import static android.util.TypedValue.COMPLEX_UNIT_DIP;

/**
 * Created by oi on 2018/2/10 email:630869889@qq.com
 */
public class OiCustomerViewDialog extends DialogFragment {

    public static OiCustomerViewDialog newInstance() {
        return new OiCustomerViewDialog();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View customView = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_oi_customer_view, (ViewGroup) getActivity().findViewById(android.R.id.content), false);
        TextView mBtnSure = customView.findViewById(R.id.ok);
        TextView mBtnCancel = customView.findViewById(R.id.cancel);

        mBtnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return new AlertDialog.Builder(getActivity()).setView(customView).create();
    }

    /************************************设置弹窗的宽高***********************************************/
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

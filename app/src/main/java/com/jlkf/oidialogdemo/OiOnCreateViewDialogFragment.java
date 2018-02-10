package com.jlkf.oidialogdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import static android.util.TypedValue.COMPLEX_UNIT_DIP;

/**
 * Created by oi on 2018/2/10 email:630869889@qq.com
 */
public class OiOnCreateViewDialogFragment extends DialogFragment {

    public static OiOnCreateViewDialogFragment newInstance() {
        return new OiOnCreateViewDialogFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //去掉fragment的标题
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        //View
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
        return customView;
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

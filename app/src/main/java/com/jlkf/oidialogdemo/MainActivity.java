package com.jlkf.oidialogdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 系统的确定取消弹窗
     */
    public void systemOkCancelPop(View view) {
        showDialogFragment(OiAlertDialogFragment.newInstance(), "OiAlertDialogFragment");
    }

    /**
     * AlertDialog 自定义View弹窗
     */
    public void alertDialogCustomerClick(View view) {
        showDialogFragment(OiCustomerViewDialog.newInstance(), "OiCustomerViewDialog");
    }

    /**
     * DialogFragment 自定义View弹窗
     */
    public void customerViewClick(View view) {
        showDialogFragment(OiOnCreateViewDialogFragment.newInstance(), "OiOnCreateViewDialogFragment");
    }

    /**
     * 底部弹窗
     */
    public void bottomClick(View view) {
        showDialogFragment(OiBottomShowDialogFragment.newInstance(), "OiBottomShowDialogFragment");
    }

    /**
     * 显示弹窗
     */
    public void showDialogFragment(DialogFragment dialogFragment, String tag){
        Fragment fragment = getFragmentManager().findFragmentByTag(tag);
        if (fragment != null){
            //为了不重复显示dialog，在显示对话框之前移除正在显示的对话框
            getFragmentManager().beginTransaction().remove(fragment);
        }
        //显示一个Fragment并且给该Fragment添加一个Tag，可通过findFragmentByTag找到该Fragment
        dialogFragment.show(getSupportFragmentManager(),tag);
    }



}

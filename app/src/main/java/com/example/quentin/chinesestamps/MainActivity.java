package com.example.quentin.chinesestamps;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txt_channel;
    private TextView txt_message;
    private TextView txt_better;
    private TextView txt_setting;
    private FrameLayout ly_content;

    private MyFragment fg1, fg2, fg3, fg4;
    private FragmentManager fManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fManager = getFragmentManager();
        bindViews();
        txt_channel.performClick();
    }

    private void bindViews() {
        txt_channel = findViewById(R.id.txt_channel);
        txt_better = findViewById(R.id.txt_better);
        txt_message = findViewById(R.id.txt_message);
        txt_setting = findViewById(R.id.txt_setting);
        ly_content = findViewById(R.id.ly_content);

        txt_setting.setOnClickListener(this);
        txt_channel.setOnClickListener(this);
        txt_message.setOnClickListener(this);
        txt_better.setOnClickListener(this);
    }

    private void resetSelected() {
        txt_better.setSelected(false);
        txt_channel.setSelected(false);
        txt_message.setSelected(false);
        txt_setting.setSelected(false);
    }

    private void hideAllFragments(FragmentTransaction fragmentTransaction) {
        if(fg1 != null)fragmentTransaction.hide(fg1);
        if(fg2 != null)fragmentTransaction.hide(fg2);
        if(fg3 != null)fragmentTransaction.hide(fg3);
        if(fg4 != null)fragmentTransaction.hide(fg4);

    }


    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = fManager.beginTransaction();
        hideAllFragments(fragmentTransaction);
        switch (v.getId()) {
            case R.id.txt_channel:
                resetSelected();
                txt_channel.setSelected(true);
                if (fg1 == null) {
                    fg1 = new MyFragment("first");
                    fragmentTransaction.add(R.id.ly_content, fg1);
                } else {
                    fragmentTransaction.show(fg1);
                }
                break;
                case R.id.txt_message:
                resetSelected();
                txt_message.setSelected(true);
                if (fg2 == null) {
                    fg2 = new MyFragment("second");
                    fragmentTransaction.add(R.id.ly_content, fg2);
                } else {
                    fragmentTransaction.show(fg2);
                }
                break;
                case R.id.txt_better:
                resetSelected();
                txt_better.setSelected(true);
                if (fg3 == null) {
                    fg3 = new MyFragment("third");
                    fragmentTransaction.add(R.id.ly_content, fg3);
                } else {
                    fragmentTransaction.show(fg3);
                }
                break;
                case R.id.txt_setting:
                resetSelected();
                txt_setting.setSelected(true);
                if (fg4 == null) {
                    fg4 = new MyFragment("forth");
                    fragmentTransaction.add(R.id.ly_content, fg4);
                } else {
                    fragmentTransaction.show(fg4);
                }
                break;

        }
        fragmentTransaction.commit();
    }
}

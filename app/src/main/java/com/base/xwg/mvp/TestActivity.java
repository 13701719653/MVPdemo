package com.base.xwg.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by xwg on 2018/9/28.
 */

public class TestActivity extends AppCompatActivity {
    @BindView(R.id.storeName)
    TextView storeName;
    @BindView(R.id.staffName)
    TextView staffName;
    @BindView(R.id.type)
    TextView type;
    @BindView(R.id.createTime)
    TextView createTime;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.description_content)
    TextView descriptionContent;
    @BindView(R.id.picture)
    TextView picture;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.reply)
    TextView reply;
    @BindView(R.id.replyRecyclerView)
    RecyclerView replyRecyclerView;
    @BindView(R.id.select_pic)
    ImageView selectPic;
    @BindView(R.id.replyEditText)
    EditText replyEditText;
    @BindView(R.id.replyBtn)
    Button replyBtn;
    @BindView(R.id.bottom_layout)
    LinearLayout bottomLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.select_pic, R.id.replyEditText, R.id.replyBtn, R.id.bottom_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.select_pic:
                break;
            case R.id.replyEditText:
                break;
            case R.id.replyBtn:
                break;
            case R.id.bottom_layout:
                break;
        }
    }
}

package com.robby.lesson04_android_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChildActivity extends AppCompatActivity {

    @BindView(R.id.txtName)
    EditText txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        ButterKnife.bind(this);

        if (getIntent().hasExtra(Intent.EXTRA_TEXT)) {
            txtName.setText(getIntent().getStringExtra(Intent.EXTRA_TEXT));
        }
    }
}

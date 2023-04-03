package com.example.modul6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout constraintLayout;
    RecyclerView recyclerView;
    EditText et_name, et_comment;
    Button btn, btn_submit;
    ArrayList<DiscussionModel> discussionList = new ArrayList<>();
    DiscussionAdapter discussionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        constraintLayout = findViewById(R.id.constraintLayout);
        et_name = findViewById(R.id.et_name);
        et_comment = findViewById(R.id.et_comment);
        btn = findViewById(R.id.btn_ad);
        btn_submit = findViewById(R.id.btn_submit);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        discussionAdapter = new DiscussionAdapter(this, discussionList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(discussionAdapter);

        discussionList.add(new DiscussionModel("Reyhan Hafiz Rusyard", "215150700111018"));

        discussionAdapter.setOnItemClickListener((position, v) -> {
            discussionList.remove(position);
            discussionAdapter = new DiscussionAdapter(this, discussionList);
            recyclerView.setAdapter(discussionAdapter);
        });

        btn.setOnClickListener(v -> {
            if (recyclerView.getVisibility() == View.VISIBLE) {
                recyclerView.setVisibility(View.GONE);
                constraintLayout.setVisibility(View.VISIBLE);
                et_name.setText("");
                et_comment.setText("");
            } else {
                constraintLayout.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
            }
        });

        btn_submit.setOnClickListener(v -> {
            if (et_name.getText().toString().equals("") || et_comment.getText().toString().equals("")){
                Toast.makeText(this, "Name or Comment can't be empty", Toast.LENGTH_SHORT).show();
            } else {
                discussionList.add(new DiscussionModel(et_name.getText().toString(), et_comment.getText().toString()));
                constraintLayout.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                recyclerView.setAdapter(discussionAdapter);
            }
        });
    }
}
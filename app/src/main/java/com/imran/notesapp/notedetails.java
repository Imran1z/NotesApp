package com.imran.notesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class notedetails extends AppCompatActivity {
    private TextView mtitleofnotedetails,mcontentofnotedetails;
    FloatingActionButton mgotoeditnotes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notedetails);

        mtitleofnotedetails=findViewById(R.id.titleofnotedetails);
        mcontentofnotedetails=findViewById(R.id.contentofnotedetails);
        mgotoeditnotes=findViewById(R.id.gotoeditnote);
      //  Toolbar toolbar=findViewById(R.id.toolbarofnotedetails);
       // setSupportActionBar(toolbar);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        Intent data=getIntent();

        mgotoeditnotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),editnoteactivity.class);
                intent.putExtra("title",data.getStringExtra("title"));
                intent.putExtra("content",data.getStringExtra("content"));
                intent.putExtra("noteId",data.getStringExtra("noteId"));
                v.getContext().startActivity(intent);


            }
        });

        mcontentofnotedetails.setText(data.getStringExtra("content"));
        mtitleofnotedetails.setText(data.getStringExtra("title"));
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
package com.example.maktaba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class FreeReads extends AppCompatActivity {
    private ListView mList;

    int[] mImages = {R.drawable.art1, R.drawable.art2, R.drawable.art3, R.drawable.art4};
    String[] mTitle = {"Book One", "Book Two", "Book Three", "Book Four"};
    String[] mDescription ={"Book one description", "Book two description", "Book three description", "Book four description"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_reads);
    }
}

package com.example.maktaba.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.maktaba.adapters.BookAdapter;
import com.example.maktaba.models.Book;
import com.example.maktaba.service.BookClient;
import com.example.maktaba.R;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.Header;
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.main_list) ListView mList;
    private BookAdapter mAdapter;
    private BookClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface raleway = Typeface.createFromAsset(getAssets(), "fonts/OpenSans-Light.ttf");

        fetchBooks();

        ArrayList<Book> aBooks = new ArrayList<Book>();
        mAdapter = new BookAdapter(this, aBooks);
        mList.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v){
//        if(v == mButton){
//            Intent intent = new Intent(MainActivity.this, Categories.class);
//            startActivity(intent);
//        }
    }

    private void fetchBooks() {
        client = new BookClient();
        client.getBooks("oscar Wilde", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray docs = null;
                    if(response != null) {
                        // Get the docs json array
                        docs = response.getJSONArray("docs");
                        // Parse json array into array of model objects
                        final ArrayList<Book> books = Book.fromJson(docs);
                        // Remove all books from the adapter
                        mAdapter.clear();
                        // Load model objects into the adapter
                        for (Book book : books) {
                            mAdapter.add(book); // add book through the adapter
                        }
                        mAdapter.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    // Invalid JSON format, show appropriate error.
                    e.printStackTrace();
                }
            }
        });
    }
}



package com.example.maktaba;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

        mList.findViewById(R.id.categoryListId);
    }

    public class CategoryAdapter extends ArrayAdapter<String>{
        Context context;
        int[] rImages;
        String[] rTitle;
        String[] rDescription;

        public CategoryAdapter(Context context, int[] images, String[] title, String[] description){
            super(context, R.layout.custom_categories, R.id.cat_txt, title);
            this.context= context;
            this.rImages= images;
            this.rTitle= title;
            this.rDescription= description;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return super.getView(position, convertView, parent);
        }
    }
}

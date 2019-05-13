package com.example.maktaba;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class FreeReads extends AppCompatActivity {
    ListView mList;

    int[] mImages = {R.drawable.art1, R.drawable.art2, R.drawable.art3, R.drawable.art4};
    String[] mTitle = {"Book One", "Book Two", "Book Three", "Book Four"};
    String[] mDescription ={"Book one description", "Book two description", "Book three description", "Book four description"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_reads);

        mList = findViewById(R.id.categoryListId);
        CategoryAdapter adapter = new CategoryAdapter(this, mImages, mTitle, mDescription);
        mList.setAdapter(adapter);
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
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View custom_categories = layoutInflater.inflate(R.layout.custom_categories, parent, false);

            ImageView images= custom_categories.findViewById(R.id.cat_image);
            TextView title = custom_categories.findViewById(R.id.cat_txt);
            TextView description = custom_categories.findViewById(R.id.cat_desc);

            images.setImageResource(rImages[position]);
            title.setText(rTitle[position]);
            description.setText(rDescription[position]);

            return custom_categories;
        }
    }
}

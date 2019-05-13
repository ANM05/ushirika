package com.example.maktaba;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class categories extends AppCompatActivity {

    @BindView(R.id.category_text)
    TextView mCategoryTextView;
    @BindView(R.id.listView)
    ListView mListView;

    private String[] categories = {"Art", "Fantasy", "Biographies", "Science", "Recipes", "Romance", "Religion", "Music", "History", "Science Fiction", "Textbooks"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        ButterKnife.bind(this);

        CategoryAdapter adapter = new CategoryAdapter(this, android.R.layout.simple_list_item_1, categories);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent intent = new Intent (categories.this, FreeReads.class);
                    startActivity(intent);
                }
                if(position == 1){
                    Intent intent = new Intent (categories.this, FreeReads.class);
                    startActivity(intent);
                }
                if(position == 2){
                    Intent intent = new Intent (categories.this, FreeReads.class);
                    startActivity(intent);
                }
                if(position == 3){
                    Intent intent = new Intent (categories.this, FreeReads.class);
                    startActivity(intent);
                }
                if(position == 4){
                    Intent intent = new Intent (categories.this, FreeReads.class);
                    startActivity(intent);
                }
                if(position == 5){
                    Intent intent = new Intent (categories.this, FreeReads.class);
                    startActivity(intent);
                }
                if(position == 6){
                    Intent intent = new Intent (categories.this, FreeReads.class);
                    startActivity(intent);
                }
                if(position == 7){
                    Intent intent = new Intent (categories.this, FreeReads.class);
                    startActivity(intent);
                }
            }
        });
    }

    public class CategoryAdapter extends ArrayAdapter{
        private Context mContext;
        private String[] mCategories;

        public CategoryAdapter(Context context, int resource, String[] categories) {
            super(context, resource);
            this.mContext= context;
            this.mCategories= categories;
        }

        @Override
        public Object getItem(int position){
            String category = mCategories[position];
            return String.format("%s", category);
        }

        @Override
        public int getCount(){
            return mCategories.length;
        }
    }
}

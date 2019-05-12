package com.example.maktaba;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

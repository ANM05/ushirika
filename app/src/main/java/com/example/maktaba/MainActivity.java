package com.example.maktaba;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private ListView mList;
    @BindView(R.id.button)
    Button mButton;

    int[] mImages = {R.drawable.trev,
                    R.drawable.wisdom,
                    R.drawable.ngugi,
                    R.drawable.sample_book};

    String[] mBooks= {"Born A Crime","Wisdom of Insecurity", "Decolonizing the Mind", "My Adventures As An Illustrator"};
    String[] mDescription = {"Born a crime description", "Wisdom of insecurity description", "Decolonizing the mind description", "My adventures as an illustrator description"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mList = findViewById(R.id.picks_list);
        MainAdapter mainAdapter = new MainAdapter(this, mBooks, mDescription, mImages);
        mList.setAdapter(mainAdapter);
    }

    @Override
    public void onClick(View v){
        if(v == mButton){

        }
    }

    class MainAdapter extends ArrayAdapter<String> {

        Context context;
        String[] rBooks;
        String[] rDescription;
        int[] rImages;

        MainAdapter (Context c, String[] books, String[] description, int[] images){
            super(c, R.layout.main_custom, R.id.img_txt, books);
            this.context= c;
            this.rBooks = books;
            this.rDescription= description;
            this.rImages= images;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View main_custom = layoutInflater.inflate(R.layout.main_custom, parent, false);

            ImageView imageView = main_custom.findViewById(R.id.sample_image);
            TextView books = main_custom.findViewById(R.id.img_txt);
            TextView desc = main_custom.findViewById(R.id.img_desc);

            imageView.setImageResource(rImages[position]);
            books.setText(rBooks[position]);
            desc.setText(rDescription[position]);

            return main_custom;
        }
    }
}



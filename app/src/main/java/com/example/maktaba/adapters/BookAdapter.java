package com.example.maktaba.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maktaba.R;
import com.example.maktaba.models.Book;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class BookAdapter extends ArrayAdapter<Book> {
    private static class ViewHolder {
        public ImageView ivCover;
        public TextView tvTitle;
        public TextView tvAuthor;
    }

    public BookAdapter(Context context, ArrayList<Book> aBooks) {
        super(context, 0, aBooks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Book book = getItem(position);

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.main_custom, parent, false);
            viewHolder.ivCover = (ImageView)convertView.findViewById(R.id.book_image);
            viewHolder.tvTitle = (TextView)convertView.findViewById(R.id.book_title);
            viewHolder.tvAuthor = (TextView)convertView.findViewById(R.id.book_author);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvTitle.setText(book.getTitle());
        viewHolder.tvAuthor.setText(book.getAuthor());
        Picasso.get().load(Uri.parse(book.getCoverUrl())).error(R.drawable.book_back).into(viewHolder.ivCover);

        return convertView;
    }
}

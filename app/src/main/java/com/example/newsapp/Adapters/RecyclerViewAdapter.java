package com.example.newsapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.Actvities.WebActivity;
import com.example.newsapp.R;
import com.example.newsapp.Utils.Model;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    public List<Model> newsList;
    public Context context;

    public RecyclerViewAdapter(List<Model> newsList, Context context){
        this.newsList = newsList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Model model = newsList.get(position);

        holder.titleTextView.setText(model.getTitle());
        holder.descriptionTextView.setText(model.getDescription());
        holder.authorTextView.setText(model.getAuthor());
        holder.publishedTextView.setText(model.getPublished());

        Glide.with(context).load(model.imageURL).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), WebActivity.class);
                intent.putExtra("url", model.getSourceURL());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView, descriptionTextView, authorTextView, publishedTextView;
        public ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.title_textView);
            descriptionTextView = itemView.findViewById(R.id.description_textView);
            authorTextView = itemView.findViewById(R.id.author_textView);
            publishedTextView = itemView.findViewById(R.id.published_textView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}

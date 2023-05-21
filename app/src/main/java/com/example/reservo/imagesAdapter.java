package com.example.reservo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class imagesAdapter extends RecyclerView.Adapter<imagesAdapter.imageViewholder> {

    Context context;
    ArrayList<onlineImages> imagesArrayList;

    public imagesAdapter(Context context, ArrayList<onlineImages> imagesArrayList) {
        this.context = context;
        this.imagesArrayList = imagesArrayList;
    }

    @NonNull
    @Override
    public imageViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_layout, parent, false);
        return new imageViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull imageViewholder holder, int position) {
        onlineImages onlineimag = imagesArrayList.get(position);

        String imgurl = onlineimag.getImage();
        Picasso.get().load(imgurl).into(holder.onlineImage);

        holder.onlineImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadImage(imgurl);
            }
        });
    }

    private void downloadImage(String imageUrl) {
        Uri imageUri = Uri.parse(imageUrl);
        Intent downloadIntent = new Intent(Intent.ACTION_VIEW, imageUri);
        downloadIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        if (downloadIntent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(downloadIntent);
        } else {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(imageUrl));
            browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(browserIntent);
        }
    }

    @Override
    public int getItemCount() {
        return imagesArrayList.size();
    }

    public class imageViewholder extends RecyclerView.ViewHolder {

        ImageView onlineImage;

        public imageViewholder(@NonNull View itemView) {
            super(itemView);
            onlineImage = itemView.findViewById(R.id.onlineimage);
        }
    }
}

package com.example.reservo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class PhotoGallery extends AppCompatActivity {

    RecyclerView recyclerView;
    imagesAdapter adapter;
    ArrayList<onlineImages> imagesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_gallery);
        recyclerView = findViewById(R.id.recyclerview);

        imagesArrayList = new ArrayList<>();
        String imageurl = "https://scontent.fceb3-1.fna.fbcdn.net/v/t39.30808-6/333256930_1576553629511215_4291937816604365484_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=8bfeb9&_nc_eui2=AeEV0zMbK7Xu-Gbgq5S51iZJVVX793pDnsdVVfv3ekOex_T7WjgylKDeVsIpMeZhi-t-E93okVVBEZYQ-x8WIncW&_nc_ohc=lJMbTtPgmQQAX_GXvl3&_nc_ht=scontent.fceb3-1.fna&oh=00_AfBw0p7e3imj3iUDado5kC2PMLn3qbQbpqBPJ3h0McJxng&oe=646E1706";
        String imageurl2 = "https://scontent.fceb3-1.fna.fbcdn.net/v/t39.30808-6/333126502_1236632870291767_234984433821570795_n.jpg?_nc_cat=106&ccb=1-7&_nc_sid=8bfeb9&_nc_eui2=AeG2UYRAYQ4_aeMLwFEuTqxa7KreMBdZEtTsqt4wF1kS1HL-i4eCQDJ2Bd4Unrki8wgshwmY4mlPBWiQkO89QQWP&_nc_ohc=xJ0vO7Mj4McAX_UCzu3&_nc_ht=scontent.fceb3-1.fna&oh=00_AfDZ8qu5a9mQcp-N5ozmAwTm7YiKBDntoT6G4JxYjVbkJQ&oe=646E8A3F";

        String imageurl3 = "https://scontent.fceb3-1.fna.fbcdn.net/v/t39.30808-6/333704996_1648408165611151_7012698488178131342_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=8bfeb9&_nc_eui2=AeHnPIuN9QeMw9zIagEP5fgM3ieOas7WS9LeJ45qztZL0gcQCbAYgQVIajuFijiaZjCOeR4CrA94fpf4zCKatQGo&_nc_ohc=KUBKFf5IPzAAX9YlrBT&_nc_ht=scontent.fceb3-1.fna&oh=00_AfBryN2zYXCXPgeqRBMMn7YPbsMnzHyrfQxU1wdtAgjwfg&oe=646E8C80";
        String imageurl4 = "https://scontent.fceb3-1.fna.fbcdn.net/v/t39.30808-6/333126521_216956150846225_8640000905056573982_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=8bfeb9&_nc_eui2=AeE4h282K0RK0TvIm29wXk6d5Qp80dLR9EXlCnzR0tH0RdxZXhi72NoQyNu8VVOOcxPMdsNlVsaqO3uaWHcvBZ_R&_nc_ohc=K3mlrvlKPGkAX_hoTv8&_nc_ht=scontent.fceb3-1.fna&oh=00_AfA5eGLk0Ce2dl9YHpy6GK296bDVZVGAT3bG_UP3EsgJxQ&oe=646EC565";
        imagesArrayList.add(new onlineImages(imageurl, ""));
        imagesArrayList.add(new onlineImages(imageurl2, ""));
        imagesArrayList.add(new onlineImages(imageurl3, ""));
        imagesArrayList.add(new onlineImages(imageurl4, ""));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new imagesAdapter(PhotoGallery.this, imagesArrayList);
        recyclerView.setAdapter(adapter);
    }
}
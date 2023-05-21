package com.example.reservo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.reservo.Login;
import com.example.reservo.RHealthIntro;
import com.example.reservo.ReservoLens;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeFragment extends Fragment {

    private ImageButton rFi, rH, rL, rG, rFo;
    private FirebaseAuth auth;
    private FirebaseUser user;
    private Button btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        rFi = view.findViewById(R.id.reservofitness);
        rH = view.findViewById(R.id.reservohealth);
        rL = view.findViewById(R.id.reservolens);
        rG = view.findViewById(R.id.reservoglam);
        rFo = view.findViewById(R.id.reservofood);


        if (user == null) {
            Intent intent = new Intent(getActivity(), Login.class);
            startActivity(intent);
            getActivity().finish();
        }

        rL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ReservoLens.class);
                startActivity(i);
            }
        });

        rH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RHealthIntro.class);
                startActivity(intent);
            }
        });

        return view;
    }
}

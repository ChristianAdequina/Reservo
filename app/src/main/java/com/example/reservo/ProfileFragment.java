package com.example.reservo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileFragment extends Fragment implements View.OnClickListener {
    private TextView signOutTextView;
    private TextView paymentOptionsButton;

    private TextView medhistory;
    private TextView photogallery;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        signOutTextView = view.findViewById(R.id.signout_textview);
        signOutTextView.setOnClickListener(this);

        paymentOptionsButton = view.findViewById(R.id.payment_option_button);
        paymentOptionsButton.setOnClickListener(this);

        medhistory = view.findViewById(R.id.medhistory);
        medhistory.setOnClickListener(this);

        photogallery = view.findViewById(R.id.photogallery);
        photogallery.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == signOutTextView) {
            // Redirect to the login page
            redirectToLoginPage();
        } else if (v == paymentOptionsButton) {
            // Handle payment options button click
            openPaymentOptions();
        }
        else if (v == medhistory) {
            // Handle payment options button click
            openMedHistory();
        }else if (v == photogallery) {
            // Handle payment options button click
            openPhotoGallery();
        }
    }

    private void redirectToLoginPage() {
        // Perform any necessary cleanup or sign out logic here

        // Start the login activity
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getActivity(), Login.class);
        startActivity(intent);
        getActivity().finish();
    }

    private void openPaymentOptions() {
        // Handle payment options click
        Intent intent = new Intent(getActivity(), PaymentOptions.class);
        startActivity(intent);
        // Add your code here
    }

    private void openMedHistory() {
        // Handle payment options click
        Intent intent = new Intent(getActivity(), MedHistory.class);
        startActivity(intent);
        // Add your code here
    }

    private void openPhotoGallery() {
        // Handle payment options click
        Intent intent = new Intent(getActivity(), PhotoGallery.class);
        startActivity(intent);
        // Add your code here
    }
}

package com.example.reservo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class ShopFragment extends Fragment {

    private CardView voucher1CardView;
    private CardView voucher2CardView;
    private CardView voucher3CardView;
    private CardView voucher4CardView;

    public ShopFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        voucher1CardView = view.findViewById(R.id.voucher1_card_view);
        voucher2CardView = view.findViewById(R.id.voucher2_card_view);
        voucher3CardView = view.findViewById(R.id.voucher3_card_view);
        voucher4CardView = view.findViewById(R.id.voucher4_card_view);

        voucher1CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle voucher1 click
                Toast.makeText(getActivity(), "Voucher 1 clicked", Toast.LENGTH_SHORT).show();
                // Start VoucherActivity
                Intent intent = new Intent(getActivity(), VoucherPrompt.class);
                startActivity(intent);
            }
        });

        voucher2CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle voucher2 click
                Toast.makeText(getActivity(), "Voucher 2 clicked", Toast.LENGTH_SHORT).show();
                // Start VoucherActivity
                Intent intent = new Intent(getActivity(), VoucherPrompt.class);
                startActivity(intent);
            }
        });

        voucher2CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle voucher2 click
                Toast.makeText(getActivity(), "Voucher 2 clicked", Toast.LENGTH_SHORT).show();
                // Start VoucherActivity
                Intent intent = new Intent(getActivity(), VoucherPrompt.class);
                startActivity(intent);
            }
        });
        voucher3CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle voucher2 click
                Toast.makeText(getActivity(), "Voucher 3 clicked", Toast.LENGTH_SHORT).show();
                // Start VoucherActivity
                Intent intent = new Intent(getActivity(), VoucherPrompt.class);
                startActivity(intent);
            }
        });

        voucher4CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle voucher2 click
                Toast.makeText(getActivity(), "Voucher 4 clicked", Toast.LENGTH_SHORT).show();
                // Start VoucherActivity
                Intent intent = new Intent(getActivity(), VoucherPrompt.class);
                startActivity(intent);
            }
        });

        // Add click listeners for other voucher cards if needed
    }
}
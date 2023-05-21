package com.example.reservo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HistoryFragment extends Fragment implements View.OnClickListener {
    private TextView ongoingScheduleButton;
    private TextView historyButton;
    private LinearLayout ongoingScheduleLayout;
    private LinearLayout historyLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        ongoingScheduleButton = view.findViewById(R.id.ongoing_schedule_button);
        historyButton = view.findViewById(R.id.history_button);
        ongoingScheduleLayout = view.findViewById(R.id.ongoing_schedule_layout);
        historyLayout = view.findViewById(R.id.history_layout);

        ongoingScheduleButton.setOnClickListener(this);
        historyButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == ongoingScheduleButton) {
            showOngoingSchedule();
        } else if (v == historyButton) {
            showHistory();
        }
    }

    private void showOngoingSchedule() {
        ongoingScheduleButton.setSelected(true);
        historyButton.setSelected(false);

        ongoingScheduleLayout.setVisibility(View.VISIBLE);
        historyLayout.setVisibility(View.GONE);
    }

    private void showHistory() {
        ongoingScheduleButton.setSelected(false);
        historyButton.setSelected(true);

        ongoingScheduleLayout.setVisibility(View.GONE);
        historyLayout.setVisibility(View.VISIBLE);
    }
}

package com.immersivex.studentstoolbox;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DashboardFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container,false);
        final String name = AppDatabase.getInstance(getActivity()).userDao().getstudentName();
        final TextView dashText = view.findViewById(R.id.dashboardText);
        if (name !=null) if (!name.equals("")) dashText.setText(getString(R.string.dashboardText2)  + " " + name);
        else dashText.setText(getString(R.string.dashboardText1));
        return view;
    }
}

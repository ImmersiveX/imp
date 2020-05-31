package com.immersivex.studentstoolbox;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.dhaval2404.imagepicker.ImagePicker;

public class ProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container,false);
        final String name = AppDatabase.getInstance(getActivity()).userDao().getstudentName();
        final String surname = AppDatabase.getInstance(getActivity()).userDao().getstudentSurname();
        final String email = AppDatabase.getInstance(getActivity()).userDao().getstudentEmail();
        final EditText studentName = view.findViewById(R.id.stuName);
        final EditText studentSurname = view.findViewById(R.id.stuSurname);
        final EditText studentEmail = view.findViewById(R.id.stuEmail);

        if (name != null) studentName.setText(name);
        if (surname != null) studentSurname.setText(surname);
        if (email != null) studentEmail.setText(email);
        Button button = (Button) view.findViewById(R.id.updatebtn);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                User user = new User(studentName.getText().toString(), studentSurname.getText().toString(), studentEmail.getText().toString());
                if (name != null) AppDatabase.getInstance(getActivity()).userDao().updateUser(user);
                else AppDatabase.getInstance(getActivity()).userDao().addUser(user);
                studentName.clearFocus();
                studentSurname.clearFocus();
                studentEmail.clearFocus();

                Toast updated = Toast.makeText(getActivity(), R.string.profileUpdate, Toast.LENGTH_SHORT);
                updated.setGravity(Gravity.CENTER_HORIZONTAL,0,430);
                updated.show();
            }
        });


        return view;


    }
    /*public void updateUser(View view){
        String name = AppDatabase.getInstance(getActivity()).userDao().getstudentName();
        EditText studentName3 = view.findViewById(R.id.stuName);

        User user = new User(studentName3.getText().toString(), "test2", "test3");
        AppDatabase.getInstance(getActivity()).userDao().updateUser(user);
        //User name = AppDatabase.getInstance(getActivity()).userDao().getstudentName();
        //EditText studentName1 = (EditText).getView().findViewById(R.id.stuName);
        //View studentName2 = view.findViewById(R.id.stuName)
        //studentName3.setText(name.getStudentName());
    }*/
}

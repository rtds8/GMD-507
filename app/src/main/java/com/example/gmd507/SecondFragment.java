package com.example.gmd507;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class SecondFragment extends Fragment {

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        System.out.println("SecondFragment: On attach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("SecondFragment: On create");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println("SecondFragment: On create view");
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        System.out.println("SecondFragment: On view created");
        super.onViewCreated(view, savedInstanceState);
        Button secondButton  = view.findViewById(R.id.button_second);
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("SecondFragment: button click");
                ((MainActivity) getActivity()).replaceFragment(1);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("SecondFragment: On activity created");
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("SecondFragment: On start");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("SecondFragment: On resume");
    }

    // FRAGMENT IS ACTIVE

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("SecondFragment: On pause");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("SecondFragment: On stop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("SecondFragment: On destroy view");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("SecondFragment: On destroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("SecondFragment: On detach");
    }
}
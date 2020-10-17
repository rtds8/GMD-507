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

public class FirstFragment extends Fragment {

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        System.out.println("FirstFragment: On attach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("FirstFragment: On create");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println("FirstFragment: On create view");
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println("FirstFragment: On view created");

        Button firstButton = view.findViewById(R.id.button_first);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("FirstFragment: button click");
                ((MainActivity) getActivity()).replaceFragment(2);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("FirstFragment: On activity created");
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("FirstFragment: On start");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("FirstFragment: On resume");
    }

    // FRAGMENT IS ACTIVE

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("FirstFragment: On pause");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("FirstFragment: On stop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("FirstFragment: On destroy view");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("FirstFragment: On destroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("FirstFragment: On detach");
    }
}
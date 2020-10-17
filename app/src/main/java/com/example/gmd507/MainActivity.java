package com.example.gmd507;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MainActivity extends Activity {

    Map<Integer, Fragment> fragmentMap = new HashMap<>();

    boolean state = false;

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_6);
        System.out.println("On Create");

        RecyclerView recyclerView = findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        Adapter adapter = new Adapter(this);
        recyclerView.setAdapter(adapter);


//        LinearLayout container = findViewById(R.id.container);
//        for (int index = 0; index < 5000; index++) {
//            TextView textView = new TextView(this);
//            textView.setText(String.format(Locale.US, "Hello %d", index));
//            textView.setTextSize(24f);
//
//            container.addView(textView);
//        }

//        button = findViewById(R.id.button);
//        textView = findViewById(R.id.text);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (state) {
//                    textView.setText("Hello");
//                    textView.setTextColor(Color.WHITE);
//                } else {
//                    textView.setText("Hi");
//                    textView.setTextColor(Color.RED);
//                }
//                state = !state;
//            }
//        });

//        FirstFragment firstFragment = new FirstFragment();
//        SecondFragment secondFragment = new SecondFragment();
//        fragmentMap.put(1, firstFragment);
//        fragmentMap.put(2, secondFragment);
//        replaceFragment(1);
    }

    void replaceFragment(int fragmentKey) {
        System.out.println("Created first fragment");
        FragmentManager fragmentManager = getFragmentManager();
        System.out.println("Created Fragment Manager");
        fragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                fragmentMap.get(fragmentKey)
        ).commit();
        System.out.println("Committed fragment");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("On Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("On Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("On Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("On Stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("On Restart: Should go to on start");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("On Destroy");
    }
}
package com.vplibs.colorimagebottomnavexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.vplibs.colorimagebottomnav.BottomNavigationView;
import com.vplibs.colorimagebottomnav.NavigationItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnClickedButtonListener(new BottomNavigationView.OnClickedButtonListener() {
            @Override
            public void onClickedButton(NavigationItem button, int position) {
                Toast.makeText(MainActivity.this, "Clicked position " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

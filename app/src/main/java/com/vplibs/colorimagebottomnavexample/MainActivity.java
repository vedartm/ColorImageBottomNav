package com.vplibs.colorimagebottomnavexample;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import com.vplibs.colorimagebottomnav.BottomNavigationView;
import com.vplibs.colorimagebottomnav.NavigationItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationItem item = new NavigationItem(MainActivity.this, R.drawable.ic_home);
        NavigationItem item1 = new NavigationItem(MainActivity.this, R.drawable.ic_event);
        NavigationItem item2 = new NavigationItem(MainActivity.this, R.drawable.ic_search);
        NavigationItem item3 = new NavigationItem(MainActivity.this, R.drawable.ic_profile);
//        item.hide();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.addItem(item);
        bottomNavigationView.addItem(item1);
        bottomNavigationView.addItem(item2);
        bottomNavigationView.addItem(item3);


        bottomNavigationView.setOnClickedButtonListener(new BottomNavigationView.OnClickedButtonListener() {
            @Override
            public void onClickedButton(NavigationItem button, int position) {
                String page = null;
                switch (button.getDrawable()) {
                    case R.drawable.ic_home: //show fragment 1
                        page = "Home";
                        break;
                    case R.drawable.ic_event: //show fragment 2
                        page = "Events";
                        break;
                    case R.drawable.ic_search: //show fragment 3
                        page = "Search";
                        break;
                    case R.drawable.ic_profile: //show fragment 4
                        page = "Profile";
                        break;
                }
                Toast.makeText(MainActivity.this, "Clicked " + page, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

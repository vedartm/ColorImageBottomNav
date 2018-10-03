# Bottom Navigation with Color Image Library
ColorImageBottomNav is an Android library for Bottom navigation with color image support. Usually, the default BottomNavigation from andorid, does not support colored images (i.e., The images are force tinted to single color) in the menu items. ColorImageBottomNav supports both png and svg with color.

## Installation
### For Gradle:
#### 1. Add the JitPack repository to your build file
```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```  
#### 2. Add the dependency
```
dependencies {
  implementation 'com.github.venky97vp:ColorImageBottomNav:1.0.2'
}
```

### For Maven:
#### 1. Add the JitPack repository to your build file
```
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>
```
#### 2. Add the dependency
```
<dependency>
	<groupId>com.github.venky97vp</groupId>
	<artifactId>ColorImageBottomNav</artifactId>
	<version>1.0.1</version>
</dependency>
```
  
## Usage
The usage of this bottom navigation is really simple. Add this code to your `activity_sample.xml` layout. 
```
<com.vplibs.colorimagebottomnav.BottomNavigationView
        android:id="@+id/bottom_navigation"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        app:nav_dividerColor="#EBEBEB"
        app:nav_dividerSize="1dp"
        app:nav_selectorColor="@color/colorAccent"
        app:nav_selectorRadius="4dp"
        app:nav_selectorSize="4dp"/>
```

In your `SampleActivity.java` do this
```
        NavigationItem item = new NavigationItem(MainActivity.this, R.drawable.ic_home);
        NavigationItem item1 = new NavigationItem(MainActivity.this, R.drawable.ic_event);
        NavigationItem item2 = new NavigationItem(MainActivity.this, R.drawable.ic_search);
        NavigationItem item3 = new NavigationItem(MainActivity.this, R.drawable.ic_profile);

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
                        
                        break;
                    case R.drawable.ic_event: //show fragment 2
                       
                        break;
                    case R.drawable.ic_search: //show fragment 3
                        
                        break;
                    case R.drawable.ic_profile: //show fragment 4
                        
                        break;
                }
            }
        });
```
        
## Screenshots
<img src="https://raw.github.com/venky97vp/ColorImageBottomNav/master/images/img1.png" width="250"> <img src="https://raw.github.com/venky97vp/ColorImageBottomNav/master/images/img2.png" width="250">

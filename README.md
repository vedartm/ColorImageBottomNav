# Bottom Navigation with Color Image Library
Android library for Bottom navigation where images of the items can be a colored Image. 

## Installation
### For Gradle:
Step 1. Add the JitPack repository to your build file
```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```  
Step 2. Add the dependency
```
dependencies {
  implementation 'com.github.venky97vp:ColorImageBottomNav:1.0.0'
}
```

### For Maven:
Step 1. Add the JitPack repository to your build file
```
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>
```
Step 2. Add the dependency
```
<dependency>
	<groupId>com.github.venky97vp</groupId>
	<artifactId>ColorImageBottomNav</artifactId>
	<version>1.0.0</version>
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
  app:nav_selectorSize="4dp">
  
  ...
  
  <com.vplibs.colorimagebottomnav.NavigationItem
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:item_drawable="@drawable/ic_icon"
    app:item_drawableGravity="top"
    app:item_drawableHeight="36dp"
    app:item_drawablePadding="4dp"
    app:item_drawableWidth="36dp" />
        
  ...
        
</com.vplibs.colorimagebottomnav.BottomNavigationView>
```

In your `SampleActivity.java` do this
```
BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
bottomNavigationView.setOnClickedButtonListener(new BottomNavigationView.OnClickedButtonListener() {
  @Override
  public void onClickedButton(NavigationItem button, int position) {
    switch (position){
      case 0: //show fragment 1
        break;
      case 1: //show fragment 2
        break;
      case 2: //show fragment 3
        break;
      case 3: //show fragment 4
        break;
    }
  }
});
```
        
## Screenshots
<img src="https://raw.github.com/venky97vp/ColorImageBottomNav/master/images/img1.png" width="250"> <img src="https://raw.github.com/venky97vp/ColorImageBottomNav/master/images/img2.png" width="250">

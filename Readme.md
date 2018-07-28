## WeChatRadioBar
### 效果图
![](http://ww1.sinaimg.cn/mw690/b5405c76gw1f3qb7xo3wug20ax0ad4a1.gif)

### 用法
#### Gradle
Add it in your root build.gradle at the end of repositories:

```java
allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
}
```

Add the dependency

```java
dependencies {
	        compile 'com.github.leibnik:WechatRadioBar:1.2'
	}
```

#### xml
```xml
<io.github.leibnik.wechatradiobar.WeChatRadioGroup
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_alignParentBottom="true">

        <io.github.leibnik.wechatradiobar.WeChatRadioButton
                    android:layout_width="0dp"
                    android:layout_height="match_parent"
                    android:layout_weight="1"
                    android:gravity="center"
                    android:paddingTop="3dp"
                    android:text="发现"
                    android:textColor="#555"
                    android:textSize="13sp"
                    app:defocus_icon="@drawable/discover"
                    app:focus_color="#50ba26"
                    app:focus_icon="@drawable/discover_green"/>

                <io.github.leibnik.wechatradiobar.WechatRadioButton
                    android:layout_width="0dp"
                    android:layout_height="match_parent"
                    android:layout_weight="1"
                    android:gravity="center"
                    android:paddingTop="3dp"
                    android:text="我"
                    android:textColor="#555"
                    android:textSize="13sp"
                    app:defocus_icon="@drawable/about_me"
                    app:focus_color="#50ba26"
                    app:focus_icon="@drawable/about_me_green" />
</io.github.leibnik.wechatradiobar.WeChatRadioGroup>
```

* `app:focus_color`:选中状态文字的颜色
* `app:focus_icon`:选中状态的图标
* `app:defocus_icon`:非选中状态的图标

#### java
```java
viewPager = (ViewPager) findViewById(R.id.viewpager);
gradualRadioGroup = (WeChatRadioGroup) findViewById(R.id.radiogroup);
viewPager.setAdapter(adapter);
// 关键代码
gradualRadioGroup.setViewPager(viewPager);
```



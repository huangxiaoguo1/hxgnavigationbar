# hxgnavigationbar

####引入方式

```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}

dependencies {
	implementation 'com.github.huangxiaoguo1:hxgnavigationbar:1.0.0'
}
```

#### 基本使用

```
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DefaultNavigationBar build = new DefaultNavigationBar.Builder(this)
                .setContentView(R.layout.activity_titlebar)
                .setTitle(R.id.title_text, "我是标题")
                .setTitle(R.id.right_text, R.string.test_1)
                .setOnFinishClickListener(R.id.top_back)
                .setImage(R.id.image_btn, R.mipmap.ic_launcher_round)
                .setImage(R.id.image, R.mipmap.ic_launcher_round)
                .setOnClickListener(R.id.right_text, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "点击了右边", Toast.LENGTH_LONG).show();
                        title.setText("点击改变");
                    }
                })
                .build();
        title = build.getView(R.id.title_text);
    }
```

###### 设置布局

```
setContentView(R.layout.activity_titlebar)
```

##### 设置内容

```
setTitle(R.id.title_text, "我是标题")

setTitle(R.id.right_text, R.string.test_1)
```
###### 设置图片

```
setImage(R.id.image_btn, R.mipmap.ic_launcher_round)

setImage(R.id.image, R.mipmap.ic_launcher_round)
```

###### 设置点击关闭页面

```
setOnFinishClickListener(R.id.top_back)
```

###### 设置点击事件

```
setOnClickListener(R.id.right_text, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "点击了右边", Toast.LENGTH_LONG).show();
                    }
                })
```


###### 获得view对象

```
build.getView(R.id.title_text);
```

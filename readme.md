# 实验三：Android UI组件



## 1.Android ListView的用法

### 主要代码

#### activity

```java

public class MainActivity extends AppCompatActivity {

    private String [] names = new String [] {"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int [] imageIds = new int[] {R.drawable.lion,
            R.drawable.tiger,
            R.drawable.monkey,
            R.drawable.dog,
            R.drawable.cat,
            R.drawable.elephant};
//    private listview listview;
    HashMap<View, Boolean> view_select;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view_select = new HashMap<>();

        List<Map<String, Object>> listItems = new ArrayList<>();
        for (int i = 0; i < names.length; i++)
        {
            Map<String, Object> listItem = new HashMap<>();
            listItem.put("header", imageIds[i]);
            listItem.put("personName", names[i]);
            listItems.add(listItem);
        }
        //create a SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                listItems,
                R.layout.simple_item,
                new String[]{"personName","header"},
                new int[]{R.id.name, R.id.header});
        ListView list = findViewById(R.id.mylist);
        list.setAdapter(simpleAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                                     public void onItemClick(AdapterView parent, View view,int position,long id){
                                         Toast.makeText(MainActivity.this,names[position],Toast.LENGTH_LONG).show();
                                     }
        });


    }

```

#### layout

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="horizontal" android:layout_width="match_parent"
    android:layout_height="wrap_content">


    <TextView
        android:id="@+id/name"
        android:layout_width="351dp"
        android:layout_height="38dp"
        android:layout_gravity="center_vertical"
        android:textSize="15sp" />

    <ImageView
        android:id="@+id/header"
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:layout_gravity="end" />

</LinearLayout>
```

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="horizontal" android:layout_width="match_parent"
    android:layout_height="wrap_content">
    <ListView
        android:id="@+id/mylist"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
</LinearLayout>
```

### 效果图

[![BrjXRI.png](https://s1.ax1x.com/2020/11/03/BrjXRI.png)](https://imgchr.com/i/BrjXRI)

------



## 2、创建自定义布局的AlertDialog

### 主要代码

```
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bn=(Button)findViewById(R.id.clickme);

        LayoutInflater inflater=MainActivity.this.getLayoutInflater();
        View v= inflater.inflate(R.layout.alert,null,false);
        Context context=MainActivity.this;
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        //创建AlterDialog对象
        builder.setView(v);
        //输入文本
        builder.setCancelable(false);
        final AlertDialog alertDialog=builder.create();
        //创建对象
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.show();
            }
        });

        v.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"cancle",Toast.LENGTH_LONG).show();
                alertDialog.dismiss();
            }
        });
        v.findViewById(R.id.signin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Sign in",Toast.LENGTH_LONG).show();
                alertDialog.dismiss();
            }
        });
    }
}
```

### 效果图

[![Brjjzt.png](https://s1.ax1x.com/2020/11/03/Brjjzt.png)

------

## 3、使用XML定义菜单

### 主要代码

```
public class MainActivity extends AppCompatActivity {
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.txt);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem mi){
        if(mi.isCheckable()){
            mi.setChecked(true);
        }
        switch (mi.getItemId()){
            case R.id.font_10: txt.setTextSize(10*2); break;
            case R.id.font_16: txt.setTextSize(16*2); break;
            case R.id.font_20: txt.setTextSize(20*2); break;
            case R.id.red_font: txt.setTextColor(Color.RED); break;
            case R.id.black_font: txt.setTextColor(Color.BLACK); break;
            case R.id.plain_item:
                Toast.makeText(MainActivity.this,"单击普通菜单项",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
```

```
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
<item android:title="字体大小"

    >
    <menu>
        <!-- 定义一组单选菜单项-->
        <group android:checkableBehavior="single">
            <!--定义多个菜单项-->
            <item
                android:id="@+id/font_10"
                android:title="font_10"/>


            <item
                android:id="@+id/font_16"
                android:title="font_16"/>
            <item
                android:id="@+id/font_20"
                android:title="font_20"/>
        </group>
    </menu>
</item>
<!--普通菜单项-->
    <item android:id="@+id/plain_item"
        android:title="普通菜单项">
    </item>
    <item android:title="字体颜色">
        <menu>
            <item
                android:id="@+id/red_font"
                android:title="红色"/>

            <item
                android:id="@+id/black_font"
                android:title="黑色"/>

        </menu>
    </item>


</menu>

```

### 效果图

[![BrjxQP.png](https://s1.ax1x.com/2020/11/03/BrjxQP.png)](https://imgchr.com/i/BrjxQP)

------

## 4、创建上下文操作模式(ActionMode)的上下文菜单

### 主要代码

```
    ActionMode.Callback callback = new ActionMode.Callback() {

        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            actionMode.setTitle(selected_items + " selected");
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {

        }
```

### 效果图

[![Brjzsf.png](https://s1.ax1x.com/2020/11/03/Brjzsf.png)
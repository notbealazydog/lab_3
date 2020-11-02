package com.example.lab_33;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
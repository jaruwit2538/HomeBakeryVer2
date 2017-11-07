package com.example.khowoatt.homebakery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }
    public void clicklinkmenu (View view){
        Intent intent = new Intent(MainMenu.this,MainActivity.class);
        startActivity(intent);
    }//ลิ้งไปหน้า Menu pastry

    public void clicksupport(View view) {
        Intent intent = new Intent(MainMenu.this, AboutUs.class);
        startActivity(intent);
    }

    public void clickstatus(View view) {
        Intent intent = new Intent(MainMenu.this, CheckOrder.class);
        startActivity(intent);
    }
}

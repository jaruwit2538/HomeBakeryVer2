package com.example.khowoatt.homebakery;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);

        TextView idtitle = (TextView) findViewById(R.id.tilmem);
        TextView nametitle = (TextView) findViewById(R.id.namtil);
        TextView idmember = (TextView) findViewById(R.id.idd);
        TextView namemember = (TextView) findViewById(R.id.nam);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs",new Login().MODE_PRIVATE);
        String name = sharedPreferences.getString("nameKey",null);
        String id = sharedPreferences.getString("idKey",null);

        idmember.setText(id);
        namemember.setText(name);

    }

    public void clickback(View view) {
        finish();
    }

}

package com.example.khowoatt.homebakery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.khowoatt.homebakery.Adapter.AdapterCheckorder;
import com.example.khowoatt.homebakery.Database.OrderTable;

public class CheckOrder extends AppCompatActivity {
    private OrderTable objOrderTable;
    private ListView orderlistView;
    private String[] idmember,datetime,priceorder, status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_order);


        BindWidget();
        Cdatabase();


    }

    private void Cdatabase() {
        objOrderTable = new OrderTable(this);
    }

    private void BindWidget() {
        orderlistView = findViewById(R.id.listcheck);
    }

    public void clickback(View view) {
        finish();
    }
}


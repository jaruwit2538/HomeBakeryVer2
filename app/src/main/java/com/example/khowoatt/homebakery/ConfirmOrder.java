package com.example.khowoatt.homebakery;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.khowoatt.homebakery.Adapter.AdapterConfirm;
import com.example.khowoatt.homebakery.Database.OrderitemTable;

public class ConfirmOrder extends AppCompatActivity {
    private OrderitemTable objOrderitemTable;
    private ListView OrderitemListView;
    private String[] amountis,menuis, sumis;
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
        bindwidget();
        cdatabase();
        clistview();
    }

    private void cdatabase() {
        objOrderitemTable = new OrderitemTable(this);

    }

    private void bindwidget() {
        OrderitemListView = findViewById(R.id.livConfirm);
    }

    private void clistview() {

        final String[] amountitems = objOrderitemTable.readorderitem(4);
        final String[] menuitems = objOrderitemTable.readorderitem(2);
        final String[] sumitems = objOrderitemTable.readorderitem(5);
        AdapterConfirm objAdapterConfirm = new AdapterConfirm(ConfirmOrder.this, amountitems, menuitems, sumitems);
        OrderitemListView.setAdapter(objAdapterConfirm);
    }

    public void clickback(View view) {
        finish();
    }

}

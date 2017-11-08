package com.example.khowoatt.homebakery;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.khowoatt.homebakery.Database.OrderitemTable;
import com.example.khowoatt.homebakery.Database.OrderlistTable;
import com.squareup.picasso.Picasso;

import javax.sql.StatementEvent;

public class DetailMenu extends AppCompatActivity {

    private OrderitemTable objOrderitemTable;
    private String menu_id,price,amounts,ids ;
    private Button btn;
    private String amount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);

        objOrderitemTable = new OrderitemTable(this);


        ImageView detailimageView = (ImageView) findViewById(R.id.imvDetailmenu);
        TextView pricetextView = (TextView) findViewById(R.id.pricedetail);
        TextView nametextView = (TextView) findViewById(R.id.menudetail);
        TextView detailtextView = (TextView) findViewById(R.id.detail);
        Button button = findViewById(R.id.BtnOrder);


        ids = getIntent().getStringExtra("id");
        nametextView.setText(getIntent().getStringExtra("name"));
        pricetextView.setText(getIntent().getStringExtra("price"));
        detailtextView.setText(getIntent().getStringExtra("detail"));
        String image = getIntent().getStringExtra("image");
        Picasso.with(DetailMenu.this).load(image).into(detailimageView);


        final String menu_id = getIntent().getStringExtra("id");
        final String price = pricetextView.getText().toString().trim();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.amount);
                final String strAmount = editText.getText().toString().trim();
                addorderitem(menu_id,price,strAmount);
            }
        });

    }

    private void addorderitem(String menu_id, String price, String strAmount) {
        objOrderitemTable.AddOrderitem("id","name",menu_id,"detail",strAmount,price,"as","รอชำระ");
        finish();
    }


    public void onClickBack (View view){
        finish();
    }

    public void onClickcart(View view) {
        Intent intent = new Intent(DetailMenu.this, ConfirmOrder.class);
        finish();


    }
}

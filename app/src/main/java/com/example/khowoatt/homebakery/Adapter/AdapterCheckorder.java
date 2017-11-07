package com.example.khowoatt.homebakery.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.khowoatt.homebakery.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

/**
 * Created by Khowoat on 11/7/2017.
 */

public class AdapterCheckorder extends BaseAdapter {
    private Context objcontextcake;
    private String[] id, date, prices, statuss;

    public AdapterCheckorder(Context context, String[] idmem, String[] dateor, String[] priceor, String[] statusor) {
        this.objcontextcake = context;
        this.statuss = statusor;
        this.id = idmem;
        this.date = dateor;
        this.prices = priceor;

    }

    @Override
    public int getCount() {
        return statuss.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater objLayoutInflater = (LayoutInflater) objcontextcake.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = objLayoutInflater.inflate(R.layout.listviewcheckorder,parent,false);

        TextView idorTextView= (TextView) view1.findViewById(R.id.numorder);
        TextView dateorTextView = (TextView) view1.findViewById(R.id.titledate);
        TextView priceorTextView = (TextView) view1.findViewById(R.id.titleprices);
        TextView statusorTextView = (TextView) view1.findViewById(R.id.titlestatus);

        idorTextView.setText("เลขที่การจอง" + id[position]);
        dateorTextView.setText("วันที่สั่งจอง" + date[position]);
        priceorTextView.setText("ราคา" + prices[position]);
        statusorTextView.setText("สถานะการจอง"+statuss[position]);
        return view1;

    }
}

package com.example.khowoatt.homebakery.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.khowoatt.homebakery.R;

/**
 * Created by Khowoat on 11/8/2017.
 */

public class AdapterConfirm extends BaseAdapter{
    private Context objcontext;
    private String[] menuitem,amoutitem, priceitem;

    public AdapterConfirm(Context context, String[] menuitem, String[] amoutitem, String[] priceitem) {
        this.objcontext = context;
        this.menuitem = menuitem; // ชื่อ
        this.amoutitem = amoutitem; // รูป
        this.priceitem = priceitem; // ราคา
    }

    @Override
    public int getCount() {
        return amoutitem.length;
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
        LayoutInflater objLayoutInflater = (LayoutInflater) objcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = objLayoutInflater.inflate(R.layout.listviewconfirm, parent, false);

        TextView txtmenuTextView = view.findViewById(R.id.txtmenu);
        TextView txtamountTextView = view.findViewById(R.id.txtamount);
        TextView txtsumTextView = view.findViewById(R.id.txtsum);

        txtmenuTextView.setText(menuitem[position]);
        txtamountTextView.setText(amoutitem[position]);
        txtsumTextView.setText(priceitem[position]);

        return view;
    }
}

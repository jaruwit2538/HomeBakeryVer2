package com.example.khowoatt.homebakery.Database;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.khowoatt.homebakery.Login;

/**
 * Created by khowoatt on 8/29/2017.
 */

public class OrderlistTable {

    private MySQLiteOpenHelper objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase;
    private SQLiteDatabase readSqLiteDatabase;

    public static final String OrderList_TABLE = "orderlisttable";
    public static final String Order_Num = "order_num";
    public static final String OrderList_ID_ORDER = "id_order";
    public static final String OrderList_ID_MENU = "id_menu";
    public static final String Name_Menu = "name_menu";
    public static final String OrderList_AMOUNT = "amount";
    public static final String OrderLIST_TOTAL = "total";

    public OrderlistTable(Context context) {
        objMySQLiteOpenHelper = new MySQLiteOpenHelper(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }

    public long AddNewOrderListTable(String ordernum,String id_order, String id_menu,String namemenu, String amount,String total) {
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(objMySQLiteOpenHelper.Order_Num,ordernum);
        objContentValues.put(objMySQLiteOpenHelper.OrderList_ID_ORDER, id_order);
        objContentValues.put(objMySQLiteOpenHelper.OrderList_ID_MENU, id_menu);
        objContentValues.put(objMySQLiteOpenHelper.Name_Menu,namemenu);
        objContentValues.put(objMySQLiteOpenHelper.OrderList_AMOUNT, amount);
        objContentValues.put(objMySQLiteOpenHelper.OrderLIST_TOTAL, total);

        return readSqLiteDatabase.insert(objMySQLiteOpenHelper.OrderList_TABLE, null, objContentValues);
    }

    public String[] readALLOrderListTable(int intColume){

        try {
            String[] strResult = null;
            Cursor objCursor = readSqLiteDatabase.query(OrderList_TABLE, new String[]{Order_Num,OrderList_ID_ORDER,OrderList_ID_MENU,Name_Menu,OrderList_AMOUNT,OrderLIST_TOTAL},null,null,null,null,null);
            if(objCursor != null){
                if(objCursor.moveToFirst()){
                    strResult = new String[10];
                    for(int i =0;i<10;i++){
                        strResult[i] = objCursor.getString(intColume);
                        objCursor.moveToNext();
                    }
                }
            }
            objCursor.close();
            return strResult;
        }catch (Exception e){
            return null;
        }
        //return new String[0];
    }


}


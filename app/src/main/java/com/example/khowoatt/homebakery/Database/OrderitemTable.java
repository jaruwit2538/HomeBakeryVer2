package com.example.khowoatt.homebakery.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Khowoat on 11/7/2017.
 */

public class OrderitemTable {
    private MySQLiteOpenHelper objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase;
    private SQLiteDatabase readSqLiteDatabase;

    public static final String OrderItem_TABLE = "orderitem";
    public static final String Order_Ids = "order_id";
    public static final String Member_Ids = "member_id";
    public static final String Menu_Ids = "menu_id";
    public static final String Date_Orders = "date_order";
    public static final String Amounts = "amount";
    public static final String Prices = "price";
    public static final String Sums = "sum";
    public static final String Statuss = "status";

    public OrderitemTable(Context context) {
        objMySQLiteOpenHelper = new MySQLiteOpenHelper(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }

    public long AddOrderitem(String order_Ids, String member_Ids, String menu_Ids, String date_Orders, String amounts, String prices, String sums, String statuss) {
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(objMySQLiteOpenHelper.Order_Ids, order_Ids);
        objContentValues.put(objMySQLiteOpenHelper.Member_Ids, member_Ids);
        objContentValues.put(objMySQLiteOpenHelper.Menu_Ids, menu_Ids);
        objContentValues.put(objMySQLiteOpenHelper.Date_Orders, date_Orders);
        objContentValues.put(objMySQLiteOpenHelper.Amounts, amounts);
        objContentValues.put(objMySQLiteOpenHelper.Prices, prices);
        objContentValues.put(objMySQLiteOpenHelper.Sums, sums);
        objContentValues.put(objMySQLiteOpenHelper.Statuss, statuss);
        return readSqLiteDatabase.insert(objMySQLiteOpenHelper.OrderItem_TABLE, null, objContentValues);
    }


    public String[] readorderitem(int int3) {
        try {
            String[] strResult = null;
            Cursor objCursor = readSqLiteDatabase.query(OrderItem_TABLE,
                    new String[]{Order_Ids,Member_Ids,Menu_Ids,Date_Orders,Amounts,Prices,Sums,Statuss},null,null,null,null,null);
            if(objCursor != null){
                if(objCursor.moveToFirst()){
                    int num = objCursor.getCount();
                    strResult = new String[num];
                    for(int i =0;i<num;i++){
                        strResult[i] = objCursor.getString(int3);
                        objCursor.moveToNext();
                    }
                }
            }
            objCursor.close();
            return strResult;
        }catch (Exception e){
            return null;
        }
    }//อ่านข้อมูลจากฐาน database

}


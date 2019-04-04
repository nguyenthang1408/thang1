package com.example.hp8440p.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.RequiresApi;
import android.widget.TextView;

import com.example.hp8440p.myapplication.Oject.NoiDung;
import com.example.hp8440p.myapplication.Tag_Fragment.tab_LoaiThu_Fragment;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    private static final  int VERSION = 1;
    private static final String DATABASE_NAME = "LoaiThu";
    private static  final  String TABLE = "CREATE TABLE LoaiThu(id INTEGER  PRIMARY KEY AUTOINCREMENT, \n" +
            "noiDung TEXT, soTien TEXT, theLoai TEXT , ngay TEXT, note TEXT )";
    private static  final  String TABLE2 = "CREATE TABLE KhoangThu(id INTEGER  PRIMARY KEY AUTOINCREMENT, \n" +
            "noiDung TEXT, soTien TEXT, theLoai TEXT , ngay TEXT, note TEXT )";
    private static  final  String TABLE3 = "CREATE TABLE LoaiChi(id INTEGER  PRIMARY KEY AUTOINCREMENT, \n" +
            "noiDung TEXT, soTien TEXT, theLoai TEXT , ngay TEXT, note TEXT )";
    private static  final  String TABLE4 = "CREATE TABLE KhoangChi(id INTEGER  PRIMARY KEY AUTOINCREMENT, \n" +
            "noiDung TEXT, soTien TEXT, theLoai TEXT , ngay TEXT, note TEXT )";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    public Cursor GetData(String sql) {

        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);

    }


    public void QueryData(String sql) {

        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);

    }
//________________THEM_______________________*****************************
    public int addData(NoiDung nd){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("theLoai", nd.getTheLoai());
        value.put("ngay", nd.getNgay());
        value.put("soTien", nd.getSoTien());
        value.put("note", nd.getGhiChu());
        value.put("noiDung", nd.getNoiDung());
        if(db.insert("LoaiThu", null, value) == -1 ){
            return -1;
        }
        return 1;
    }
    public int addDataKT(NoiDung nd){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("theLoai", nd.getTheLoai());
        value.put("ngay", nd.getNgay());
        value.put("soTien", nd.getSoTien());
        value.put("note", nd.getGhiChu());
        value.put("noiDung", nd.getNoiDung());
       //Note-------------------------------------------------
        if(db.insert("KhoangThu", null, value) == -1 ){
            return -1;
        }
        return 1;
    }
    public int addDataLC(NoiDung nd){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("theLoai", nd.getTheLoai());
        value.put("ngay", nd.getNgay());
        value.put("soTien", nd.getSoTien());
        value.put("note", nd.getGhiChu());
        value.put("noiDung", nd.getNoiDung());
        if(db.insert("LoaiChi", null, value) == -1 ){
            return -1;
        }
        return 1;
    }
    public int addDataKC(NoiDung nd){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("theLoai", nd.getTheLoai());
        value.put("ngay", nd.getNgay());
        value.put("soTien", nd.getSoTien());
        value.put("note", nd.getGhiChu());
        value.put("noiDung", nd.getNoiDung());
        if(db.insert("KhoangChi", null, value) == -1 ){
            return -1;
        }
        return 1;
    }



    public List<NoiDung> getDataLT(){
        List<NoiDung> list = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.query("LoaiThu", null,null,null,null,null,null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            NoiDung nd = new NoiDung();
            nd.setIdNoiDung(Integer.parseInt(c.getString(0)));
            nd.setNoiDung(c.getString(1));
            nd.setSoTien(c.getString(2));
            nd.setTheLoai(c.getString(3));
            nd.setNgay(c.getString(4));
            nd.setGhiChu(c.getString(5));
            list.add(nd);
            c.moveToNext();
        }
        c.close();
        return list;
    }

    public List<NoiDung> getDataKT(){
        List<NoiDung> list = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.query("KhoangThu", null,null,null,null,null,null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            NoiDung nd = new NoiDung();

            nd.setIdNoiDung(Integer.parseInt(c.getString(0)));
            nd.setNoiDung(c.getString(1));
            nd.setSoTien(c.getString(2));
            nd.setTheLoai(c.getString(3));
            nd.setNgay(c.getString(4));
            nd.setGhiChu(c.getString(5));
            list.add(nd);
            c.moveToNext();
        }
        c.close();
        return list;
    }
    public List<NoiDung> getDataLC(){
        List<NoiDung> list = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.query("LoaiChi", null,null,null,null,null,null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            NoiDung nd = new NoiDung();
            nd.setIdNoiDung(Integer.parseInt(c.getString(0)));
            nd.setNoiDung(c.getString(1));
            nd.setSoTien(c.getString(2));
            nd.setTheLoai(c.getString(3));
            nd.setNgay(c.getString(4));
            nd.setGhiChu(c.getString(5));
            list.add(nd);
            c.moveToNext();
        }
        c.close();
        return list;
    }
    public List<NoiDung> getDataKC(){
        List<NoiDung> list = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.query("KhoangChi", null,null,null,null,null,null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            NoiDung nd = new NoiDung();
            nd.setIdNoiDung(Integer.parseInt(c.getString(0)));
            nd.setNoiDung(c.getString(1));
            nd.setSoTien(c.getString(2));
            nd.setTheLoai(c.getString(3));
            nd.setNgay(c.getString(4));
            nd.setGhiChu(c.getString(5));
            list.add(nd);
            c.moveToNext();
        }
        c.close();
        return list;
    }

    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @RequiresApi(api = 28)
    public Database(Context context, String name, int version, SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE);
        db.execSQL(TABLE2);
        db.execSQL(TABLE3);
        db.execSQL(TABLE4);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
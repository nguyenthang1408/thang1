package com.example.hp8440p.myapplication.FragmentManager;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp8440p.myapplication.R;
import com.example.hp8440p.myapplication.database.Database;

import java.util.ArrayList;
import java.util.List;

public class ThongKeFragment extends Fragment {
    Database db;
    TextView khoangThu;
    TextView loaiThu;
    TextView khoangChi;
    TextView loaiChi;
    TextView tong, tvTongKhoangThu, tvTongKhoangChi, tvTongTheoThang,getTvTongTheoThangKt,getTvTongTheoThanglc,getGetTvTongTheoThangkc;
    LinearLayout linearLayout;
    Double a = null;
    Double b = null;
    Double c = null;
    Double d = null;
    List<String> danhSachThang;
    List<String> danhSachThangKt;
    List<String> danhSachThangLc;
    List<String> danhSachThangKc;
    ArrayAdapter adapter;


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.thongke_fragment, container, false);
        linearLayout = view.findViewById(R.id.thongKe_layout);
        khoangThu = view.findViewById(R.id.tvThongKeKhoangThu);
        loaiThu = view.findViewById(R.id.tvThongKELoaiTHu);
        khoangChi = view.findViewById(R.id.tvThongKeKhoangChi);
        loaiChi = view.findViewById(R.id.tvThongKeLoaiChi);
        tong = view.findViewById(R.id.tvThongKeTong);
        tvTongKhoangChi = view.findViewById(R.id.tvTongKhoangChi);
        tvTongKhoangThu = view.findViewById(R.id.tvTongKhoangThu);
        Result(khoangThu, "KhoangThu");
        Result(loaiThu, "LoaiThu");
        Result(khoangChi, "KhoangChi");
        Result(loaiChi, "LoaiChi");
        Double sum = null;
        Double sumKc = null;
        Double sumKt = null;
        try {
            if (c == null) {
                d = Double.parseDouble(loaiChi.getText().toString());
                sumKc = d;
                tvTongKhoangChi.setText("" + sumKc);
            }
            c = Double.parseDouble(khoangChi.getText().toString());
            d = Double.parseDouble(loaiChi.getText().toString());
            sumKc = c + d;
            tvTongKhoangChi.setText("" + sumKc);
        } catch (Exception ex) {

        }
        try {
            if (d == null) {
                c = Double.parseDouble(khoangChi.getText().toString());
                sumKc = c;
                tvTongKhoangChi.setText("" + sumKc);
            }
            c = Double.parseDouble(khoangChi.getText().toString());
            d = Double.parseDouble(loaiChi.getText().toString());
            sumKc = c + d;
            tvTongKhoangChi.setText("" + sumKc);
        } catch (Exception ex) {
        }
        try {
            if (d == null && c == null) {
                tvTongKhoangChi.setText("0");
            }
            c = Double.parseDouble(khoangChi.getText().toString());
            d = Double.parseDouble(loaiChi.getText().toString());
            sumKc = c + d;
            tvTongKhoangChi.setText("" + sumKc);
        } catch (Exception ex) {
        }

        try {
            if (a == null) {
                b = Double.parseDouble(loaiThu.getText().toString());
                sumKt = b;
                tvTongKhoangThu.setText("" + sumKt);
            }
            a = Double.parseDouble(khoangThu.getText().toString());
            b = Double.parseDouble(loaiThu.getText().toString());
            sumKt = a + b;
            tvTongKhoangThu.setText("" + sumKt);
        } catch (Exception ex) {

        }
        try {
            if (b == null) {
                a = Double.parseDouble(khoangThu.getText().toString());
                sumKt = b;
                tvTongKhoangThu.setText("" + sumKt);
            }
            a = Double.parseDouble(khoangThu.getText().toString());
            b = Double.parseDouble(loaiThu.getText().toString());
            sumKt = a + b;
            tvTongKhoangThu.setText("" + sumKt);
        } catch (Exception ex) {

        }
        try {
            if (a == null && b == null) {
                tvTongKhoangThu.setText("0");
            }
            a = Double.parseDouble(khoangThu.getText().toString());
            b = Double.parseDouble(loaiThu.getText().toString());
            sumKc = a + b;
            tvTongKhoangThu.setText("" + sumKt);
        } catch (Exception ex) {
        }


        //Bắt lỗi
        try {
            if (a == null) {
                b = Double.parseDouble(loaiThu.getText().toString());
                c = Double.parseDouble(khoangChi.getText().toString());
                d = Double.parseDouble(loaiChi.getText().toString());
                sum = (0 + b) - (c + d);
                tong.setText("" + sum);
            }
            a = Double.parseDouble(khoangThu.getText().toString());
            b = Double.parseDouble(loaiThu.getText().toString());
            c = Double.parseDouble(khoangChi.getText().toString());
            d = Double.parseDouble(loaiChi.getText().toString());
            sum = (a + b) - (c + d);
            tong.setText("" + sum);
        } catch (Exception ex) {

        }
        try {
            if (b == null) {
                a = Double.parseDouble(khoangThu.getText().toString());
                c = Double.parseDouble(khoangChi.getText().toString());
                d = Double.parseDouble(loaiChi.getText().toString());
                sum = (a + 0) - (c + d);
                tong.setText("" + sum);
            }
            a = Double.parseDouble(khoangThu.getText().toString());
            b = Double.parseDouble(loaiThu.getText().toString());
            c = Double.parseDouble(khoangChi.getText().toString());
            d = Double.parseDouble(loaiChi.getText().toString());
            sum = (a + b) - (c + d);
            tong.setText("" + sum);
        } catch (Exception ex) {

        }
        try {
            if (c == null) {
                a = Double.parseDouble(khoangThu.getText().toString());
                b = Double.parseDouble(loaiThu.getText().toString());
                d = Double.parseDouble(loaiChi.getText().toString());
                sum = (a + b) - (0 + d);
                tong.setText("" + sum);
            }
            a = Double.parseDouble(khoangThu.getText().toString());
            b = Double.parseDouble(loaiThu.getText().toString());
            c = Double.parseDouble(khoangChi.getText().toString());
            d = Double.parseDouble(loaiChi.getText().toString());
            sum = (a + b) - (c + d);
            tong.setText("" + sum);
        } catch (Exception ex) {

        }
        try {
            if (d == null) {
                a = Double.parseDouble(khoangThu.getText().toString());
                b = Double.parseDouble(loaiThu.getText().toString());
                c = Double.parseDouble(khoangChi.getText().toString());
                sum = (a + b) - (c + 0);
                tong.setText("" + sum);
            }
            a = Double.parseDouble(khoangThu.getText().toString());
            b = Double.parseDouble(loaiThu.getText().toString());
            c = Double.parseDouble(khoangChi.getText().toString());
            d = Double.parseDouble(loaiChi.getText().toString());
            sum = (a + b) - (c + d);
            tong.setText("" + sum);
        } catch (Exception ex) {

        }
        try {
            if (a == null && b == null) {
                c = Double.parseDouble(khoangChi.getText().toString());
                d = Double.parseDouble(loaiChi.getText().toString());
                sum = (0 + 0) - (c + d);
                tong.setText("" + sum);
            }
            a = Double.parseDouble(khoangThu.getText().toString());
            b = Double.parseDouble(loaiThu.getText().toString());
            c = Double.parseDouble(khoangChi.getText().toString());
            d = Double.parseDouble(loaiChi.getText().toString());
            sum = (a + b) - (c + d);
            tong.setText("" + sum);
        } catch (Exception ex) {

        }
        try {
            if (b == null && c == null) {
                a = Double.parseDouble(khoangThu.getText().toString());
                b = Double.parseDouble(loaiThu.getText().toString());
                sum = c + d;
                tong.setText("" + sum);
            }
            a = Double.parseDouble(khoangThu.getText().toString());
            b = Double.parseDouble(loaiThu.getText().toString());
            c = Double.parseDouble(khoangChi.getText().toString());
            d = Double.parseDouble(loaiChi.getText().toString());
            sum = (a + b) - (c + d);
            tong.setText("" + sum);
        } catch (Exception ex) {

        }
        try {
            if (c == null && d == null) {
                a = Double.parseDouble(khoangThu.getText().toString());
                b = Double.parseDouble(loaiThu.getText().toString());
                sum = a + b;
                tong.setText("" + sum);
            }
            a = Double.parseDouble(khoangThu.getText().toString());
            b = Double.parseDouble(loaiThu.getText().toString());
            c = Double.parseDouble(khoangChi.getText().toString());
            d = Double.parseDouble(loaiChi.getText().toString());
            sum = (a + b) - (c + d);
            tong.setText("" + sum);
        } catch (Exception ex) {

        }
        try {
            if (d == null && a == null) {
                c = Double.parseDouble(khoangChi.getText().toString());
                b = Double.parseDouble(loaiThu.getText().toString());
                sum = b-c;
                tong.setText("" + sum);
            }
            a = Double.parseDouble(khoangThu.getText().toString());
            b = Double.parseDouble(loaiThu.getText().toString());
            c = Double.parseDouble(khoangChi.getText().toString());
            d = Double.parseDouble(loaiChi.getText().toString());
            sum = (a + b) - (c + d);
            tong.setText("" + sum);
        } catch (Exception ex) {

        }
        try {
            if (a == null && b == null && c == null) {
                d = Double.parseDouble(loaiChi.getText().toString());
                tong.setText("" + d);
            }
            a = Double.parseDouble(khoangThu.getText().toString());
            b = Double.parseDouble(loaiThu.getText().toString());
            c = Double.parseDouble(khoangChi.getText().toString());
            d = Double.parseDouble(loaiChi.getText().toString());
            sum = (a + b) - (c + d);
            tong.setText("" + sum);
        } catch (Exception ex) {

        }
        try {
            if (d == null && b == null && c == null) {
                a = Double.parseDouble(khoangThu.getText().toString());
                tong.setText("" + a);
            }
            a = Double.parseDouble(khoangThu.getText().toString());
            b = Double.parseDouble(loaiThu.getText().toString());
            c = Double.parseDouble(khoangChi.getText().toString());
            d = Double.parseDouble(loaiChi.getText().toString());
            sum =(a + b) - (c + d);
            tong.setText("" + sum);
        } catch (Exception ex) {

        }
        try {
            if (d == null && a == null && c == null) {
                b = Double.parseDouble(loaiThu.getText().toString());
                tong.setText("" + b);
            }
            a = Double.parseDouble(khoangThu.getText().toString());
            b = Double.parseDouble(loaiThu.getText().toString());
            c = Double.parseDouble(khoangChi.getText().toString());
            d = Double.parseDouble(loaiChi.getText().toString());
            sum = (a + b) - (c + d);
            tong.setText("" + sum);
        } catch (Exception ex) {

        }
        try {
            if (d == null && a == null && b == null) {
                c = Double.parseDouble(khoangChi.getText().toString());
                tong.setText("" + c);
            }
            a = Double.parseDouble(khoangThu.getText().toString());
            b = Double.parseDouble(loaiThu.getText().toString());
            c = Double.parseDouble(khoangChi.getText().toString());
            d = Double.parseDouble(loaiChi.getText().toString());
            sum = (a + b) - (c + d);
            tong.setText("" + sum);
        } catch (Exception ex) {

        }
        try {
            if (d == null && a == null && b == null && c == null) {
                tong.setText("" + 0);
            }
            a = Double.parseDouble(khoangThu.getText().toString());
            b = Double.parseDouble(loaiThu.getText().toString());
            c = Double.parseDouble(khoangChi.getText().toString());
            d = Double.parseDouble(loaiChi.getText().toString());
            sum = (a + b) - (c + d);
            tong.setText("" + sum);
        } catch (Exception ex) {

        }

        return view;
    }

    private void Result(TextView tv, String table) {
        db = new Database(getActivity());
        Cursor cursor = db.GetData("SELECT SUM(soTien) FROM '" + table + "' ;");
        if (tv.equals("")) {

        }
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    String result = "0";
                    result = cursor.getString(0);
                    tv.setText(result);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
    }

    private void getMonth(TextView tv, String table, String day) {
        db = new Database(getActivity());
        Cursor cursor = db.GetData("SELECT Sum(soTien) FROM '" + table + "' WHERE ngay LIKE '"+day+"'");
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    String result = "0";
                    result = cursor.getString(0);
                    tv.setText(result);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
    }
}




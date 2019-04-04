package com.example.hp8440p.myapplication.Tag_Fragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp8440p.myapplication.Adapter.NoiDungKhoangChi_Adapter;
import com.example.hp8440p.myapplication.Adapter.NoiDungKhoangThu_Adapter;
import com.example.hp8440p.myapplication.Oject.NoiDung;
import com.example.hp8440p.myapplication.R;
import com.example.hp8440p.myapplication.database.Database;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class    tab_KhoangChi_Fragment extends Fragment {
Database database;
NoiDungKhoangChi_Adapter adapter;
List<NoiDung> noiDungList;
ListView lvKhoangThu;
    TextView txtNgay;
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_khoangthu_fragment,container,false);

        noiDungList = new ArrayList<>();
        lvKhoangThu = view.findViewById(R.id.lvKhoangThu);
        getDataList(lvKhoangThu);

        FloatingActionButton fab = view.findViewById(R.id.fab);
        @SuppressLint("ResourceType") Animation animation = AnimationUtils.loadAnimation(getActivity(), R.animator.rotate);
        fab.startAnimation(animation);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogThem();
            }
        });
        return view;

    }
    public void dialogThem() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_them_khoangthu);
        //Dialog Full SCreen
        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.CENTER;
        wlp.flags &= ~WindowManager.LayoutParams.FLAG_BLUR_BEHIND;
        window.setAttributes(wlp);
        dialog.getWindow().setLayout( ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();

        Button btnGetDate = dialog.findViewById(R.id.btnDate);
        btnGetDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtNgay = dialog.findViewById(R.id.txtNgay);
                final Calendar cl = Calendar.getInstance();
                int day = cl.get(Calendar.DATE);
                int month = cl.get(Calendar.MONTH);
                int year = cl.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        cl.set(i,i1,i2);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        txtNgay.setText(simpleDateFormat.format(cl.getTime()));

                    }
                }, year,month,day);
                datePickerDialog.show();
            }

        });
        Button btnHuy = (Button) dialog.findViewById(R.id.btnHuy);

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        Button btnThem = (Button) dialog.findViewById(R.id.btnThem);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView txtNoidung = dialog.findViewById(R.id.txtTen);
                TextView txtSoTien = dialog.findViewById(R.id.txtSoTien);
                TextView txtTheLoai = dialog.findViewById(R.id.txtTheLoai);

                 txtNgay = dialog.findViewById(R.id.txtNgay);
                TextView txtGhiChu = dialog.findViewById(R.id.txtGhiChu);
                String noidung = txtNoidung.getText().toString();
                String soTien = txtSoTien.getText().toString();
                String theLoai = txtTheLoai.getText().toString();
                String nGay = txtNgay.getText().toString();
                String ghiChu = txtGhiChu.getText().toString();

                final NoiDung noiDung = new NoiDung(noidung,soTien,theLoai,nGay,ghiChu);

                noiDungList.add(noiDung);
                if (database.addDataKC(noiDung)>0){
                    if (noiDung.getNoiDung().toString().equals("") &&
                            noiDung.getGhiChu().toString().equals("")&&
                            noiDung.getNgay().toString().equals("")&&
                            noiDung.getTheLoai().toString().equals("")&&
                            noiDung.getSoTien().toString().equals("")){
                        Toast.makeText(getActivity(), "Dữ liệu trống. Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getActivity(), "Thêm dữ liệu thành công", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(getActivity(), "Thêm dữ liệu thất bại", Toast.LENGTH_SHORT).show();
                }
                getDataList(lvKhoangThu);
                dialog.cancel();
            }
        });
    }
    public void getDataList(ListView lv){
        database = new Database(getActivity());
        adapter = new NoiDungKhoangChi_Adapter(database.getDataKC(), this,R.layout.item_khoangchi_fragment, lv);
        lv.setAdapter(adapter);
    }
}

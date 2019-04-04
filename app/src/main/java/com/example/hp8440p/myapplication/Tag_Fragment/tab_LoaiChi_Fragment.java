package com.example.hp8440p.myapplication.Tag_Fragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp8440p.myapplication.Adapter.NoiDungLoaiChi_Adapter;
import com.example.hp8440p.myapplication.Adapter.NoiDungLoaiThu_Adapter;
import com.example.hp8440p.myapplication.Oject.NoiDung;
import com.example.hp8440p.myapplication.R;
import com.example.hp8440p.myapplication.database.Database;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class tab_LoaiChi_Fragment extends Fragment {
    public static List<NoiDung> arrayList = new ArrayList<>();
    public static NoiDungLoaiChi_Adapter adapter;
    Database database;
    private ListView listView;
    FloatingActionButton fab;
    TextView txtNgay;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        database = new Database(getActivity());
        View view = inflater.inflate(R.layout.tab_loaithu_fragment,container,false);
         fab = view.findViewById(R.id.fabloaithu);
        @SuppressLint("ResourceType") Animation animation = AnimationUtils.loadAnimation(getActivity(), R.animator.rotate);
        fab.startAnimation(animation);
        listView = view.findViewById(R.id.lvloaiThu);
        getDataList(listView);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               dialogThem(listView);

            }
        });


        return view;
    }
    public void dialogThem(final ListView lv) {
        final Dialog dialog = new Dialog(getActivity());
        database = new Database(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_them_loaithu);

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
//        animation.setDuration(10);
//        animation.hasEnded();
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
//
                // lấy thông tin nhâập
                   NoiDung nd = new NoiDung(noidung,soTien,theLoai,nGay,ghiChu);
                //id, noi dung, so tien, the loai, ngay, ghi chu
                arrayList.add(nd);
                    if(database.addDataLC(nd) > 0 ){
                        if (nd.getNoiDung().toString().equals("") &&
                                nd.getGhiChu().toString().equals("")&&
                                nd.getNgay().toString().equals("")&&
                                nd.getTheLoai().toString().equals("")&&
                                nd.getSoTien().toString().equals("")){
                            Toast.makeText(getActivity(), "Dữ liệu trống. Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getActivity(), "Thêm dữ liệu thành công", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getActivity(), "Thêm dữ liệu thất bại", Toast.LENGTH_SHORT).show();
                    }
                getDataList(lv);
                dialog.cancel();

            }
        });
    }
    public void getDataList(ListView lv){
        database = new Database(getActivity());
        adapter = new NoiDungLoaiChi_Adapter(database.getDataLC(), this,R.layout.item_loaichi_fragment, lv);
        lv.setAdapter(adapter);
    }
}





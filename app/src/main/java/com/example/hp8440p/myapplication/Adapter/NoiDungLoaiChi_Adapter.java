package com.example.hp8440p.myapplication.Adapter;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp8440p.myapplication.Oject.NoiDung;
import com.example.hp8440p.myapplication.R;
import com.example.hp8440p.myapplication.Tag_Fragment.tab_LoaiChi_Fragment;
import com.example.hp8440p.myapplication.Tag_Fragment.tab_LoaiThu_Fragment;
import com.example.hp8440p.myapplication.database.Database;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class NoiDungLoaiChi_Adapter extends BaseAdapter {
    public static List<NoiDung> loaiChiList;
    private tab_LoaiChi_Fragment mCcontext;
    private int layout;
    private ListView mListView;
    EditText txtNhapNgay;
    Database db;
    public NoiDungLoaiChi_Adapter(List<NoiDung> loaiThuList, tab_LoaiChi_Fragment context, int layout, ListView lv) {
        this.loaiChiList = loaiThuList;
        this.mCcontext = context;
        this.layout = layout;
        this.mListView = lv;
    }

    @Override
    public int getCount() {
        return loaiChiList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    public static class ViewHolder{
        ImageView btnEdit,btnDelete;
        TextView noiDung,Sotien,Theloai,Ngay,Ghichu;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        db = new Database(mCcontext.getActivity());
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) mCcontext.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.noiDung = (TextView) view.findViewById(R.id.txtLoaiSpLoaiThu);
            holder.Sotien = view.findViewById(R.id.txtSoTien);
            holder.Ghichu = view.findViewById(R.id.txtGhiChu);
            holder.Ngay = view.findViewById(R.id.txtNgay);
            holder.Theloai = view.findViewById(R.id.txtTheLoai);
            holder.btnDelete= (ImageView) view.findViewById(R.id.btnDeleteLoaithu);
            holder.btnEdit = (ImageView) view.findViewById(R.id.btnEditLoaithu);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder)view.getTag();
        }
        final NoiDung noiDung = loaiChiList.get(i);
        holder.noiDung.setText(noiDung.getNoiDung());
        holder.Sotien.setText(""+(noiDung.getSoTien()));
        holder.Theloai.setText(noiDung.getTheLoai());
        holder.Ngay.setText(noiDung.getNgay());
        holder.Ghichu.setText(noiDung.getGhiChu());
//        Bat Su kien Delete
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final NoiDung nd = (NoiDung) loaiChiList.get(i);
//                Toast.makeText(mCcontext.getActivity(), "" + nd.getNoiDung() + nd.getIdNoiDung(), Toast.LENGTH_SHORT).show();
                final AlertDialog.Builder dialogXoa = new AlertDialog.Builder(mCcontext.getActivity());
                dialogXoa.setMessage("Bnaj có muốn xóa dữ liệu không?");
                dialogXoa.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        db.QueryData("DELETE FROM LoaiChi WHERE id = " + nd.getIdNoiDung() + " ");
                        Toast.makeText(mCcontext.getActivity(), "Xóa dữ liệu thành công", Toast.LENGTH_SHORT).show();
                        mCcontext.getDataList(mListView);
                    }
                });
                dialogXoa.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                dialogXoa.show();
            }
        });
        // bat su kien edit
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(mCcontext.getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                 dialog.setContentView(R.layout.dialog_update);
                Window window = dialog.getWindow();
                WindowManager.LayoutParams wlp = window.getAttributes();
                wlp.gravity = Gravity.CENTER;
                wlp.flags &= ~WindowManager.LayoutParams.FLAG_BLUR_BEHIND;
                window.setAttributes(wlp);
                dialog.getWindow().setLayout( ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
              final EditText txtTenNoiDung = dialog.findViewById(R.id.edittextCvUpdate);
                    final EditText txtSoTien = dialog.findViewById(R.id.edittextSoTienUpdate);
                    final EditText txtTheLoai = dialog.findViewById(R.id.edittextTheLoaiUpdate);
                    final EditText txtGhiChu = dialog.findViewById(R.id.edittextGhiChuUpdate);
                      txtNhapNgay = dialog.findViewById(R.id.edittextNhapNgayUpdate);
                Button btnGetDate = dialog.findViewById(R.id.btnDate);
                btnGetDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        txtNhapNgay = dialog.findViewById(R.id.edittextNhapNgayUpdate);
                        final Calendar cl = Calendar.getInstance();
                        int day = cl.get(Calendar.DATE);
                        int month = cl.get(Calendar.MONTH);
                        int year = cl.get(Calendar.YEAR);
                        DatePickerDialog datePickerDialog = new DatePickerDialog(mCcontext.getActivity(), new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                cl.set(i,i1,i2);
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                txtNhapNgay.setText(simpleDateFormat.format(cl.getTime()));
                            }
                        }, year,month,day);
                        datePickerDialog.show();
                    }

                });
              txtTenNoiDung.setText(noiDung.getNoiDung());
                txtSoTien.setText(String.valueOf(noiDung.getSoTien()));
                txtTheLoai.setText(noiDung.getTheLoai());
                txtGhiChu.setText(noiDung.getGhiChu());
                txtNhapNgay.setText(noiDung.getNgay());
              Button btnHuy = dialog.findViewById(R.id.btnHuyUpdate);
              btnHuy.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      dialog.cancel();
                  }
              });
              Button btnUpdate = dialog.findViewById(R.id.btnUpdate);
              btnUpdate.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                     final String noidungNew = txtTenNoiDung.getText().toString();
                            String SoTienNew = txtSoTien.getText().toString();
                            String TheLoaiNew = txtTheLoai.getText().toString();
                            String GhiChuNew = txtGhiChu.getText().toString();
                            String NgayNew = txtNhapNgay.getText().toString();
                   db.QueryData("UPDATE LoaiChi SET noiDung= '"+noidungNew+"',soTien= '"+SoTienNew+"' WHERE Id = '"+ noiDung.getIdNoiDung()+"' ");
                      db.QueryData("UPDATE LoaiChi SET soTien= '"+SoTienNew+"' WHERE Id = '"+ noiDung.getIdNoiDung()+"' ");
                      db.QueryData("UPDATE LoaiChi SET theLoai= '"+TheLoaiNew+"' WHERE Id = '"+ noiDung.getIdNoiDung()+"' ");
                      db.QueryData("UPDATE LoaiChi SET ngay= '"+NgayNew+"' WHERE Id = '"+ noiDung.getIdNoiDung()+"' ");
                      db.QueryData("UPDATE LoaiChi SET note= '"+GhiChuNew+"' WHERE Id = '"+ noiDung.getIdNoiDung()+"' ");
                      Toast.makeText(mCcontext.getActivity(), "Sửa thành công", Toast.LENGTH_SHORT).show();
                      dialog.cancel();
                      mCcontext.getDataList(mListView);
                  }
              });
              dialog.show();
            }
        });
        return  view;
    }


}

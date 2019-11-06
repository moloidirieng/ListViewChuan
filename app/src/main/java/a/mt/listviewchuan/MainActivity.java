package a.mt.listviewchuan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtMa;
    private EditText edtName;
    private EditText edtDate;
    private RadioButton rbtMale;
    private RadioButton rbtFemale;



    private Button btnAdd;
    private Button btnSave;
    private Button btnEdit;
    private Button btnCancel;

    // tinh thanh
    private String[]dsTinhThanh;
    private ArrayAdapter<String > adapterTinhThanh;
    private AutoCompleteTextView autoTinh;

    // tinh thanh
    private String[]dsQuanHuyen;
    private ArrayAdapter<String > adapterQuanHuyen;
    private AutoCompleteTextView autoQuanHuyen;

    // tinh thanh
    private String[]dsPhuongXa;
    private ArrayAdapter<String > adapterPhuongXa;
    private AutoCompleteTextView autoPhuongXa;

    private EditText edtAddress;

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
    private Calendar calendar;
    private int day,month,year;
    private Date date;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addLoadData();
        addEvent();

    }

    private void addLoadData() {
        dsTinhThanh=getResources().getStringArray(R.array.dsTinhThanh);
        adapterTinhThanh=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,dsTinhThanh);
        autoTinh.setAdapter(adapterTinhThanh);

        // danh sach quan huyen
        dsQuanHuyen=getResources().getStringArray(R.array.dsQuanHuyenHaNoi);
        adapterQuanHuyen=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,dsQuanHuyen);
        autoQuanHuyen.setAdapter(adapterQuanHuyen);

        // danh sach phường xa
        dsPhuongXa=getResources().getStringArray(R.array.dsPhuongXa);
        adapterPhuongXa=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,dsPhuongXa);
        autoPhuongXa.setAdapter(adapterPhuongXa);

        String sdate="01/01/1984";

        try {
             date=dateFormat.parse(sdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        int ngay= Integer.parseInt(sdate.substring(0,2).toString());
//        int thang=Integer.parseInt(sdate.substring(3,5).toString());
//        int nam=Integer.parseInt(sdate.substring(6).toString());
//
//        calendar=Calendar.getInstance();
//        calendar.set(nam,thang,ngay);
     //   edtDate.setText(dateFormat.format(date));
        edtDate.setText(sdate);
       // Toast.makeText(this, ""+ngay+"/"+thang+"/"+nam, Toast.LENGTH_SHORT).show();


    }

    private void addEvent() {
        btnAdd.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnEdit.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        edtDate.setOnClickListener(this);
    }

    private void addControls() {
        edtName=findViewById(R.id.edtName);
        edtDate =findViewById(R.id.edtDate);
        rbtFemale =findViewById(R.id.rbtFemale);
        rbtMale =findViewById(R.id.rbtMale);
        autoTinh=findViewById(R.id.autoTinh);
        autoPhuongXa=findViewById(R.id.autoPhuongXa);
        autoQuanHuyen=findViewById(R.id.autoQuanHuyen);
        edtAddress=findViewById(R.id.edtSoNha);
        edtMa=findViewById(R.id.edtMa);

        btnAdd=findViewById(R.id.btnAdd);
        btnSave=findViewById(R.id.btnSave);
        btnEdit=findViewById(R.id.btnEdit);
        btnCancel=findViewById(R.id.btnCancel);





    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAdd:
                //todo
                break;
            case R.id.btnSave:
                //todo
                break;
            case R.id.btnEdit:
                //todo
                break;
            case R.id.btnCancel:
                //todo
                break;
            case R.id.edtDate:
                //todo


                ChoiceDay();
                break;
            default:
                break;
        }

    }

    private Calendar ChoiceDay() {
         calendar=Calendar.getInstance();
         day=calendar.get(Calendar.DAY_OF_MONTH);
         month=calendar.get(Calendar.MONTH);
         year=calendar.get(Calendar.YEAR);
         datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
             @Override
             public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                 calendar.set(year,month,dayOfMonth);
                 edtDate.setText(dateFormat.format(calendar.getTime()));

             }
         },year,month,day);
         datePickerDialog.show();
         return calendar;
    }


}

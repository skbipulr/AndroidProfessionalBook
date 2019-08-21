package com.bitm.dateandtimepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Button openDatePickerBtn, openTimePickerBtn;
    private SimpleDateFormat dateAndTimeSDF = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private SimpleDateFormat dateSDF = new SimpleDateFormat("dd MMM yyyy");
    private SimpleDateFormat timeSDF = new SimpleDateFormat("hh:mm aa");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openDatePickerBtn = findViewById(R.id.openDatePickerBtn);
        openTimePickerBtn = findViewById(R.id.openTimePickerBtn);


        openDatePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDatePicker();
            }
        });

        openTimePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTimePicker();
            }
        });
    }

    private void openTimePicker() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_time_picker,null);

        Button doneBtn = view.findViewById(R.id.doneBtn);
        final TimePicker timePicker = view.findViewById(R.id.timePickerID);


        builder.setView(view);

        final Dialog dialog = builder.create();
        dialog.show();

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();
                dialog.dismiss();
                Time time = new Time(hour,minute,0);
                openTimePickerBtn.setText(timeSDF.format(time));
            }
        });



    }

    private void openDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String value = year + "/" + month + "/" + day + " 00:00:00";
                //e.g 2019/3/9 00:00:00

                Date date = null;

                try {
                    date = dateAndTimeSDF.parse(value);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                long fromTime = date.getTime();
                Log.d("Date in MS", "" + fromTime);

                openDatePickerBtn.setText(dateSDF.format(date));


            }
        };

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener, year, month, day);
        datePickerDialog.show();
    }
}

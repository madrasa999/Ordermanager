package com.example.sg772.ordermanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class datePickerFragment extends DialogFragment {
private Date mDate;
public static final String EXTRA_DATE="com.example.sg7720.ordermanager.date";
public static datePickerFragment newInstance(Date date){
    Bundle args=new Bundle();
    args.putSerializable(EXTRA_DATE,date);
    datePickerFragment  dpf= new datePickerFragment();
dpf.setArguments(args);
return dpf;

}
    public Dialog onCreateDialog( Bundle savedInstanceState) {
     mDate=(Date)getArguments().getSerializable(EXTRA_DATE);
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(mDate);
        int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);

        View v=getActivity().getLayoutInflater().inflate(R.layout.ldatepicker_ayout,null);
        DatePicker datePicker=(DatePicker)v.findViewById(R.id.dialog_date_picker);
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {

            public void onDateChanged(DatePicker view, int year, int month, int day) {
                mDate=new GregorianCalendar(year,month,day).getTime();
                getArguments().putSerializable(EXTRA_DATE,mDate);
            }
        });
        return new AlertDialog.Builder(getActivity()).setView(v).
                setTitle(R.string.date_picker_title).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sendResult(Activity.RESULT_OK);
            }
        }).create();
    }
    public void sendResult(int resultCode){
    if (getTargetFragment()==null)
        return;
        Intent i =new Intent();
        i.putExtra(EXTRA_DATE,mDate);
        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, i);

    }
}

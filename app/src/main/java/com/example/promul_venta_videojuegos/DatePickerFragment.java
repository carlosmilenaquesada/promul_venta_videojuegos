package com.example.promul_venta_videojuegos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{
	public DatePickerFragment(){}

	@NonNull
	@Override
	public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){
		super.onCreateDialog(savedInstanceState);
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		return new DatePickerDialog(requireActivity(), this, year, month, day);
	}

	@Override
	public void onDateSet(DatePicker view, int year, int month, int dayOfMonth){
		MainActivity mainActivity = (MainActivity) getActivity();
		assert mainActivity != null;
		mainActivity.crearFecha(year, month, dayOfMonth);
	}
}

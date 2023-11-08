package com.example.promul_venta_videojuegos;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{
	public TimePickerFragment(){
	}

	@NonNull
	@Override
	public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){
		super.onCreateDialog(savedInstanceState);
		Calendar calendar = Calendar.getInstance();
		int hora = calendar.get(Calendar.HOUR);
		int minuto = calendar.get(Calendar.MINUTE);
		return new TimePickerDialog(getActivity(), this, hora, minuto, true);
	}

	@Override
	public void onTimeSet(TimePicker view, int hourOfDay, int minute){
		MainActivity mainActivity = (MainActivity) getActivity();
		assert mainActivity != null;
		mainActivity.crearHora(hourOfDay, minute);
	}
}

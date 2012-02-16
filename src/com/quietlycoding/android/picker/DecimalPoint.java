package com.quietlycoding.android.picker;

import com.quietlycoding.android.picker.NumberPicker.OnChangedListener;

import android.app.Activity;
import android.os.Bundle;



public class DecimalPoint extends Activity implements OnChangedListener {

	private NumberPicker picker;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.decimal_point);
        
        picker =(NumberPicker) findViewById( R.id.number_picker );
        picker.setDecimal(1);
        
        NumberPicker decimal =(NumberPicker) findViewById( R.id.decimal_pos_picker );
        decimal.setOnChangeListener( this);
    }
 
    
    public void onChanged(NumberPicker picker, int oldVal, int newVal ){
    	// Assuming only decimal picker is returning value.
    	this.picker.setDecimal( newVal );
    }
}
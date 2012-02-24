package com.quietlycoding.android.picker;

import com.quietlycoding.android.picker.NumberPicker.OnChangedListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;



public class DecimalPoint extends Activity implements OnClickListener, OnChangedListener {

    private static final String TAG = "NumberPicker";
    
	private NumberPicker picker;
	private NumberPicker decimal_picker;
    private NumberPicker step_picker; 
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.decimal_point);
  
        Log.d(TAG, "Entered DecimalPoint onCreate()" );
        
        picker =(NumberPicker) findViewById( R.id.number_picker );
        picker.setDecimal(1);

    	ViewParent tmp = picker.getParent();
    	Log.d(TAG, "Parent picker: " + tmp  );
    	if ( tmp != null ) 	Log.d(TAG, "Parent picker: " + tmp.toString() );
    	

    	
        Button button =(Button) findViewById( R.id.select_button );
        button.setOnClickListener(this);
        
        decimal_picker =(NumberPicker) findViewById( R.id.decimal_pos_picker );
        decimal_picker.setOnChangeListener( this);

        step_picker =(NumberPicker) findViewById( R.id.step_picker );
        step_picker.setOnChangeListener( this);
}
 
    
    public void onChanged(NumberPicker picker, int oldVal, int newVal ){
    	if ( picker == decimal_picker ) {
    		this.picker.setDecimal( newVal );
    	} else {
        	// Assuming step picker.
    		this.picker.setStep( newVal );   		
    	}
    }

    
    public void onClick(View v ) {
		switch( v.getId() ) {
		case R.id.select_button:
			TextView text =(TextView) findViewById( R.id.display_selection );
			text.setText( "You selected: " + picker.getString() );
			break;
		}
    }
}
package edu.berkeley.cs160.hinasakazaki.prog1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class UnitConverter extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_converter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.unit_converter, menu);
        return true;
    }
    
    
    public void get_data(View v){
    
		EditText inputTextbox = (EditText)findViewById(R.id.inputTextbox);
		double input = Double.valueOf(inputTextbox.getText().toString());
		
		RadioButton miles = (RadioButton)findViewById(R.id.miles);
		RadioButton lbs = (RadioButton)findViewById(R.id.lbs);
		RadioButton F = (RadioButton)findViewById(R.id.F);
		RadioButton C = (RadioButton)findViewById(R.id.c);
		RadioButton kg = (RadioButton)findViewById(R.id.kg);
		RadioButton km = (RadioButton)findViewById(R.id.km);
		
		double returnval = 0;
		String units = ""; 
		String result = "";
		if (miles.isChecked()){
			returnval  =  input*1.609;
			units = "km";
		}
		
		else if (lbs.isChecked()){
			returnval = input/2.2;
			units = "kg";
			
		}
		
		else if (F.isChecked()){
			returnval = (input-32.0) * (5.0/9.0);
			units = "C";
		}
		
		else if (C.isChecked()){
			returnval = (input*1.8)+32.0;
			units = "F";
			
		}
		
		else if (kg.isChecked()){
			returnval = 2.2*input;
			units = "lbs";
		}
		
		else if (km.isChecked()){
			returnval  =  input*0.62137;
			units = "miles";
			
		}
		
		result = Double.toString(returnval);
		
		TextView tv = (TextView)findViewById(R.id.result);
		tv.setText(result);	
    
    	TextView unitonresult = (TextView)findViewById(R.id.unit);
    	unitonresult.setText(units);
    }
}

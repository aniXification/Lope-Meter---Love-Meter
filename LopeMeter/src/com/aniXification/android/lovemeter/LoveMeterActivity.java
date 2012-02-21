package com.aniXification.android.lovemeter;


import com.google.ads.AdRequest;
import com.google.ads.AdView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoveMeterActivity extends Activity implements OnClickListener{
		

	TextView tvName1,tvName2,tvCalculatedLove;
	EditText etName1,etName2;
	Button btnCalculate,btnClear,btnHelp;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        initialize();
        
        btnCalculate.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnHelp.setOnClickListener(this);
        
        /*
		 * add starts
		 * */
		
        AdView adview = (AdView)findViewById(R.id.adView);

        // Initiate a generic request to load it with an ad
        AdRequest re = new AdRequest();
        //re.setTesting(true);
        re.setGender(AdRequest.Gender.MALE); 
        adview.loadAd(re);
		
		/*
		 * add ends
		 * */
        
    }
    
    public void initialize(){
    	tvName1 = (TextView)findViewById(R.id.tvName1);
    	//tvName2 = (TextView)findViewById(R.id.tvName2);
    	tvCalculatedLove = (TextView)findViewById(R.id.tvCalculatedLove);
    	etName1 = (EditText)findViewById(R.id.etName1);
    	etName2 = (EditText)findViewById(R.id.etName2);
    	btnCalculate = (Button)findViewById(R.id.btnCalculate);
    	btnClear = (Button) findViewById(R.id.btnClear);
    	btnHelp = (Button) findViewById(R.id.btnHelp);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnCalculate:
			if (etName1.getText().length() == 0 || etName2.getText().length() == 0){
				Toast.makeText(this, "Please enter both valid names", Toast.LENGTH_LONG).show();
				return;
			} else {
				Editable name1 = etName1.getText();
				Editable name2 = etName2.getText();
				
				/*
				 * LoveCalculator Class
				 * */
				LoveCalulator loveCalculator = new LoveCalulator();
				String calculatedLove = loveCalculator.calculateLove(name1 + "loves" +  name2); //get CalculatedName			
				
				String[] loveData = new String[]{calculatedLove,name1.toString(),name2.toString()};
				
				//send this result to LoveMeterResultActivity
				Bundle basket = new Bundle();
				basket.putStringArray("key", loveData);
				
				Intent intent = new Intent(LoveMeterActivity.this,LoveMeterResultActivity.class);
				intent.putExtras(basket);
				startActivity(intent);
			}
			
			break;
		case R.id.btnClear:
			etName1.setText("");
			etName2.setText("");
			tvCalculatedLove.setText("");
			break;
			
		case R.id.btnHelp:
			Intent intent = new Intent(this, HelpActivity.class);
			startActivity(intent);
			break;

		}
	}
}
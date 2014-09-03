package com.example.createpdfprotect1;

import java.io.FileOutputStream;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class MainActivity extends Activity {
	 String pdfmentah = "/sdcard/pdfprotect/mentah.pdf";
     String pdfEnskrip = "/sdcard/pdfprotect/hasilenc.pdf";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		 
	    
		Button buat = (Button)findViewById(R.id.button1);
		
		buat.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {

					PdfReader reader = new PdfReader(pdfmentah);
			        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(pdfEnskrip));
			        stamper.setEncryption("bejo".getBytes(), "12345".getBytes(),
			            PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_256| PdfWriter.DO_NOT_ENCRYPT_METADATA);
			        stamper.close();
			        reader.close();	
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		
	}


}

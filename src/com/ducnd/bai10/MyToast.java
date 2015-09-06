package com.ducnd.bai10;

import java.util.Random;

import android.content.Context;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MyToast {
	private Toast mToast;
	private Random rd = new Random();
	private Context mContext;
	private int signX, signY;
	private LayoutInflater inflater;
	private TextView textName;
	private ImageView image;
	private int X, Y;
	private int count = 0;
	private RelativeLayout relativeLayout;

	public MyToast(Context context) {
		this.mContext = context;
		inflater = LayoutInflater.from(mContext);
		
		rdSign();
		initToast();

	}

	public void initToast() {
		mToast = new Toast(mContext);
		// mToast = Toast.makeText(mContext, "", Toast.LENGTH_SHORT);
		// set time hien thi
		mToast.setDuration(Toast.LENGTH_SHORT);
		// set vi tri
		rdSign();
		mToast.setGravity(Gravity.FILL, 0, 0);
		// set text
		// mToast.setText("Hello");

		View v = inflater.inflate(R.layout.mtoastxml, null);
		relativeLayout = (RelativeLayout)v.findViewById(R.id.relativelaout);
		textName = (TextView) v.findViewById(R.id.textName);
		image = (ImageView) v.findViewById(R.id.image);
		
		mToast.setView(v);

	}

	public void rdSign() {
		count++;
		int s = rd.nextInt(100);
		signX = s > 50 ? 1 : -1;
		signY = rd.nextInt(100) > 50 ? 1 : -1;
		X = rd.nextInt(700);
		Y = rd.nextInt(1000);
		if (count > 3) {
			if ( count == 10 ) count = 1;
			mToast.setGravity(Gravity.FILL, 0, 0);
			relativeLayout.setX(X);
			relativeLayout.setY(Y);
		}

	}

	public void showToast() {
		mToast.show();
	}

	public void randomNext() {
		int radomImage = rd.nextInt(5);
		switch (radomImage) {
		case 0:
			image.setImageResource(R.drawable.bore);
			textName.setText("Bore");
			break;
		case 1:
			image.setImageResource(R.drawable.cry);
			textName.setText("Cry");
			break;
		case 2:
			image.setImageResource(R.drawable.kiss);
			textName.setText("Kiss");
			break;
		case 3:
			image.setImageResource(R.drawable.monkey);
			textName.setText("Monkey");
			break;
		case 4:
			image.setImageResource(R.drawable.smile);
			textName.setText("Smile");
			break;

		default:
			break;
		}
	}
}

package com.example.sapp14;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class MainActivity extends AppCompatActivity {
    String TAG = "Generate qrcode";
    EditText editText;
    EditText editText1;
    EditText editText2;
    ImageView imageView;
    Button button;
    String inputvalue;
    String inputvalue1;
    String inputvalue2;
    Bitmap bitmap;
    Bitmap bitmap1;
    Bitmap bitmap2;
    QRGEncoder qrgEncoder1;
    QRGEncoder qrgEncoder2;
    QRGEncoder qrgEncoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.qrcode);
        editText = (EditText) findViewById(R.id.edittext);
        editText1=(EditText) findViewById(R.id.edittext1);
        editText2=(EditText) findViewById(R.id.edittext2);
        button = (Button) findViewById(R.id.creatbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputvalue = editText.getText().toString().trim();
                inputvalue1 = editText1.getText().toString().trim();
                inputvalue2 = editText2.getText().toString().trim();
                if (inputvalue.length() > 0 && inputvalue1.length() > 0 && inputvalue2.length() >0 ) {
                    WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
                    Display display = manager.getDefaultDisplay();
                    Point point = new Point();
                    display.getSize(point);
                    int width = point.x;
                    int height = point.y;
                    int smallerdimension = width < height ? width : height;
                    smallerdimension = smallerdimension * 3 / 4;
                    //qrgEncoder = new QRGEncoder(inputvalue, null, QRGContents.Type.TEXT, smallerdimension);
                  // qrgEncoder1 = new QRGEncoder(inputvalue1,null, QRGContents.Type.TEXT, smallerdimension);
                   qrgEncoder2 = new QRGEncoder(inputvalue2,null, QRGContents.Type.TEXT, smallerdimension);
                    try {
                      //  bitmap = qrgEncoder.encodeAsBitmap();
                      //  bitmap1= qrgEncoder1.encodeAsBitmap();
                        bitmap2= qrgEncoder2.encodeAsBitmap();
                        //imageView.setImageBitmap(bitmap);
                        //imageView.setImageBitmap(bitmap1);
                        imageView.setImageBitmap(bitmap2);
                    } catch (WriterException e) {
                        Log.v(TAG, e.toString());

                    }
                } else {
                    editText.setError("required");
                }

            }
        });
    }
}

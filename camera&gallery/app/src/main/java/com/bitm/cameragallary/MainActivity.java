package com.bitm.cameragallary;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageViewID);
    }

    public void openCamera(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,1);

    }

    public void openGallery(View view) {

        Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,2);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode==1 && resultCode == RESULT_OK){

           Bitmap bitmap =  (Bitmap) data.getExtras().get("data");
         // String image = encodeToBase64(bitmap, Bitmap.CompressFormat.JPEG,80);
           imageView.setImageBitmap(bitmap);
        }
        if (requestCode ==2){

          Uri uri= data.getData();
            try {
               Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);

               imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
           // imageView.setImageURI(uri);
        }

    }

    // decodeBase64(employee.getID());

    public static String encodeToBase64(Bitmap image, Bitmap.CompressFormat compressFormat, int quality)
    {
        ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
        image.compress(compressFormat, quality, byteArrayOS);
        return Base64.encodeToString(byteArrayOS.toByteArray(), Base64.DEFAULT);
    }

    public static Bitmap decodeBase64(String input)
    {
        byte[] decodedBytes = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
    }

    //BottomSheet

    public void openBottomSheet(View view) {

        Bundle bundle = new Bundle();
        bundle.putString("name","Anik Roy");
        BottomSheet bottomSheet = new BottomSheet();
        bottomSheet.setArguments(bundle);
        bottomSheet.show(getSupportFragmentManager(),"example");
    }
}

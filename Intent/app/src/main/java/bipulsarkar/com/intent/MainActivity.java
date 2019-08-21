package bipulsarkar.com.intent;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_EXAMPLE = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void click(View view) {

        Intent sendIntent = new Intent(); sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.app_name)));

    }


    public void goToSecondActivity(View view) {
        final Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, REQUEST_CODE_EXAMPLE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==REQUEST_CODE_EXAMPLE){
            if (resultCode == Activity.RESULT_OK){
                final String result = data.getStringExtra(SecondActivity.EXTRA_DATA);
            }
        }
    }

    @Override
    public void onBackPressed() {
        setResult(Activity.RESULT_CANCELED);
        super.onBackPressed();
    }


    // CustomTabsIntent for Chrome Custom Tabs
    public void open_new_tab(View view) {
        String url = "https://www.google.pl/";
        CustomTabsIntent intent = new CustomTabsIntent.Builder()
                .setStartAnimations(MainActivity.this, android.R.anim.slide_out_right, android.R.anim.slide_in_left)
                .setExitAnimations(MainActivity.this, android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right)
                .setCloseButtonIcon(BitmapFactory.decodeResource(getResources(),
                        R.drawable.ic_launcher_background))
                .setToolbarColor(Color.parseColor("#43A047"))
                .enableUrlBarHiding()
                .build();
        intent.launchUrl(MainActivity.this, Uri.parse(url));

    }
}

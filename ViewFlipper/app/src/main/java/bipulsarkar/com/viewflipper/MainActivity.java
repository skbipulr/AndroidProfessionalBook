package bipulsarkar.com.viewflipper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewFlipper = findViewById(R.id.view_flipper);
        TextView textView = new TextView(this);
        textView.setText("Dynamically added TextView");
        textView.setGravity(Gravity.CENTER);

        viewFlipper.addView(textView);

       // viewFlipper.setFlipInterval(2000);
        viewFlipper.startFlipping();
    }

    public void previousView(View v) {
        viewFlipper.setInAnimation(this, android.R.anim.slide_out_right);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.showPrevious();
    }

    public void nextView(View v) {
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
        viewFlipper.showNext();
    }
    }




package bipulsarkar.com.intent;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_DATA = "EXTRA_DATA";

    Button button = findViewById(R.id.button);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent data = new Intent();
                data.putExtra(EXTRA_DATA, "Some interesting data!");
                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });
    }
}

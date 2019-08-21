package bipulsarkar.com.textview;

import android.graphics.Color;
import android.graphics.Typeface;
import android.provider.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        spannable();
        strikethrough();
        relativeSizeSpanAlign();

    }

    public void spannable() {
        TextView spannable_text = findViewById(R.id.text_view);
        String text = "I want THIS and THIS to be colored";

        SpannableString ss = new SpannableString(text);
        SpannableStringBuilder ssb = new SpannableStringBuilder(text);

        ForegroundColorSpan fcsRed = new ForegroundColorSpan(Color.RED);
        ForegroundColorSpan fcsGreen = new ForegroundColorSpan(Color.GREEN);
        BackgroundColorSpan bcsYellow = new BackgroundColorSpan(Color.YELLOW);

        ssb.setSpan(fcsRed, 7, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssb.setSpan(fcsGreen, 16, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssb.setSpan(bcsYellow, 27, 34, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        ssb.append(" and this to be appended");

        spannable_text.setText(ssb);
    }

    public void strikethrough() {
        TextView strikethrough_textView = findViewById(R.id.strikethrough_TextView);
        String st_text = "BOLD and ITALIC and BOLD-ITALIC and UNDERLINE and STRIKE-THROUGH";

        SpannableString ss = new SpannableString(st_text);

        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        StyleSpan italicSpan = new StyleSpan(Typeface.ITALIC);
        StyleSpan boldItalicSpan = new StyleSpan(Typeface.BOLD_ITALIC);
        UnderlineSpan underlineSpan = new UnderlineSpan();
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();

        ss.setSpan(boldSpan, 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(italicSpan, 9, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(boldItalicSpan, 20, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(underlineSpan, 36, 45, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(strikethroughSpan, 50, 64, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        strikethrough_textView.setText(ss);

    }

    public void relativeSizeSpanAlign() {
        TextView txtView = (TextView) findViewById(R.id.txtView);
        SpannableString spannableString = new SpannableString("RM123.456");
        spannableString.setSpan(new TopAlignSuperscriptSpan((float) 0.35), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        txtView.setText(spannableString);

    }

}

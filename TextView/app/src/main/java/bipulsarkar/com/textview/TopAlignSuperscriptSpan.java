package bipulsarkar.com.textview;

import android.text.TextPaint;
import android.text.style.SuperscriptSpan;

public class TopAlignSuperscriptSpan extends SuperscriptSpan {

    //divide superscript by this number
    protected int fontScale = 2;
    //shift value, 0 to 1.0
    protected float shiftPercentage = 0;

    //doesn't shift
    TopAlignSuperscriptSpan() {
    }

    //sets the shift percentage
    TopAlignSuperscriptSpan(float shiftPercentage) {
        if (shiftPercentage > 0.0 && shiftPercentage < 1.0)
            this.shiftPercentage = shiftPercentage;
    }

    @Override
    public void updateDrawState(TextPaint tp) {
        //original ascent
        float ascent = tp.ascent();
        //scale down the font
        tp.setTextSize(tp.getTextSize() / fontScale);
        //get the new font ascent
        float newAscent = tp.getFontMetrics().ascent;
        //move baseline to top of old font, then move down size of new font
        // adjust for errors with shift percentage
        tp.baselineShift += (ascent - ascent * shiftPercentage) - (newAscent - newAscent * shiftPercentage);
    }

    @Override
    public void updateMeasureState(TextPaint tp) {
        updateDrawState(tp);
    }

}

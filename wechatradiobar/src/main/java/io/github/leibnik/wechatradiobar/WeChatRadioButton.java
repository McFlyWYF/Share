package io.github.leibnik.wechatradiobar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.StaticLayout;
import android.util.AttributeSet;

/**
 * Created by Droidroid on 2016/5/10.
 */
public class WeChatRadioButton extends android.support.v7.widget.AppCompatRadioButton {

    private Paint mFocusPaint;
    private Paint mTextPaint;
    private Paint mDeFocusPaint;

    private int iconWidth;
    private int iconPadding;
    private int iconHeight;

    private Bitmap mDeFocusBitmap;
    private Bitmap mFocusBitmap;

    private int mAlpha;
    private int mColor;
    private float mFontHeight;
    private float mTextWidth;

    public WeChatRadioButton(Context context) {
        this(context, null);
    }

    public WeChatRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mFocusPaint = new Paint();
        mTextPaint = new Paint();
        mDeFocusPaint = new Paint();
        mFocusPaint.setAntiAlias(true);
        mTextPaint.setAntiAlias(true);
        mDeFocusPaint.setAntiAlias(true);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.WeChatRadioButton);
        Drawable mFocusDrawable = ta.getDrawable(R.styleable.WeChatRadioButton_focus_icon);
        Drawable mDeFocusDrawable = ta.getDrawable(R.styleable.WeChatRadioButton_defocus_icon);
        mColor = ta.getColor(R.styleable.WeChatRadioButton_focus_color, Color.BLUE);
        ta.recycle();

        setButtonDrawable(null);
        if (mDeFocusDrawable != null) {
            setCompoundDrawablesWithIntrinsicBounds(null, mDeFocusDrawable, null, null);
            mDeFocusDrawable = getCompoundDrawables()[1];
        }

        if (mFocusDrawable == null || mDeFocusDrawable == null) {
            throw new RuntimeException("'focus_icon' and 'defocus_icon' attributes should be defined");
        }

        iconWidth = mDeFocusDrawable.getIntrinsicWidth();
        iconHeight = mDeFocusDrawable.getIntrinsicHeight();

        mDeFocusDrawable.setBounds(0, 0, iconWidth, iconHeight);
        mFocusDrawable.setBounds(0, 0, iconWidth, iconHeight);

        iconPadding = getCompoundDrawablePadding();

        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        mFontHeight = (float) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        mTextWidth = StaticLayout.getDesiredWidth(getText(), getPaint());

        mDeFocusBitmap = getBitmapFromDrawable(mDeFocusDrawable);
        mFocusBitmap = getBitmapFromDrawable(mFocusDrawable);

        if (isChecked()) {
            mAlpha = 255;
        }
    }

    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(iconWidth, iconHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        if (drawable instanceof BitmapDrawable) {
            drawable.draw(canvas);
            return bitmap;
        } else {
            throw new RuntimeException("The Drawable must be an instance of BitmapDrawable");
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawDeFocusIcon(canvas);
        drawFocusIcon(canvas);
        drawDeFocusText(canvas);
        drawFocusText(canvas);
    }

    private void drawDeFocusIcon(Canvas canvas) {
        mDeFocusPaint.setAlpha(255 - mAlpha);
        canvas.drawBitmap(mDeFocusBitmap, (getWidth() - iconWidth) / 2, getPaddingTop(), mDeFocusPaint);
    }

    private void drawFocusIcon(Canvas canvas) {
        mFocusPaint.setAlpha(mAlpha);
        canvas.drawBitmap(mFocusBitmap, (getWidth() - iconWidth) / 2, getPaddingTop(), mFocusPaint);
    }

    private void drawDeFocusText(Canvas canvas) {
        mTextPaint.setColor(getCurrentTextColor());
        mTextPaint.setAlpha(255 - mAlpha);
        mTextPaint.setTextSize(getTextSize());
        canvas.drawText(getText().toString(), getWidth() / 2 - mTextWidth / 2
                , iconHeight + iconPadding + getPaddingTop() + mFontHeight, mTextPaint);
    }

    private void drawFocusText(Canvas canvas) {
        mTextPaint.setColor(mColor);
        mTextPaint.setAlpha(mAlpha);
        canvas.drawText(getText().toString(), getWidth() / 2 - mTextWidth / 2
                , iconHeight + iconPadding + getPaddingTop() + mFontHeight, mTextPaint);
    }


    public void updateAlpha(float alpha) {
        mAlpha = (int) alpha;
        invalidate();
    }

    public void setRadioButtonChecked(boolean isChecked) {
        setChecked(isChecked);
        if (isChecked) {
            mAlpha = 255;
        } else {
            mAlpha = 0;
        }
        invalidate();
    }

}

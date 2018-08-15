/*
 * Copyright (C) 2016 ceryle
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vplibs.colorimagebottomnav;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class NavigationItem extends LinearLayout {
    public NavigationItem(Context context) {
        super(context);
        this.init(null);
    }

    public NavigationItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public NavigationItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.init(attrs);
    }

    private void init(AttributeSet attrs) {
        getAttributes(attrs);

        initViews();

        setDrawableGravity();
        setState();

        super.setPadding(0, 0, 0, 0);
        setPaddingAttrs();
    }

    private AppCompatImageView imageView;
    private AppCompatTextView textView;

    private void initViews() {
        setLayoutParams(new LayoutParams(0, LayoutParams.MATCH_PARENT, 1));
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER);

        imageView = new AppCompatImageView(getContext());
        imageView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT) {{
            gravity = Gravity.CENTER;
        }});
        setDrawableAttrs();
        addView(imageView);

        textView = new AppCompatTextView(getContext());
        textView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT) {{
            gravity = Gravity.CENTER;
        }});
        setTextAttrs();
        addView(textView);
    }

    private Typeface defaultTypeface, textTypeface;

    private String text, textTypefacePath;

    private int textStyle, textSize, drawable, drawableTint, drawableTintTo, textColor, textColorTo, drawableWidth,
            drawableHeight, selectorColor, padding, paddingLeft, paddingRight, paddingTop, paddingBottom, drawablePadding,
            backgroundColor, textGravity;

    private boolean hasPaddingLeft, hasPaddingRight, hasPaddingTop, hasPaddingBottom, hasDrawableTint, hasTextTypefacePath,
            hasDrawable, hasText, hasDrawableWidth, hasDrawableHeight, checked, enabled, hasEnabled, clickable, hasClickable,
            hasTextStyle, hasTextSize, hasTextColor, textFillSpace, hasSelectorColor,
            hasDrawableTintTo, hasTextColorTo;

    /***
     * GET ATTRIBUTES FROM XML
     */
    private void getAttributes(AttributeSet attrs) {
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.NavigationItem);

        drawable = ta.getResourceId(R.styleable.NavigationItem_item_drawable, -1);
        drawableTint = ta.getColor(R.styleable.NavigationItem_item_drawableTint, 0);
        drawableTintTo = ta.getColor(R.styleable.NavigationItem_item_drawableTintTo, 0);
        drawableWidth = ta.getDimensionPixelSize(R.styleable.NavigationItem_item_drawableWidth, -1);
        drawableHeight = ta.getDimensionPixelSize(R.styleable.NavigationItem_item_drawableHeight, -1);

        hasDrawable = ta.hasValue(R.styleable.NavigationItem_item_drawable);
        hasDrawableTint = ta.hasValue(R.styleable.NavigationItem_item_drawableTint);
        hasDrawableTintTo = ta.hasValue(R.styleable.NavigationItem_item_drawableTintTo);
        hasDrawableWidth = ta.hasValue(R.styleable.NavigationItem_item_drawableWidth);
        hasDrawableHeight = ta.hasValue(R.styleable.NavigationItem_item_drawableHeight);

        text = ta.getString(R.styleable.NavigationItem_item_text);
        hasText = ta.hasValue(R.styleable.NavigationItem_item_text);
        textColor = ta.getColor(R.styleable.NavigationItem_item_textColor, Color.BLACK);
        textColorTo = ta.getColor(R.styleable.NavigationItem_item_textColorTo, Color.BLACK);

        hasTextColor = ta.hasValue(R.styleable.NavigationItem_item_textColor);
        hasTextColorTo = ta.hasValue(R.styleable.NavigationItem_item_textColorTo);
        textSize = ta.getDimensionPixelSize(R.styleable.NavigationItem_item_textSize, -1);
        hasTextSize = ta.hasValue(R.styleable.NavigationItem_item_textSize);
        textStyle = ta.getInt(R.styleable.NavigationItem_item_textStyle, -1);
        hasTextStyle = ta.hasValue(R.styleable.NavigationItem_item_textStyle);

        int typeface = ta.getInt(R.styleable.NavigationItem_item_textTypeface, -1);
        switch (typeface) {
            case 0:
                textTypeface = Typeface.MONOSPACE;
                break;
            case 1:
                textTypeface = Typeface.DEFAULT;
                break;
            case 2:
                textTypeface = Typeface.SANS_SERIF;
                break;
            case 3:
                textTypeface = Typeface.SERIF;
                break;
        }
        textTypefacePath = ta.getString(R.styleable.NavigationItem_item_textTypefacePath);
        hasTextTypefacePath = ta.hasValue(R.styleable.NavigationItem_item_textTypefacePath);

        backgroundColor = ta.getColor(R.styleable.NavigationItem_item_backgroundColor, Color.TRANSPARENT);

        int defaultPadding = Helper.dpToPx(getContext(), 10);
        padding = ta.getDimensionPixelSize(R.styleable.NavigationItem_android_padding, defaultPadding);
        paddingLeft = ta.getDimensionPixelSize(R.styleable.NavigationItem_android_paddingLeft, 0);
        paddingRight = ta.getDimensionPixelSize(R.styleable.NavigationItem_android_paddingRight, 0);
        paddingTop = ta.getDimensionPixelSize(R.styleable.NavigationItem_android_paddingTop, 0);
        paddingBottom = ta.getDimensionPixelSize(R.styleable.NavigationItem_android_paddingBottom, 0);

        hasPaddingLeft = ta.hasValue(R.styleable.NavigationItem_android_paddingLeft);
        hasPaddingRight = ta.hasValue(R.styleable.NavigationItem_android_paddingRight);
        hasPaddingTop = ta.hasValue(R.styleable.NavigationItem_android_paddingTop);
        hasPaddingBottom = ta.hasValue(R.styleable.NavigationItem_android_paddingBottom);

        drawablePadding = ta.getDimensionPixelSize(R.styleable.NavigationItem_item_drawablePadding, 4);

        drawableGravity = DrawableGravity.getById(ta.getInteger(R.styleable.NavigationItem_item_drawableGravity, 0));

        checked = ta.getBoolean(R.styleable.NavigationItem_item_checked, false);

        enabled = ta.getBoolean(R.styleable.NavigationItem_android_enabled, true);
        hasEnabled = ta.hasValue(R.styleable.NavigationItem_android_enabled);
        clickable = ta.getBoolean(R.styleable.NavigationItem_android_clickable, true);
        hasClickable = ta.hasValue(R.styleable.NavigationItem_android_clickable);

        textGravity = ta.getInt(R.styleable.NavigationItem_item_textGravity, Gravity.NO_GRAVITY);

        textFillSpace = ta.getBoolean(R.styleable.NavigationItem_item_textFillSpace, false);

        selectorColor = ta.getColor(R.styleable.NavigationItem_item_selectorColor, Color.TRANSPARENT);
        hasSelectorColor = ta.hasValue(R.styleable.NavigationItem_item_selectorColor);

        ta.recycle();
    }

    public int getTextColorTo() {
        return textColorTo;
    }

    public void setTextColorTo(int textColorTo) {
        this.textColorTo = textColorTo;
    }

    public boolean hasTextColorTo() {
        return hasTextColorTo;
    }

    public boolean hasTextColor() {
        return hasTextColor;
    }

    public void setHasTextColor(boolean hasTextColor) {
        this.hasTextColor = hasTextColor;
    }

    public void setHasTextColorTo(boolean hasTextColorTo) {
        this.hasTextColorTo = hasTextColorTo;
    }

    public boolean hasDrawableTintTo() {
        return hasDrawableTintTo;
    }

    public void setHasDrawableTintTo(boolean hasDrawableTintTo) {
        this.hasDrawableTintTo = hasDrawableTintTo;
    }

    public int getDrawableTintTo() {
        return drawableTintTo;
    }

    public void setDrawableTintTo(int drawableTintTo) {
        this.drawableTintTo = drawableTintTo;
    }

    public int getSelectorColor() {
        return selectorColor;
    }

    public void setSelectorColor(int selectorColor) {
        this.selectorColor = selectorColor;
        onSelectorColorChangedListener.onSelectorColorChanged(position, selectorColor);
    }

    public boolean hasSelectorColor() {
        return hasSelectorColor;
    }

    private OnSelectorColorChangedListener onSelectorColorChangedListener;
    private int position;

    void setOnSelectorColorChangedListener(OnSelectorColorChangedListener onSelectorColorChangedListener, int position) {
        this.onSelectorColorChangedListener = onSelectorColorChangedListener;
        this.position = position;
    }

    interface OnSelectorColorChangedListener {
        void onSelectorColorChanged(int position, int selectorColor);
    }

    public boolean hasEnabled() {
        return hasEnabled;
    }

    public boolean hasClickable() {
        return hasClickable;
    }

    private void setDrawableAttrs() {
        if (hasDrawable) {
            imageView.setImageResource(drawable);
            if (hasDrawableTint)
                imageView.setColorFilter(drawableTint);

            if (hasDrawableWidth)
                setDrawableWidth(drawableWidth);
            if (hasDrawableHeight)
                setDrawableHeight(drawableHeight);
        } else {
            imageView.setVisibility(GONE);
        }
    }

    private void setDrawableGravity() {
        if (!hasDrawable)
            return;

        if (drawableGravity == DrawableGravity.LEFT || drawableGravity == DrawableGravity.TOP) {
            if (getChildAt(0) instanceof AppCompatTextView) {
                removeViewAt(0);
                addView(textView, 1);

                if (textFillSpace) {
                    LayoutParams params = (LayoutParams) textView.getLayoutParams();
                    params.weight = 0;
                    params.width = LayoutParams.WRAP_CONTENT;
                }
            }
        } else {
            if (getChildAt(0) instanceof AppCompatImageView) {
                removeViewAt(0);
                addView(imageView, 1);

                if (textFillSpace) {
                    LayoutParams params = (LayoutParams) textView.getLayoutParams();
                    params.weight = 1;
                    params.width = 0;
                }
            }
        }

        if (hasText && hasDrawable)
            if (drawableGravity == DrawableGravity.TOP || drawableGravity == DrawableGravity.BOTTOM)
                setOrientation(VERTICAL);
            else
                setOrientation(HORIZONTAL);
    }

    private void setTextAttrs() {
        defaultTypeface = textView.getTypeface();

        textView.setText(text);

        int gravity;

        if (textGravity == 2) {
            gravity = Gravity.END;
        } else if (textGravity == 1) {
            gravity = Gravity.CENTER;
        } else {
            gravity = Gravity.START;
        }

        textView.setGravity(gravity);

        if (hasTextColor)
            textView.setTextColor(textColor);
        if (hasTextSize)
            setTextSizePX(textSize);
        if (hasTextTypefacePath)
            setTypeface(textTypefacePath);
        else if (null != textTypeface) {
            setTypeface(textTypeface);
        }
        if (hasTextStyle)
            setTextStyle(textStyle);
    }

    private void setPaddingAttrs() {
        if (hasPaddingBottom || hasPaddingTop || hasPaddingLeft || hasPaddingRight)
            setPaddings(paddingLeft, paddingTop, paddingRight, paddingBottom);
        else
            setPaddings(padding, padding, padding, padding);
    }

    /**
     * GRAVITY
     */

    private DrawableGravity drawableGravity;

    public enum DrawableGravity {
        LEFT(0),
        TOP(1),
        RIGHT(2),
        BOTTOM(3);

        private int intValue;

        DrawableGravity(int intValue) {
            this.intValue = intValue;
        }

        private int getIntValue() {
            return intValue;
        }

        public static DrawableGravity getById(int id) {
            for (DrawableGravity e : values()) {
                if (e.intValue == id) return e;
            }
            return null;
        }

        public boolean isHorizontal() {
            return intValue == 0 || intValue == 2;
        }
    }

    /**
     * TEXT VIEW
     */
    public AppCompatTextView getTextView() {
        return textView;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;

        textView.setTextColor(textColor);
    }

    void setCheckedTextColor(int color) {
        textView.setTextColor(color);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;

        textView.setText(text);
    }

    public void setTextSizePX(int size) {
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }

    public void setTextSizeSP(float size) {
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }

    public int getTextSize() {
        return textSize;
    }

    public int getTextStyle() {
        return textStyle;
    }

    public void setTextStyle(int typeface) {
        textView.setTypeface(textView.getTypeface(), typeface);
    }

    public void restoreTypeface() {
        textView.setTypeface(defaultTypeface);
    }

    public String getTypefacePath() {
        return textTypefacePath;
    }

    /**
     * Typeface.NORMAL: 0
     * Typeface.BOLD: 1
     * Typeface.ITALIC: 2
     * Typeface.BOLD_ITALIC: 3
     *
     * @param typeface you can use above variations using the bitwise OR operator
     */
    public void setTypeface(Typeface typeface) {
        textView.setTypeface(typeface);
    }

    public void setTypeface(String location) {
        if (null != location && !location.equals("")) {
            Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), location);
            textView.setTypeface(typeface);
        }
    }

    public Typeface getDefaultTypeface() {
        return defaultTypeface;
    }

    /**
     * PADDING
     */
    public int getPadding() {
        return padding;
    }

    public void setPaddings(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom) {
        this.paddingLeft = paddingLeft;
        this.paddingTop = paddingTop;
        this.paddingRight = paddingRight;
        this.paddingBottom = paddingBottom;

        updatePaddings();
    }

    private void updatePaddings() {
        if (hasText)
            updatePadding(textView, hasDrawable);

        if (hasDrawable)
            updatePadding(imageView, hasText);
    }

    private void updatePadding(View view, boolean hasOtherView) {
        if (null == view)
            return;

        int[] paddings = {paddingLeft, paddingTop, paddingRight, paddingBottom};

        if (hasOtherView) {
            int g = drawableGravity.getIntValue();
            if (view instanceof AppCompatImageView) {
                g = g > 1 ? g - 2 : g + 2;
            }
            paddings[g] = drawablePadding / 2;
        }

        MarginLayoutParams params = (MarginLayoutParams) view.getLayoutParams();
        params.setMargins(paddings[0], paddings[1], paddings[2], paddings[3]);
    }

    @Override
    public int getPaddingLeft() {
        return paddingLeft;
    }

    @Override
    public int getPaddingRight() {
        return paddingRight;
    }

    @Override
    public int getPaddingTop() {
        return paddingTop;
    }

    @Override
    public int getPaddingBottom() {
        return paddingBottom;
    }

    public boolean hasPaddingLeft() {
        return hasPaddingLeft;
    }

    public boolean hasPaddingRight() {
        return hasPaddingRight;
    }

    public boolean hasPaddingTop() {
        return hasPaddingTop;
    }

    public boolean hasPaddingBottom() {
        return hasPaddingBottom;
    }

    /**
     * DRAWABLE
     */
    public AppCompatImageView getImageView() {
        return imageView;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        imageView.setImageDrawable(drawable);
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;

        imageView.setImageResource(drawable);
    }

    public int getDrawableTint() {
        return drawableTint;
    }

    public void setDrawableTint(int color) {
        this.drawableTint = color;

        imageView.setColorFilter(color);
    }

    void setCheckedDrawableTint(int color) {
        imageView.setColorFilter(color);
    }

    public boolean hasDrawableTint() {
        return hasDrawableTint;
    }

    public void setDrawableTint(boolean hasColor) {
        this.hasDrawableTint = hasColor;

        if (hasColor)
            imageView.setColorFilter(drawableTint);
        else
            imageView.clearColorFilter();
    }

    public int getDrawableWidth() {
        return drawableWidth;
    }

    public void setDrawableWidth(int drawableWidth) {
        this.drawableWidth = drawableWidth;

        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        if (null != params) {
            params.width = drawableWidth;
        }
    }

    public int getDrawableHeight() {
        return drawableHeight;
    }

    public void setDrawableHeight(int drawableHeight) {
        this.drawableHeight = drawableHeight;

        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        if (null != params) {
            params.height = drawableHeight;
        }
    }

    public void setDrawableSizeByPx(int width, int height) {
        this.drawableWidth = width;
        this.drawableHeight = height;

        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        if (null != params) {
            params.width = width;
            params.height = height;
        }
    }

    public void setDrawableSizeByDp(int width, int height) {
        width = Helper.dpToPx(getContext(), width);
        height = Helper.dpToPx(getContext(), height);
        setDrawableSizeByPx(width, height);
    }

    public DrawableGravity getDrawableGravity() {
        return drawableGravity;
    }

    public void setDrawableGravity(DrawableGravity gravity) {
        this.drawableGravity = gravity;

        setDrawableGravity();
        setPaddingAttrs();
    }

    public int getDrawablePadding() {
        return drawablePadding;
    }

    public void setDrawablePadding(int drawablePadding) {
        this.drawablePadding = drawablePadding;
        updatePaddings();
    }

    private void setEnabledAlpha(boolean enabled) {
        float alpha = 1f;
        if (!enabled)
            alpha = 0.5f;
        setAlpha(alpha);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setClickable(enabled);
        this.enabled = enabled;
        setEnabledAlpha(enabled);
    }

    @Override
    public void setClickable(boolean clickable) {
        super.setClickable(clickable);
        this.clickable = clickable;
    }

    private void setState() {
        if (hasEnabled)
            setEnabled(enabled);
        else
            setClickable(clickable);
    }

    @Override
    public boolean isClickable() {
        return clickable;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isChecked() {
        return checked;
    }
}

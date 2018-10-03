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

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;

class Helper {

    static float pxToDp(final Context context, final float px) {
        return px / context.getResources().getDisplayMetrics().density;
    }

    static int dpToPx(final Context context, final float dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    static void makeRound(View view, int dividerColor, int dividerRadius, Integer dividerSize) {
        GradientDrawable gradient = getGradientDrawable(dividerColor, dividerRadius, dividerSize);
        view.setBackground(gradient);
    }

    static void makeDividerRound(LinearLayout layout, int dividerColor, int dividerRadius, Integer dividerSize) {
        GradientDrawable gradient = getGradientDrawable(dividerColor, dividerRadius, dividerSize);
        layout.setDividerDrawable(gradient);
    }

    private static GradientDrawable getGradientDrawable(int dividerColor, int dividerRadius, Integer dividerSize) {
        GradientDrawable gradient =
                new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{dividerColor, dividerColor});
        gradient.setShape(GradientDrawable.RECTANGLE);
        gradient.setCornerRadius(dividerRadius);
        if (null != dividerSize)
            gradient.setSize(dividerSize, 0);
        return gradient;
    }
}

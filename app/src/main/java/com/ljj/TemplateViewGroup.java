package com.ljj;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * @author : fengzili on
 * @email : 291924028@qq.com
 * @date : 2018/12/17 0017
 * @pkn : ${PACKAGE}
 * @desc :
 */

public class TemplateViewGroup extends RelativeLayout {
    public TemplateViewGroup(Context context) {
        this(context, null);
    }

    public TemplateViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TemplateViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }
}

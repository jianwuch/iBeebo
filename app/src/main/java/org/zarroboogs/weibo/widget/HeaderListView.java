
package org.zarroboogs.weibo.widget;

import org.zarroboogs.utils.AppLoggerUtils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class HeaderListView extends ListView {

    private boolean inTouch = false;

    private ArrayList<View> headerList = new ArrayList<View>();

    public HeaderListView(Context context) {
        super(context);
    }

    public HeaderListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HeaderListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                boolean result = super.dispatchTouchEvent(event);
                if (result) {
                    inTouch = true;
                }
                return result;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                inTouch = false;
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    public boolean isInTouchByUser() {
        AppLoggerUtils.e("" + inTouch);
        return inTouch;
    }

    @Override
    public void addHeaderView(View v, Object data, boolean isSelectable) {
        super.addHeaderView(v, data, isSelectable);
        headerList.add(v);
    }

    @Override
    public boolean removeHeaderView(View v) {
        boolean result = super.removeHeaderView(v);
        headerList.remove(v);
        return result;
    }

    public boolean isThisViewHeader(View v) {
        return headerList.contains(v);
    }
}

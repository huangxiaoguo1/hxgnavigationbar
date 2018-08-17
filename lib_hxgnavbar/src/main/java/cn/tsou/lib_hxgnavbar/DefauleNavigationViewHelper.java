package cn.tsou.lib_hxgnavbar;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;

/**
 * Created by 黄家三少 on 2018/7/7.
 */

public class DefauleNavigationViewHelper {
    //防止侧漏
    private SparseArray<WeakReference<View>> mViews;
    private ViewGroup mParent;
    private Context mContext;

    public DefauleNavigationViewHelper(Context context, ViewGroup parent) {
        mViews = new SparseArray<>();
        this.mParent = parent;
        this.mContext = context;
    }

    /**
     * 设置文本
     *
     * @param viewId
     * @param text
     */
    public void setText(int viewId, CharSequence text) {
        //减少findviewbyid的次数
        TextView tv = getView(viewId);
        if (!TextUtils.isEmpty(text) && tv != null) {
            tv.setVisibility(View.VISIBLE);
            tv.setText(text);
        }
    }

    /**
     * 设置View的显示和隐藏
     *
     * @param viewId
     * @param aBoolean
     */
    public void setShowView(int viewId, Boolean aBoolean) {
        View view = getView(viewId);
        if (view != null) {
            if (aBoolean) {
                view.setVisibility(View.VISIBLE);
            } else {
                view.setVisibility(View.GONE);
            }
        }
    }

    public <T extends View> T getView(int viewId) {
        WeakReference<View> weakReference = mViews.get(viewId);
        View view = null;
        if (weakReference != null) {
            view = weakReference.get();
        }
        if (view == null) {
            view = findViewById(viewId);
            if (view != null)
                mViews.put(viewId, new WeakReference<View>(view));
        }
        return (T) view;
    }


    private <M extends View> M findViewById(int viewId) {
        if (mParent != null)
            return (M) mParent.findViewById(viewId);
        return null;
    }

    /**
     * 设置点击
     *
     * @param viewId
     * @param listener
     */
    public void setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        if (view != null) {
            view.setOnClickListener(listener);
        }
    }

    /**
     * 点击关闭
     *
     * @param viewId
     */
    public void setOnFinishClickListener(int viewId) {
        View view = getView(viewId);
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((Activity) mContext).finish();
                }
            });
        }
    }

    /**
     * 设置图片
     *
     * @param viewId
     * @param imageResId
     */
    public void setImage(int viewId, int imageResId) {
        ImageView view = getView(viewId);
        if (view != null) {
            view.setImageResource(imageResId);
        }
    }


}

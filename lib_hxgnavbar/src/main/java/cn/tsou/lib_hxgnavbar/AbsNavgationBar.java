package cn.tsou.lib_hxgnavbar;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.ref.WeakReference;

/**
 * Created by 黄家三少 on 2018/7/5.
 */

public abstract class AbsNavgationBar<T extends AbsNavgationBar.Builder.AbsNavigationParams> implements INavgationBar {

    private T mParams;

    public AbsNavgationBar(T params) {
        this.mParams = params;
        createAndBindView();
    }

    /**
     * 获取布局
     *
     * @return
     */
    public T getParams() {
        return mParams;
    }

    /**
     * 绑定和创建View
     */
    private void createAndBindView() {
        if (bindLayoutId() == 0) {
            throw new IllegalArgumentException("请先传入布局—>setContentView方法");
        }
        if (mParams.mParent == null) {
            //获取Activity跟布局,(AppCompatActivity)
            ViewGroup activityRoot = ((Activity) mParams.mContext)
                    .findViewById(android.R.id.content);
            mParams.mParent = (ViewGroup) activityRoot.getChildAt(0);
        }
        if (mParams.mParent == null) {
            return;
        }
        View navigationView = LayoutInflater.from(mParams.mContext)
                .inflate(bindLayoutId(), mParams.mParent, false);
        //添加到页面布局根部
        mParams.mParent.addView(navigationView, 0);
        applyView();
    }


    public abstract static class Builder {

        public Builder(Context context, ViewGroup parent) {

        }

        public abstract AbsNavgationBar build();

        public static class AbsNavigationParams {

            public Context mContext;
            public ViewGroup mParent;

            public AbsNavigationParams(Context context, ViewGroup parent) {
                this.mContext = context;
                this.mParent = parent;
            }
        }
    }
}

package cn.tsou.lib_hxgnavbar;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by 黄家三少 on 2018/7/7.
 */

public class DefaultNavigationBar extends AbsNavgationBar<DefaultNavigationBar.Builder.DefaultNavigationParams> {


    private DefauleNavigationViewHelper viewHelper;

    public DefaultNavigationBar(Builder.DefaultNavigationParams params) {
        super(params);
    }


    @Override
    public int bindLayoutId() {
        return getParams().mLayoutId;
    }

    @Override
    public boolean addShowStatusBar() {
        return getParams().mStatusBar;
    }

    /**
     * 获得view对象
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId) {
        return viewHelper.getView(viewId);
    }

    @Override
    public void applyView() {
        viewHelper = new DefauleNavigationViewHelper(getParams().mContext, getParams().mParent);
        //设置内容
        for (int i = 0; i < getParams().mTextArray.size(); i++) {
            viewHelper.setText(getParams().mTextArray.keyAt(i), getParams().mTextArray.valueAt(i));
        }
        //设置View的显示和隐藏
        for (int i = 0; i < getParams().mTextShowArray.size(); i++) {
            viewHelper.setShowView(getParams().mTextShowArray.keyAt(i), getParams().mTextShowArray.valueAt(i));
        }
        //设置View的显示和隐藏
        for (int i = 0; i < getParams().mTextColor.size(); i++) {
            viewHelper.setTextColor(getParams().mTextColor.keyAt(i), getParams().mTextColor.valueAt(i));
        }
        //设置点击事件
        for (int i = 0; i < getParams().mClickArray.size(); i++) {
            viewHelper.setOnClickListener(getParams().mClickArray.keyAt(i), getParams().mClickArray.valueAt(i));
        }
        //设置点击关闭
        for (int i = 0; i < getParams().mFinishClickArray.size(); i++) {
            viewHelper.setOnFinishClickListener(getParams().mFinishClickArray.get(i));
        }
        //设置图片
        for (int i = 0; i < getParams().mImageArray.size(); i++) {
            viewHelper.setImage(getParams().mImageArray.keyAt(i), getParams().mImageArray.valueAt(i));
        }
        //设置顶部状态栏
        if (getParams().mStatusBar) {
            viewHelper.setStatusBar(R.id.view_statusbar, getParams().mStatusBarColor);
        }
    }


    public static class Builder extends AbsNavgationBar.Builder {

        DefaultNavigationParams P;

        /**
         * @param context
         * @param parent  (ViewGroup) findViewById(R.id.view_group)
         */
        public Builder(Context context, ViewGroup parent) {
            super(context, parent);
            P = new DefaultNavigationParams(context, parent);
        }

        public Builder(Context context) {
            super(context, null);
            P = new DefaultNavigationParams(context, null);
        }

        @Override
        public DefaultNavigationBar build() {
            DefaultNavigationBar navigationBar = new DefaultNavigationBar(P);
            return navigationBar;
        }

        /**
         * 设置布局
         *
         * @param layoutId
         * @return
         */
        public Builder setContentView(int layoutId) {
            P.mLayoutId = layoutId;
            return this;
        }

        /**
         * 是否显示顶部状态栏
         *
         * @param isShowStatusBar
         * @return
         */
        public Builder setShowStatusBar(boolean isShowStatusBar) {
            P.mStatusBar = isShowStatusBar;
            return this;
        }

        /**
         * 设置顶部状态栏的颜色
         *
         * @param color
         * @return
         */
        public Builder setStatusBarColor(int color) {
            P.mStatusBarColor = color;
            return this;
        }

        /**
         * 设置效果
         */
        //设置标题
        public Builder setTitle(int viewId, CharSequence text) {
            P.mTextArray.put(viewId, text);
            return this;
        }

        //设置标题
        public Builder setTitle(int viewId, int textResId) {
            P.mTextArray.put(viewId, P.mContext.getString(textResId));
            return this;
        }

        //设置View的显示和隐藏
        public Builder setShowView(int viewId, boolean isShow) {
            P.mTextShowArray.put(viewId, isShow);
            return this;
        }

        //设置View颜色
        public Builder setTextColor(int viewId, int color) {
            P.mTextColor.put(viewId, color);
            return this;
        }

        //设置图片
        public Builder setImage(int viewId, int imageResId) {
            P.mImageArray.put(viewId, imageResId);
            return this;
        }

        //设置点击事件
        public Builder setOnClickListener(int viewId, View.OnClickListener listener) {
            P.mClickArray.put(viewId, listener);
            return this;
        }

        public Builder setOnFinishClickListener(int viewId) {
            P.mFinishClickArray.add(viewId);
            return this;
        }


        public static class DefaultNavigationParams extends AbsNavgationBar.Builder.AbsNavigationParams {
            /**
             * 放置参数
             */
            public int mLayoutId = 0;
            public boolean mStatusBar = false;
            public int mStatusBarColor = android.R.color.white;
            //存放字体的修改
            public SparseArray<CharSequence> mTextArray = new SparseArray<>();
            //设置View的显示和隐藏
            public SparseArray<Boolean> mTextShowArray = new SparseArray<>();
            //设置View的颜色
            public SparseArray<Integer> mTextColor = new SparseArray<>();
            //存放点击事件
            public SparseArray<View.OnClickListener> mClickArray = new SparseArray<>();
            //点击关闭
            public ArrayList<Integer> mFinishClickArray = new ArrayList();
            //设置图片
            public SparseArray<Integer> mImageArray = new SparseArray();

            //所有效果
            public DefaultNavigationParams(Context context, ViewGroup parent) {
                super(context, parent);
            }
        }
    }
}

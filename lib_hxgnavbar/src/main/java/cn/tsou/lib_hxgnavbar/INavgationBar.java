package cn.tsou.lib_hxgnavbar;

/**
 * Created by 黄家三少 on 2018/7/5.
 */

public interface INavgationBar {
    /**
     * 头部布局
     *
     * @return
     */
    int bindLayoutId();

    /**
     * 显示顶部导航栏
     *
     * @return
     */
    boolean addShowStatusBar();

    /**
     * 绑定头部的参数
     */
    void applyView();
}

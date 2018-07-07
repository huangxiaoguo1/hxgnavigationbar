package cn.tsou.lib_hxgnavbar;

/**
 * Created by 黄家三少 on 2018/7/5.
 */

public interface INavgationBar {
    /**
     * 头部布局
     * @return
     */
    public int bindLayoutId();

    /**
     * 绑定头部的参数
     */
    public void applyView();
}

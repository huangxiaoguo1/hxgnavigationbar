package cn.tsou.hxgnavigationbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import cn.tsou.lib_hxgnavbar.DefaultNavigationBar;

public class MainActivity extends AppCompatActivity {

    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtil.setStatusBarTranslucent(this, false);
        DefaultNavigationBar build = new DefaultNavigationBar.Builder(this, (ViewGroup) findViewById(R.id.view_group))
                .setContentView(R.layout.activity_titlebar)
                .setShowStatusBar(true)
                .setStatusBarColor(R.color.red)
                .setTitle(R.id.title_text, "我是标题")
                .setTextColor(R.id.right_text, R.color.colorPrimary)
                .setTitle(R.id.right_text, R.string.test_1)
                .setOnFinishClickListener(R.id.top_back)
                .setImage(R.id.image_btn, R.mipmap.ic_launcher_round)
                .setImage(R.id.image, R.mipmap.ic_launcher_round)
                .setShowView(R.id.image_btn, false)
                .setOnClickListener(R.id.right_text, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "点击了右边", Toast.LENGTH_LONG).show();
                        title.setText("点击改变");
                    }
                })
                .build();
        title = build.getView(R.id.title_text);
    }
}

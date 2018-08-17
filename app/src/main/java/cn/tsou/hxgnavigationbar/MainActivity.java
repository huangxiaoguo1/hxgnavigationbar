package cn.tsou.hxgnavigationbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import cn.tsou.lib_hxgnavbar.DefaultNavigationBar;

import static cn.tsou.hxgnavigationbar.R.attr.title;

public class MainActivity extends AppCompatActivity {

    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DefaultNavigationBar build = new DefaultNavigationBar.Builder(this)
                .setContentView(R.layout.activity_titlebar)
                .setTitle(R.id.title_text, "我是标题")
                .setTitle(R.id.right_text, R.string.test_1)
                .setOnFinishClickListener(R.id.top_back)
                .setImage(R.id.image_btn, R.mipmap.ic_launcher_round)
                .setImage(R.id.image, R.mipmap.ic_launcher_round)
                .setShowView(R.id.image_btn,false)
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

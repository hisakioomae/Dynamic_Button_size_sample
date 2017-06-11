package jp.app.oomae.hisaki.dynamic_button_sample;



import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager mPager;
    private TabLayout tabLayout;
    private Viewpager_Adapter pagerAdapter;
    private LinearLayout linearLayout;
    private int linear_width;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tablayoutの実装
        String[] tabs_names = getResources().getStringArray(R.array.tabs);//xmlファイルから配列取得
        tabLayout = (TabLayout) findViewById(R.id.tabs);//tablayoutのid取得
        mPager = (ViewPager) findViewById(R.id.viewpager);//viewpagerのid取得
        pagerAdapter = new Viewpager_Adapter(getSupportFragmentManager(), tabs_names);//作成したfragmentとviewpagerのadapterを作成
        mPager.setAdapter(pagerAdapter);//viewpagerにfragmentをセット
        mPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));//tablayoutでも移動できるようにする
        tabLayout.setupWithViewPager(mPager);//tablayoutとviewpagerの連携

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {//ページがposition番号になったときに起動
                button = (Button)findViewById(R.id.button1);
                editText = (EditText)findViewById(R.id.edittext1);
                if (position == 0) {
                    editText.setLayoutParams(new LinearLayout.LayoutParams(0,0));
                    button.setLayoutParams(new LinearLayout.LayoutParams(0,0));
                } else if (position == 1) {
                    editText.setLayoutParams(new LinearLayout.LayoutParams((int)((linear_width/10)*0),getActionBarHeight()));
                    button.setLayoutParams(new LinearLayout.LayoutParams((int)((linear_width/10)*10),getActionBarHeight()));
                } else if (position == 2){
                    editText.setLayoutParams(new LinearLayout.LayoutParams((int)((linear_width/10)*5),getActionBarHeight()));
                    button.setLayoutParams(new LinearLayout.LayoutParams((int)((linear_width/10)*5),getActionBarHeight()));
                } else if (position == 3){
                    editText.setLayoutParams(new LinearLayout.LayoutParams((int)((linear_width/10)*8),getActionBarHeight()));
                    button.setLayoutParams(new LinearLayout.LayoutParams((int)((linear_width/10)*2),getActionBarHeight()));
                } else if (position == 4){
                    editText.setLayoutParams(new LinearLayout.LayoutParams((int)((linear_width/10)*10),getActionBarHeight()));
                    button.setLayoutParams(new LinearLayout.LayoutParams((int)((linear_width/10)*0),getActionBarHeight()));
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override//LinearLayoutの大きさを取得する(※onCreateではできない)
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        linearLayout = (LinearLayout)findViewById(R.id.linear);
        linear_width = linearLayout.getWidth();
    }

    private int getActionBarHeight() {
        int actionBarHeight = getSupportActionBar().getHeight();
        if (actionBarHeight != 0)
            return actionBarHeight;
        final TypedValue tv = new TypedValue();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
                actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
        } else if (getTheme().resolveAttribute(jp.app.oomae.hisaki.dynamic_button_sample.R.attr.actionBarSize, tv, true))
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
        return actionBarHeight;
    }
}

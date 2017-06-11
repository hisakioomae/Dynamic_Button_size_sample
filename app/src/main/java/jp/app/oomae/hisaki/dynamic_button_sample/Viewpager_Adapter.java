package jp.app.oomae.hisaki.dynamic_button_sample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import jp.app.oomae.hisaki.dynamic_button_sample.Fragment.Fragment1;
import jp.app.oomae.hisaki.dynamic_button_sample.Fragment.Fragment2;
import jp.app.oomae.hisaki.dynamic_button_sample.Fragment.Fragment3;
import jp.app.oomae.hisaki.dynamic_button_sample.Fragment.Fragment4;
import jp.app.oomae.hisaki.dynamic_button_sample.Fragment.Fragment5;

/**
 * Created by hisaki on 2017/06/11.
 */

public class Viewpager_Adapter extends FragmentPagerAdapter {
    int numberOfTabs;

    private String tabTitles[];

    public Viewpager_Adapter(FragmentManager fm, String[] tabTitles){
        super(fm);
        this.tabTitles = tabTitles;
        numberOfTabs = tabTitles.length;
    }

    @Override public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Fragment1();
            case 1:
                return new Fragment2();
            case 2:
                return new Fragment3();
            case 3:
                return new Fragment4();
            case 4:
                return new Fragment5();
        }
        return null;
    }
    @Override public int getCount() {
        return numberOfTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}

package jp.app.oomae.hisaki.dynamic_button_sample.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jp.app.oomae.hisaki.dynamic_button_sample.R;

/**
 * Created by hisaki on 2017/06/11.
 */

public class Fragment3 extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.layout3, container, false);
        return view;
    }
}

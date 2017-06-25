package vn.eazy.studio.core.delegate;

import android.os.Bundle;

import vn.eazy.studio.core.di.component.AppComponent;


/**
 * Created by harryle on 6/18/17.
 */

public interface IActivity {
    /**
     *
     * @param appComponent
     */
    void setupActivityComponent(AppComponent appComponent);

    /**
     * @param savedInstanceState
     * @return
     */
    int initView(Bundle savedInstanceState);

    /**
     * @param savedInstanceState
     */
    void initData(Bundle savedInstanceState);
}

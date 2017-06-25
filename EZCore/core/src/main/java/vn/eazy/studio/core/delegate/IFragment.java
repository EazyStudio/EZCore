package vn.eazy.studio.core.delegate;

import android.os.Bundle;

import vn.eazy.studio.core.di.component.AppComponent;

/**
 * Created by harryle on 6/20/17.
 */

public interface IFragment {
    /**
     *
     * @param appComponent
     */
    void setupFragmentComponent(AppComponent appComponent);

    /**
     *
     * @return
     */
    boolean useEventBus();

    /**
     *
     * @param savedInstanceState
     */
    void initData(Bundle savedInstanceState);

}

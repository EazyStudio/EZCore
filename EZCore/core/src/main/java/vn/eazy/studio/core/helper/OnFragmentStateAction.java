package vn.eazy.studio.core.helper;


import android.support.v4.app.Fragment;

/**
 * Created by Harry on 12/24/16.
 */

public interface OnFragmentStateAction {

    void setStacksRootFragment(Fragment... fragments);

    void changeRootFragment(Fragment fragments, int stackId);

    boolean isRootFragment();

    void pushFragment(Fragment fragment);

    void pushFragmentKeepOld(Fragment fragment);

    void popFragment(int numberPop);

    void showStack(int stackId);

    void refreshStack(int stackId);

    void replaceFragment(Fragment fragment);

    void clearStack(int stackId);

    void clearAllStacks();

}

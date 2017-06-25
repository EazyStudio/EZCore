package vn.eazy.studio.core.helper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import java.util.List;



/**
 * Created by Harry on 12/24/16.
 */

public interface OnFragmentAction {
    void replaceFragment(int id, Fragment baseFragment);

    void replaceFragment(int id, Fragment baseFragment, Bundle bundle);

    void replaceFragment(Fragment baseFragment);
    void replaceFragment(Fragment baseFragment, boolean isBackStack, int InAnim, int OutAnim);

    void replaceFragment(Fragment baseFragment, Bundle bundle);

    void replaceFragment(int id, Fragment fragment, boolean isBackStack);

    void replaceFragmentWithSharedElement(Fragment baseFragment, List<View> views);

    void addFragment(Fragment baseFragment);

    void addFragment(Fragment baseFragment, boolean isBackStack);

    void addFragmentWithSharedElement(Fragment baseFragment, List<View> views);

    void popBackStack();

    void removeFragment(Fragment fragment);

    int getSizeFragmentManager();

    void clearAllFragments();

    Fragment getLastFragment();
}

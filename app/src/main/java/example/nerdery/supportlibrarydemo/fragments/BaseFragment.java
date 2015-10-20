package example.nerdery.supportlibrarydemo.fragments;
import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by sbastin on 10/15/15.
 */

/**
 * Created by sbastin on 8/17/15.
 */
public class BaseFragment extends Fragment {
    /**
     * Generic newinstance method to work for all fragments
     */
    public static <T extends android.support.v4.app.Fragment> T newInstance(Class<T> fragmentType) {
        try {
            return fragmentType.newInstance();
        } catch (Exception e) {
            //NOTE: Intentionally do nothing
        }
        return null;
    }
}

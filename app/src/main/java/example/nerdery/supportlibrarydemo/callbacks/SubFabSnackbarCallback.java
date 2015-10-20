package example.nerdery.supportlibrarydemo.callbacks;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.TypedValue;

import java.util.ArrayList;

/**
 * Created by sbastin on 10/20/15.
 */
public class SubFabSnackbarCallback extends Snackbar.Callback{
    private ArrayList<FloatingActionButton> buttons;
    private CoordinatorLayout layout;
    private Context context;
    private int SNACKBAR_HEIGHT ;

    public SubFabSnackbarCallback(CoordinatorLayout layout, ArrayList<FloatingActionButton> buttons, Context context){
        this.layout = layout;
        this.buttons = buttons;
        this.context = context;
        SNACKBAR_HEIGHT = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48, context.getResources().getDisplayMetrics());
    }

    @Override
    public void onShown(Snackbar snackbar) {

        for(FloatingActionButton b : buttons) {
            CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams)b.getLayoutParams();
            params.bottomMargin += SNACKBAR_HEIGHT;
            b.setLayoutParams(params);
        }
    }

    @Override
    public void onDismissed(Snackbar snackbar, int event) {
        for(FloatingActionButton b : buttons) {
            CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams)b.getLayoutParams();
            params.bottomMargin -= SNACKBAR_HEIGHT;
            b.setLayoutParams(params);
        }
    }
}

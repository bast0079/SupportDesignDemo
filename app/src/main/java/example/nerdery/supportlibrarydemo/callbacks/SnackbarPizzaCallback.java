package example.nerdery.supportlibrarydemo.callbacks;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

/**
 * Created by sbastin on 10/15/15.
 */
public class SnackbarPizzaCallback extends Snackbar.Callback {
    private Context context;

    public SnackbarPizzaCallback(Context context){
        this.context = context;
    }
    @Override
    public void onDismissed(Snackbar snackbar, int event) {
        if(event == Snackbar.Callback.DISMISS_EVENT_TIMEOUT){
            Toast.makeText(context, "You snooze, you lose, Brochacho.", Toast.LENGTH_LONG).show();
        }
    }
}

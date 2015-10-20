package example.nerdery.supportlibrarydemo.listeners;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * Created by sbastin on 10/15/15.
 */
public class SnackbarActionListener implements View.OnClickListener {
    private Context mContext;
    public SnackbarActionListener(Context context){
        mContext = context;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(mContext, "Nice. You stay munchin'", Toast.LENGTH_SHORT).show();
    }
}

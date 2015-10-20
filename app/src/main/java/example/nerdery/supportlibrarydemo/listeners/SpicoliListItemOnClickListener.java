package example.nerdery.supportlibrarydemo.listeners;

import android.app.Activity;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import example.nerdery.supportlibrarydemo.R;
import example.nerdery.supportlibrarydemo.ui.SpicoliDetailsActivity;

/**
 * Created by sbastin on 10/19/15.
 */
public class SpicoliListItemOnClickListener implements View.OnClickListener{
    private Activity context;

    public SpicoliListItemOnClickListener(Activity context){
        this.context = context;
    }
    @Override
    public void onClick(View v) {
        TextView titleView = (TextView)v.findViewById(R.id.spicoli_list_item_title_text_view);
        TextView descView = (TextView)v.findViewById(R.id.spicoli_list_item_description_text_view);
        ImageView imageView = (ImageView)v.findViewById(R.id.spicoli_list_item_image_view);
        Intent intent = new Intent(context, SpicoliDetailsActivity.class);

        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                context,
                new Pair<View, String>(titleView, SpicoliDetailsActivity.TRANSITION_NAME_TITLE),
                new Pair<View, String>(descView, SpicoliDetailsActivity.TRANSITION_NAME_DESC),
                new Pair<View, String>(imageView, SpicoliDetailsActivity.TRANSITION_NAME_IMAGE));

        String title = titleView.getText().toString();
        String desc = descView.getText().toString();
        int image = getImageResourceId(title);
        intent.putExtra(SpicoliDetailsActivity.TITLE_KEY, title);
        intent.putExtra(SpicoliDetailsActivity.DESC_KEY, desc);
        intent.putExtra(SpicoliDetailsActivity.IMAGE_KEY, image);

        ActivityCompat.startActivity(context, intent, activityOptions.toBundle());
    }

    private int getImageResourceId(String title){
        if(title.equals("Spicoli is fine.")){
            return R.drawable.spicoli_smirk;
        }else{
            return R.drawable.spicoli_sad_pizza;
        }
    }


}

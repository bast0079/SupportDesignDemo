package example.nerdery.supportlibrarydemo.adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import example.nerdery.supportlibrarydemo.R;
import example.nerdery.supportlibrarydemo.listeners.SpicoliListItemOnClickListener;
import example.nerdery.supportlibrarydemo.models.Spicoli;
import example.nerdery.supportlibrarydemo.ui.SpicoliDetailsActivity;

/**
 * Created by sbastin on 10/19/15.
 */
public class SpicoliAdapter extends RecyclerView.Adapter<SpicoliAdapter.ViewHolder> {
    private ArrayList<Spicoli> mSpicoliList;
    private Activity context;

    public SpicoliAdapter(Activity context, ArrayList<Spicoli> spicolis) {
        mSpicoliList = spicolis;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView titleView;
        public TextView descView;

        public ViewHolder(View v) {
            super(v);

            imageView = (ImageView) v.findViewById(R.id.spicoli_list_item_image_view);
            titleView = (TextView) v.findViewById(R.id.spicoli_list_item_title_text_view);
            descView = (TextView) v.findViewById(R.id.spicoli_list_item_description_text_view);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.spicoli_list_item, parent, false);
        v.setOnClickListener(new SpicoliListItemOnClickListener(context));
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Spicoli spicoli = mSpicoliList.get(position);

        if(spicoli.getIsFine()){
            holder.imageView.setImageResource(R.drawable.spicoli_happy_circle);
            holder.titleView.setText("Spicoli is fine.");
            holder.descView.setText("He has both a cool buzz, and some tasty waves.");
        }
        else{
            holder.imageView.setImageResource(R.drawable.spicoli_sad_circle);
            holder.titleView.setText("Spicoli is not fine.");
            holder.descView.setText("Our man doesn't have a buzz or he is missing some tasty waves.");
        }

    }

    @Override
    public int getItemCount() {
        return mSpicoliList.size();
    }

}

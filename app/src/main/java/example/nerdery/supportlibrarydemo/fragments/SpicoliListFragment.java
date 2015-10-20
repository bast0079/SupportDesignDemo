package example.nerdery.supportlibrarydemo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import example.nerdery.supportlibrarydemo.R;
import example.nerdery.supportlibrarydemo.adapters.SpicoliAdapter;
import example.nerdery.supportlibrarydemo.models.Spicoli;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by sbastin on 10/15/15.
 */
public class SpicoliListFragment extends BaseFragment {

    @InjectView(R.id.spicoli_frame_layout) FrameLayout mFrameLayout;
    @InjectView(R.id.spicoli_recycler_view) RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spicoli_list, container, false);
        ButterKnife.inject(this, view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new SpicoliAdapter(getActivity(), getSpicolis()));

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private ArrayList<Spicoli> getSpicolis() {
        ArrayList<Spicoli> jeffs = new ArrayList<>();
        jeffs.add(new Spicoli(true, true));
        jeffs.add(new Spicoli(false, true));
        jeffs.add(new Spicoli(true, false));
        jeffs.add(new Spicoli(false, false));
        jeffs.add(new Spicoli(true, true));
        jeffs.add(new Spicoli(false, true));
        jeffs.add(new Spicoli(true, false));
        jeffs.add(new Spicoli(false, false));
        jeffs.add(new Spicoli(true, true));
        jeffs.add(new Spicoli(false, true));
        jeffs.add(new Spicoli(true, false));
        jeffs.add(new Spicoli(false, false));
        jeffs.add(new Spicoli(true, true));
        jeffs.add(new Spicoli(false, true));
        jeffs.add(new Spicoli(true, false));
        jeffs.add(new Spicoli(false, false));

        return jeffs;
    }

}
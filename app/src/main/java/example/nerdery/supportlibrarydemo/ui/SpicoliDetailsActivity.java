package example.nerdery.supportlibrarydemo.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import example.nerdery.supportlibrarydemo.R;

public class SpicoliDetailsActivity extends AppCompatActivity {
    @InjectView(R.id.toolbar) Toolbar mToolbar;
    @InjectView(R.id.spicoli_details_title_text_view) TextView mTitleTextView;
    @InjectView(R.id.spicoli_detail_desc_text_view) TextView mDescTextView;
    @InjectView(R.id.spicoli_details_image_view) ImageView mImageView;


    public static final String TRANSITION_NAME_IMAGE = "TRANSITION_IMAGE";
    public static final String TRANSITION_NAME_TITLE = "TRANSITION_TITLE";
    public static final String TRANSITION_NAME_DESC = "TRANSITION_DESC";

    public static final String IMAGE_KEY = "IMAGE_KEY";
    public static final String TITLE_KEY = "TITLE_KEY";
    public static final String DESC_KEY = "DESC_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spicoli_details);
        ButterKnife.inject(this);
        initializeToolbar();
        initializeTransitionElements();
        initializeWidgets(getIntent().getExtras());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initializeToolbar(){
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if(supportActionBar !=  null){
            supportActionBar.setHomeAsUpIndicator(R.mipmap.ic_menu_drawer);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initializeTransitionElements(){
        ViewCompat.setTransitionName(mTitleTextView, TRANSITION_NAME_TITLE);
        ViewCompat.setTransitionName(mDescTextView, TRANSITION_NAME_DESC);
        ViewCompat.setTransitionName(mImageView, TRANSITION_NAME_IMAGE);
    }

    private void initializeWidgets(Bundle extras){
        mTitleTextView.setText(extras.getString(TITLE_KEY));
        mDescTextView.setText(extras.getString(DESC_KEY));
        mImageView.setImageDrawable(getResources().getDrawable(extras.getInt(IMAGE_KEY)));
    }

}

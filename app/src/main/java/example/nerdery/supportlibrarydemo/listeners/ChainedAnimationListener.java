package example.nerdery.supportlibrarydemo.listeners;

import android.support.design.widget.FloatingActionButton;
import android.view.animation.Animation;

/**
 * Created by sbastin on 10/19/15.
 */
public class ChainedAnimationListener implements Animation.AnimationListener {
    private FloatingActionButton currentButton;
    private FloatingActionButton nextButton;
    private Animation nextAnimation;
    private int visibility;

    public ChainedAnimationListener(FloatingActionButton currentButton, FloatingActionButton nextButton, Animation nextAnimation, int visibility){
        this.currentButton = currentButton;
        this.nextButton = nextButton;
        this.nextAnimation = nextAnimation;
        this.visibility = visibility;
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if(nextAnimation != null){
            nextButton.startAnimation(nextAnimation);
        }
        currentButton.setVisibility(visibility);

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}

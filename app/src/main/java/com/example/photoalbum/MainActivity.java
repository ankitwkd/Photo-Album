package com.example.photoalbum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.icu.text.CaseMap;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Fragment Variables.
    UpperFragment upperFragment;
    LowerFragment lowerFragment;
    private SlideshowFragment slideshowFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Wiring
        upperFragment = new UpperFragment().newInstance(null, null);
        lowerFragment = new LowerFragment().newInstance(null, null);
        this.slideshowFragment = SlideshowFragment.newInstance(null, null);

        //Adding Fragemnts to the main container
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragmentContainerView3, upperFragment).addToBackStack(null);
        transaction.add(R.id.fragmentContainerView4, lowerFragment);
        transaction.commit();
    }

    public void nextImage() {
        upperFragment.nextImage();
    }

    public void prevImage() {
        upperFragment.prevImage();
    }

    //enables slideshow of the images.
    public void enableSlideShow() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView3, this.slideshowFragment)
                .addToBackStack("tag")
                .commit();
    }

    //To go back to the original Fragment.
    public void disableSlideShow() {
        getSupportFragmentManager().popBackStackImmediate();
    }

    public void enableBtn(String buttonType) {
        if (buttonType.equalsIgnoreCase("Next")) {
            lowerFragment.nextBtn.setClickable(true);
            lowerFragment.nextBtn.setAlpha(1);
        } else if (buttonType.equalsIgnoreCase("Prev")) {
            lowerFragment.prevBtn.setClickable(true);
            lowerFragment.prevBtn.setAlpha(1);
        }
    }

    public void disableBtn(String buttonType) {
        if (buttonType.equalsIgnoreCase("Next")) {
            lowerFragment.nextBtn.setClickable(false);
            lowerFragment.nextBtn.setAlpha(.5f);
        } else if (buttonType.equalsIgnoreCase("Prev")) {
            lowerFragment.prevBtn.setClickable(false);
            lowerFragment.prevBtn.setAlpha(.5f);

        }
    }
}
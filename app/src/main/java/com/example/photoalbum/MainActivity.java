package com.example.photoalbum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.icu.text.CaseMap;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    UpperFragment upperFragment;
    LowerFragment lowerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        upperFragment = new UpperFragment().newInstance(null, null);
        lowerFragment = new LowerFragment().newInstance(null, null);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragmentContainerView3, upperFragment);
        transaction.add(R.id.fragmentContainerView4, lowerFragment);
        transaction.commit();
    }

    public void nextImage(){
        upperFragment.nextImage();
    }

    public void prevImage(){
        upperFragment.prevImage();
    }

    public void enableBtn(String buttonType){
        if(buttonType.equalsIgnoreCase("Next")){
            lowerFragment.nextBtn.setClickable(true);
            lowerFragment.nextBtn.setAlpha(1);
        }else if(buttonType.equalsIgnoreCase("Prev")){
            lowerFragment.prevBtn.setClickable(true);
            lowerFragment.prevBtn.setAlpha(1);
        }
    }

    public void disableBtn(String buttonType){
        if(buttonType.equalsIgnoreCase("Next")){
            lowerFragment.nextBtn.setClickable(false);
            lowerFragment.nextBtn.setAlpha(.5f);
        }else if(buttonType.equalsIgnoreCase("Prev")){
            lowerFragment.prevBtn.setClickable(false);
            lowerFragment.prevBtn.setAlpha(.5f);

        }
    }
}
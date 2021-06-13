package com.example.photoalbum;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SlideshowFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SlideshowFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Animation fade_in, fade_out;
    ViewFlipper viewFlipper;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SlideshowFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SlideshowFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SlideshowFragment newInstance(String param1, String param2) {
        SlideshowFragment fragment = new SlideshowFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slideshow, container, false);

        viewFlipper = view.findViewById(R.id.bckgrndViewFlipper1);

        //Setting the animation for the slide show.
        fade_in = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_right);
        fade_out = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_out_left);
        viewFlipper.setInAnimation(fade_in);
        viewFlipper.setOutAnimation(fade_out);

        //sets auto flipping
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(1500);
        viewFlipper.startFlipping();

        return view;
    }
}
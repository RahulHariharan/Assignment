package com.matrimony.training.assignment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Rutuja on 20-08-2015.
 */
public class SwipeFragmentOne extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private OnFragmentOneInteractionListener mListener;
    private HashMap<String ,ArrayList<Integer>> temp;

    private ArrayList<Integer> planet;
    private String mParam1;
    private String mParam2;

    ImageView image1;
    public static SwipeFragmentOne newInstance(String param1, String param2) {
        SwipeFragmentOne fragmentOne = new SwipeFragmentOne();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragmentOne.setArguments(args);
        return fragmentOne;

    }

    public SwipeFragmentOne() {

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentOneInteractionListener) activity;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");

        }
    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.swipefragment, container, false);

        image1=(ImageView)view.findViewById(R.id.imageSwipe);
        temp=DataStorage.mImageData;
        planet= new ArrayList<Integer>();
        String planetname=mListener.getPlanetName();
       planet= temp.get(planetname.toLowerCase());
        Log.v("planet1",planetname);
       image1.setImageResource(planet.get(0));
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentOneInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
        public  String getPlanetName();


    }
}
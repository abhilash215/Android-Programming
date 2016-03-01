package com.example.abhiu.hw03frag;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_List extends Fragment {

    MovieData movieData = new MovieData();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView= inflater.inflate(R.layout.fragment_fragment__list, container, false);

        final Button frozen = (Button) rootView.findViewById(R.id.button_frozen);
        final Button lionking = (Button) rootView.findViewById(R.id.button_lionking);
        final Button transformer = (Button) rootView.findViewById(R.id.button_transformer);
        final Button despicable_me = (Button) rootView.findViewById(R.id.button_Despical_me);
        final Button avatar = (Button) rootView.findViewById(R.id.button_avatar);


        final OnListItemSelectedListener mListener;
        try
        {
            mListener = (OnListItemSelectedListener) getActivity();

        }catch (ClassCastException e)
        {
            throw new ClassCastException("The hosting activity of the Fragment"+
                    "forget to implement onFragmentInteraction Listener");
        }

        frozen.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View rootView)
            {
                HashMap<String,?> movie = (HashMap<String,?>) movieData.getItem(18);
                mListener.onListItemSelected(0,movie);

            }


        });

        lionking.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View rootView)
            {
                HashMap<String,?> movie = (HashMap<String,?>) movieData.getItem(11);
                mListener.onListItemSelected(1,movie);
            }


        });

        transformer.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View rootView)
            {
                HashMap<String,?> movie = (HashMap<String,?>) movieData.getItem(17);
                mListener.onListItemSelected(2,movie);

            }


        });

        despicable_me.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View rootView) {
                HashMap<String, ?> movie = (HashMap<String, ?>) movieData.getItem(24);
                mListener.onListItemSelected(3, movie);
            }


        });

        avatar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View rootView)
            {
                HashMap<String,?> movie = (HashMap<String,?>) movieData.getItem(0);
                mListener.onListItemSelected(4,movie);
            }


        });

        return rootView;
    }


    public interface OnListItemSelectedListener
    {
        public void onListItemSelected(int position, HashMap<String,?>movie);

    }

    public Fragment_List()
    {

    }


    public static Fragment_List newInstance() {

        Bundle args = new Bundle();

        Fragment_List fragment = new Fragment_List();
        fragment.setArguments(args);
        return fragment;
    }
}

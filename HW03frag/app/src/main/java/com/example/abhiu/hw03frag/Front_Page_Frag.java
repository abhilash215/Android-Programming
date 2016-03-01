package com.example.abhiu.hw03frag;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Front_Page_Frag extends Fragment {


    public Front_Page_Frag() {
        // Required empty public constructor
    }

    private PageChange mListener;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (PageChange) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " must implement PageListener");
        }
    }

    private static final String ARG_SECTION_NUMBER="section_number";
    public static  final Front_Page_Frag newInstance(int sectionNumber){
    Front_Page_Frag fragment=new Front_Page_Frag();
        Bundle args=new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
    fragment.setArguments(args);
    return  fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_front__page_,null);

        Button btnAboutMe = (Button)rootView.findViewById(R.id.btn_about_me);
        Button btnViewPage=(Button) rootView.findViewById(R.id.btn_task2);
        Button btnMasterView=(Button) rootView.findViewById(R.id.btn_task3);

        btnAboutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.pageChange(1);
            }

        });

               btnViewPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),com.example.abhiu.hw03frag.ViewPager_Activity.class);
                startActivity(i);
            }
        });

        btnMasterView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),com.example.abhiu.hw03frag.Master_Detail.class);
                startActivity(i);
            }
        });


        return rootView;
    }
}

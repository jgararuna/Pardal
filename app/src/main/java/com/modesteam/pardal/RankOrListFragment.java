    package com.modesteam.pardal;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.modesteam.pardal.category.CategoryContent;

import models.State;


    /**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.
 * Use the {@link RankOrListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RankOrListFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RankOrListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RankOrListFragment newInstance(String param1, String param2) {
        RankOrListFragment fragment = new RankOrListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public RankOrListFragment() {
        // Required empty public constructor
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rank_or_list, container, false);
        ImageButton bRank = (ImageButton) view.findViewById(R.id.bRank);
        ImageButton bList = (ImageButton) view.findViewById(R.id.bList);
        bRank.setOnClickListener(this);
        bList.setOnClickListener(this);

        View rootView = inflater.inflate(R.layout.fragment_rank_or_list, container, false);

        TextView textViewAverageExceded = (TextView) rootView.findViewById(R.id.textViewDesc);
        switch (mParam1) {
            case "1":
                textViewAverageExceded.setText(State.last());
        }

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
   // public void onButtonPressed(Uri uri) {
     ///   if (mListener != null) {
       //     mListener.onFragmentInteraction(uri);
       // }
    //}

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.bRank:
                    System.out.println("RANK");
                    break;
                case R.id.bList:
                    switch(mParam1){
                        case "1":
                            mListener.onFragmentInteraction(CategoryContent.ITEM_MAP.get(1).id, StateListFragment.newInstance("1", ""));
                            break;
                        case "2":
                            mListener.onFragmentInteraction(CategoryContent.ITEM_MAP.get(2).id, CityListFragment.newInstance("2", ""));
                            break;
                        case "3":
                            mListener.onFragmentInteraction(CategoryContent.ITEM_MAP.get(3).id, HighwayStretchListFragment.newInstance("3", ""));
                            break;
                        case "4":
                            mListener.onFragmentInteraction(CategoryContent.ITEM_MAP.get(4).id, ModelListFragment.newInstance("4", ""));
                            break;
                        case "5":
                            mListener.onFragmentInteraction(CategoryContent.ITEM_MAP.get(5).id, TypeListFragment.newInstance("5", ""));
                            break;
                        case "6":
                            mListener.onFragmentInteraction(CategoryContent.ITEM_MAP.get(6).id, BrandListFragment.newInstance("6", ""));
                    }
            }
        }

        /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
   // public interface OnFragmentInteractionListener {
  //      // TODO: Update argument type and name
   //     public void onFragmentInteraction(Uri uri);
   // }

}

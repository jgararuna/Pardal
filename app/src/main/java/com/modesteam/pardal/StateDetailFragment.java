package com.modesteam.pardal;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.ArrayList;

import models.City;
import models.HighwayStretch;
import models.State;
import models.Tickets;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link StateDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StateDetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String IDState = "idState";
    private static final String Name = "name";

    // TODO: Rename and change types of parameters
    private int idState;
    private String name;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment StateDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StateDetailFragment newInstance(int param1, String param2) {
        StateDetailFragment fragment = new StateDetailFragment();
        Bundle args = new Bundle();
        args.putInt(IDState, param1);
        args.putString(Name, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public StateDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idState = getArguments().getInt(IDState);
            name = getArguments().getString(Name);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_state_detail, container, false);

        try {
            State state = State.get(idState);
            double averageExceded = 0, maximumMeasuredVelocity=0;
            int  totalTickets = 0;


            ArrayList<City> listCity = state.getCities();
            int tam = listCity.size();
            ArrayList<HighwayStretch> listHighwayStretches = new ArrayList<>();
            ArrayList<Tickets> listTickets = new ArrayList<>();
/*
            for(int i=1; i<=listCity.size(); i++) {
                listHighwayStretches = (listCity.get(i).getHighwayStretches());
            }

            int tam2 = listHighwayStretches.size();

            for(int i=1; i<=listHighwayStretches.size(); i++){
                listTickets = listHighwayStretches.get(i).getTickets();
            }

            for(int i=1; i<=listHighwayStretches.size(); i++){
                totalTickets = listTickets.get(i).getTotalTickets();
            }
*/

            TextView textViewName = (TextView) rootView.findViewById(R.id.textViewName);
            textViewName.setText((name));

            TextView textViewCities = (TextView) rootView.findViewById(R.id.textViewCities);
            textViewCities.setText(Integer.toString(tam));


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rootView;

    }

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
}

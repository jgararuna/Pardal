package com.modesteam.pardal;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.ArrayList;

import exception.GenericAlertDialogException;
import models.HighwayStretch;
import models.Tickets;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link HighwayStretchDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HighwayStretchDetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static HighwayStretch highwayStretchDetail;
    private static final String ID_HIGHWAY_STRETCH = "idHighwayStretch";
    private static final String NAME = "nameHighwayStretch";
    private static final String KM = "kmHighwayStretch";


    // TODO: Rename and change types of parameters
    private int idHighwayStretch;
    private String nameHighwayStretch;
    private String cityHighwayStretch;
    private String stateHighwayStretch;
    private int kmHighwayStretch;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param idHighwayStretch Parameter 1.
     * @return A new instance of fragment HighwayStretchDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HighwayStretchDetailFragment newInstance(HighwayStretch highwayStretch) {
        HighwayStretchDetailFragment fragment = new HighwayStretchDetailFragment();
        Bundle args = new Bundle();
        highwayStretchDetail = highwayStretch;
        args.putInt(ID_HIGHWAY_STRETCH, highwayStretch.getId());
        args.putString(NAME, highwayStretch.getNumber());
        args.putInt(KM, highwayStretch.getKilometer());
        fragment.setArguments(args);
        return fragment;
    }

    public HighwayStretchDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idHighwayStretch = getArguments().getInt(ID_HIGHWAY_STRETCH);
            nameHighwayStretch = getArguments().getString(NAME);
            kmHighwayStretch = getArguments().getInt(KM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_highway_stretch_detail, container, false);

        try {
            // Implemente

            /*/Imprime total de rodovias
            TextView total = (TextView) rootView.findViewById(R.id.total);
            total.setText(Integer.toString(HighwayStretch.getAll().size()));
            */

            //Imprime total de tickets na rodovia
            TextView totalTickets = (TextView) rootView.findViewById(R.id.totalTickets);
            ArrayList<Tickets> tickets = highwayStretchDetail.getTickets();
            cityHighwayStretch = highwayStretchDetail.getCity().getName();
            stateHighwayStretch = highwayStretchDetail.getCity().getState().getName();

            int amountTickets = 0;
            int actualTicket = 0;
            double velocity = tickets.get(0).getVelocityLimit();
            double velocityExceded = 0;
            double maximumVelocity = tickets.get(0).getMaximumMeasuredVelocity();


            for (Tickets ticket : tickets){
                amountTickets += ticket.getTotalTickets();
                velocityExceded += tickets.get(actualTicket).getAverageExceded();
                actualTicket++;
            }
            totalTickets.setText(Integer.toString(amountTickets));


            if(tickets.size() != 0) {
                velocityExceded = velocityExceded / tickets.size();
            }else{
                velocityExceded = 0;
            }

            //Imprime velocidade limite dos carros na rodovia
            TextView velocityLimit = (TextView) rootView.findViewById(R.id.velocityLimit);
            velocityLimit.setText(Double.toString(velocity) + " km/h");

            //Imprime a media de velocidade excedida
            TextView averageExceded = (TextView) rootView.findViewById(R.id.averageExceded);
            averageExceded.setText(String.format("%.1f",velocityExceded) + " km/h");

            //Imprime a maxima velocidade registrada
            TextView maximumMeasuredVelocity = (TextView) rootView.findViewById(R.id.maximumMeasuredVelocity);
            maximumMeasuredVelocity.setText(Double.toString(maximumVelocity) + " km/h");

            TextView name = (TextView) rootView.findViewById(R.id.textViewName);
            name.setText("BR "+(nameHighwayStretch)+" KM "+(kmHighwayStretch));

            TextView cityState = (TextView) rootView.findViewById(R.id.textViewCityState);
            cityState.setText(""+(cityHighwayStretch)+"/"+(stateHighwayStretch));


        }catch(ClassNotFoundException e){
            GenericAlertDialogException genericAlertDialogException = new GenericAlertDialogException();
            genericAlertDialogException.criarAviso(this.getActivity());
        }catch(SQLException e){
            GenericAlertDialogException genericAlertDialogException = new GenericAlertDialogException();
            genericAlertDialogException.criarAviso(this.getActivity());
        }catch (NullPointerException e){
            GenericAlertDialogException genericAlertDialogException = new GenericAlertDialogException();
            genericAlertDialogException.criarAviso(this.getActivity());
        }

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(0, HighwayStretchListFragment.newInstance("",""));
        }
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

package com.modesteam.pardal;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.ArrayList;

import exception.GenericAlertDialogException;
import models.Brand;
import models.Model;
import models.Tickets;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link BrandDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BrandDetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static Brand brandDetail;
    private static final String IDBrand = "idBrand";
    private static final String Name = "Name";

    // TODO: Rename and change types of parameters
    private int idBrand;
    private String name;


    private OnFragmentInteractionListener mListener;

    private AbsListView mListView;

    /**
     * The Adapter which will be used to populate the ListView/GridView with
     * Views.
     */
    private ListAdapter mAdapter;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment BrandDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BrandDetailFragment newInstance(Brand brand) {
        BrandDetailFragment fragment = new BrandDetailFragment();
        Bundle args = new Bundle();
        brandDetail = brand;
        args.putInt(IDBrand, brand.getId());
        args.putString(Name, brand.getName());
        fragment.setArguments(args);
        return fragment;
    }

    public BrandDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idBrand = getArguments().getInt(IDBrand);
            name = getArguments().getString(Name);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_brand_detail, container, false);

        try {

            double averageExceded = brandDetail.getAverageExceded(), maximumMeasuredVelocity=brandDetail.getMaximumMeasuredVelocity();
            int  totalTickets=brandDetail.getTotalTickets();

            TextView textViewTotalTickets = (TextView) rootView.findViewById(R.id.textViewTotalTickets);
            textViewTotalTickets.setText(Integer.toString(totalTickets));

            TextView textViewName = (TextView) rootView.findViewById(R.id.textViewName);
            textViewName.setText((name));

            TextView textViewAverageExceded = (TextView) rootView.findViewById(R.id.textViewAverageExceded);
            textViewAverageExceded.setText((String.format("%.1f", averageExceded) + " km/h"));

            TextView textViewMaximumMeasuredVelocity = (TextView) rootView.findViewById(R.id.textViewMaximumMeasuredVelocity);
            textViewMaximumMeasuredVelocity.setText((Double.toString(maximumMeasuredVelocity )+ " km/h"));

        } catch (NullPointerException e){
            GenericAlertDialogException genericAlertDialogException = new GenericAlertDialogException();
            genericAlertDialogException.criarAviso(this.getActivity());
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

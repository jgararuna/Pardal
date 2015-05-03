package com.modesteam.pardal;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.ArrayList;

import helpers.Condition;
import helpers.Operator;
import models.Tickets;
import models.Model;
import models.Type;


public class TypeDetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static Type typeForDetail;
   // private static final String NAME_TYPE = "nameType";

    // TODO: Rename and change types of parameters
    //private static String nameOfType;

    private OnFragmentInteractionListener mListener;

    // TODO: Rename and change types and number of parameters
    public static TypeDetailFragment newInstance(Type type) {
        TypeDetailFragment fragment = new TypeDetailFragment();
        Bundle args = new Bundle();
        typeForDetail = type;
       // args.putString(NAME_TYPE,nameType);
        fragment.setArguments(args);
        return fragment;
    }

    public TypeDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //nameOfType = getArguments().getString(NAME_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_type_detail, container, false);
        detailType(rootView);
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

    public void detailType(View view) {
        TextView nameType, totalModels,totalTickets;

        nameType = (TextView) view.findViewById(R.id.textViewName);
        nameType.setText(typeForDetail.getName());



        //Parte correta comentada, erro no banco

       // ArrayList<ArrayList<Tickets>> arrayTicktes = null;
        ArrayList<Tickets> arrayTicktes = null;
        int numberTotalTickets=0;
        ArrayList<Model> arrayModelsOfType = null;
        String quebraLinha = System.getProperty("line.separator");
        try {
            arrayModelsOfType = typeForDetail.getModels();
//            for (Model model : arrayModelsOfType) {
//               arrayTicktes = model.getTickets();
//                for (Tickets ticket: arrayTicktes){
//                    numberTotalTickets = numberTotalTickets + ticket.getTotalTickets();
//                }
//                break;
//           }
            //arrayTicktes = arrayModelsOfType.get(0).getTickets();
            //numberTotalTickets = arrayTicktes.get(0).getTotalTickets();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }

        //progress = ProgressDialog.show(this, "dialog title","dialog message", true);
        totalModels = (TextView) view.findViewById(R.id.textViewTotalModels);
        totalModels.setText(arrayModelsOfType.size());
        totalTickets = (TextView) view.findViewById(R.id.textViewTotalTickets);
        totalTickets.setText(numberTotalTickets);

    }

}

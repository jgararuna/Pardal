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

import helpers.Condition;
import helpers.Operator;
import models.Tickets;
import models.Model;
import models.Type;


public class TypeDetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static ArrayList<Model> arrayModelsOfType;
    private static final String NAME_TYPE = "nameType";

    // TODO: Rename and change types of parameters
    private static String nameOfType;

    private OnFragmentInteractionListener mListener;

    // TODO: Rename and change types and number of parameters
    public static TypeDetailFragment newInstance(ArrayList<Model> arrayModels, String nameType) {
        TypeDetailFragment fragment = new TypeDetailFragment();
        Bundle args = new Bundle();
        arrayModelsOfType = arrayModels;
        args.putString(NAME_TYPE,nameType);
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
            nameOfType = getArguments().getString(NAME_TYPE);
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
        TextView nameType, detailInformationType;

        nameType = (TextView) view.findViewById(R.id.detalhe_textView);
        nameType.setText("Detalhe da categoria "+ nameOfType);

        //Parte correta comentada, erro no banco

//        Condition condition;
//        Tickets ticket = new Tickets();
//        ArrayList<ArrayList<Tickets>> arrayTicktes = null;
//        for (Model model: arrayModelsOfType){
//            condition = new Condition(ticket,"idModel",Operator.EQUAL,model.getId());
//            try {
//                arrayTicktes.add((Tickets.getWhere(condition)));
//            }catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        detailInformationType = (TextView) view.findViewById(R.id.detalhe_tipo_textView);
//        detailInformationType.setText(arrayTicktes.toString());

    }

}

package mobi.roomies.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mobi.roomies.Adapters.ExpensesAdapter;
import mobi.roomies.R;
import mobi.roomies.models.Expense;

/*
    Created by Kevin Chung
    Fragment used to contain the chat functionality UI
    this fragment will utilize firebase to handle messaging via firebase
 */
public class ExpensesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // recycler view
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ExpensesAdapter expensesAdapter;


    public ExpensesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());

        expensesAdapter = new ExpensesAdapter(new ArrayList<Expense>());


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_expenses,container,false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(expensesAdapter);

        return inflater.inflate(R.layout.fragment_expenses, container, false);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    // new instance constructor required to create a new fragment with arguments
    // change eventually
    public static ExpensesFragment newInstance(String page, String title) {
        ExpensesFragment expensesFragment = new ExpensesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, page);
        args.putString(ARG_PARAM2, title);
        expensesFragment.setArguments(args);
        return expensesFragment;
    }
}

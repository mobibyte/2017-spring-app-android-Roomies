package mobi.roomies.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    private ArrayList<Expense> expenseList;

    private DatabaseReference database;
    private DatabaseReference rootReference;
    private DatabaseReference groupReference;


    public ExpensesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        expenseList = new ArrayList<Expense>();
        expensesAdapter = new ExpensesAdapter(expenseList);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_expenses,container,false);
        recyclerView = (RecyclerView)view.findViewById(R.id.expense_recycler_view);
        mLayoutManager = new LinearLayoutManager(getActivity());
        // Inflate the layout for this fragment

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(expensesAdapter);

        return view;
    }

    // start firebase network connections here
    @Override
    public void onStart(){
        super.onStart();

        //database = FirebaseDatabase.getInstance().getReference().child("groups");

        //Read from DB
        // this needs to get fixed, hard coding it(the reference) to the first value rn just to demo
        // above database reference should be used later
        database = FirebaseDatabase.getInstance().getReference("/groups/-KfwGKBg61gJUACz87Mn").child("expenses");
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Again this is hard coded so this will need to change when we set things up proper
                for(DataSnapshot expenseSnapshot: dataSnapshot.getChildren()){
                    Expense expense = expenseSnapshot.getValue(Expense.class);
                    Log.d("expense debug ", expense.getAmount());
                    expenseList.add(expense);
                }
                Log.d("expense list debug",expenseList.size()+"");
                expensesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getContext(),"error",Toast.LENGTH_LONG).show();
            }
        });


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

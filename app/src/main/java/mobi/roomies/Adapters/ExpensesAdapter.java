package mobi.roomies.Adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import mobi.roomies.R;
import mobi.roomies.models.Expense;

/**
 * Created by Kevin on 11/4/2016.
 */

public class ExpensesAdapter extends RecyclerView.Adapter<ExpensesAdapter.ExpenseViewHolder>{

    private ArrayList<Expense> expenseList;

    public ExpensesAdapter(ArrayList<Expense> expenseList){
        Log.d("YO","YO");
        this.expenseList = new ArrayList<>();
        this.expenseList.add(new Expense());
        this.expenseList.add(new Expense());
        this.expenseList.add(new Expense());
        this.expenseList.add(new Expense());
        this.expenseList.add(new Expense());
        this.expenseList.add(new Expense());
        this.expenseList.add(new Expense());
        this.expenseList.add(new Expense());
        this.expenseList.add(new Expense());
        this.expenseList.add(new Expense());
        this.expenseList.add(new Expense());
        this.expenseList.add(new Expense());
        this.expenseList.add(new Expense());

    }

    public class ExpenseViewHolder extends RecyclerView.ViewHolder {
        public TextView author, debtor, ammount, title;

        public ExpenseViewHolder(View view) {
            super(view);
            Log.d("yo2","yo2");
            title = (TextView) view.findViewById(R.id.title);
            author = (TextView) view.findViewById(R.id.author);
            debtor = (TextView) view.findViewById(R.id.debtor);
            ammount = (TextView) view.findViewById(R.id.ammount);

        }
    }



    @Override
    public ExpenseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("oncreateviewholder","yo");
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_expenses_item,parent,false);
        return new ExpenseViewHolder(item);
    }

    @Override
    public void onBindViewHolder(ExpenseViewHolder holder, int position) {
        Log.d("onbindviewholder","yo");
        holder.author.setText("author");
        holder.debtor.setText("debtor");
        holder.ammount.setText("$ammount");
        holder.title.setText("title");

    }

    @Override
    public int getItemCount() {
        Log.d("ABC",expenseList.size()+"");
        return expenseList.size();
    }
}

package mobi.roomies.Adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
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
        this.expenseList = expenseList;
    }

    public class ExpenseViewHolder extends RecyclerView.ViewHolder {
        public TextView author, debtor, ammount;

        public ExpenseViewHolder(View view) {
            super(view);
            author = (TextView) view.findViewById(R.id.creator);
            debtor = (TextView) view.findViewById(R.id.debtor);
            ammount = (TextView) view.findViewById(R.id.ammount);
        }
    }



    @Override
    public ExpenseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_expenses_item,parent,false);
        return new ExpenseViewHolder(item);
    }

    @Override
    public void onBindViewHolder(ExpenseViewHolder holder, int position) {
        holder.author.setText(position);
        holder.debtor.setText(position);
        holder.ammount.setText(position);

    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }
}

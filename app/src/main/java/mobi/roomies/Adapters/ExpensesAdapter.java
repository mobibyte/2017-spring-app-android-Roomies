package mobi.roomies.Adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        //this.expenseList.add(new Expense("title","type","owedto","owedfrom", "amount", "emoji"));

    }

    public class ExpenseViewHolder extends RecyclerView.ViewHolder {
        public TextView title,type,owedto,owedFrom, amount, emoji;

        public ExpenseViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            type = (TextView) view.findViewById(R.id.author);
            owedFrom = (TextView) view.findViewById(R.id.owed_from);
            emoji = (TextView) view.findViewById(R.id.emoji);
            amount = (TextView) view.findViewById(R.id.amount);
        }
    }

    @Override
    public ExpenseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_expenses_item,parent,false);
        return new ExpenseViewHolder(item);
    }

    @Override
    public void onBindViewHolder(ExpenseViewHolder holder, int position) {
        Expense currentExpense = expenseList.get(position);
       // Log.d("viewholder db",currentExpense.getTitle());
        holder.title.setText(currentExpense.getTitle());
        holder.type.setText(currentExpense.getType());
       //holder.owedto.setText(currentExpense.getOwedToUserName());
        holder.amount.setText("$"+currentExpense.getAmount());
        holder.emoji.setText(currentExpense.getEmoji());

        //TODO need to change this, but its tied to firebase. look @ expense fragment ondatachangeds
        holder.owedFrom.setText(currentExpense.getUsername());
    }

    @Override
    public int getItemCount() {
        Log.d("ABC",expenseList.size()+"");
        return expenseList.size();
    }
}

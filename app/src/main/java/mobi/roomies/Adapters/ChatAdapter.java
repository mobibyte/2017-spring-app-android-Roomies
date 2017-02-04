package mobi.roomies.Adapters;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import mobi.roomies.R;
import mobi.roomies.models.ChatItem;
import mobi.roomies.models.Expense;

import static android.R.id.list;

/**
 * Created by HeyImRige on 12/2/2016.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder>{


    private ArrayList<ChatItem> chatItemArrayList;


    public class ChatViewHolder extends RecyclerView.ViewHolder {
        public TextView chatText;

        public ChatViewHolder(View view) {
            super(view);
            chatText= (TextView) view.findViewById(R.id.chatText);

        }
    }

    public ChatAdapter(ArrayList<ChatItem> chatItemArrayList){

        this.chatItemArrayList = chatItemArrayList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ChatAdapter.ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_chat_item,parent,false);
        return new ChatAdapter.ChatViewHolder(item);


    }

    //put data on the view
    @Override
    public void onBindViewHolder(ChatAdapter.ChatViewHolder holder, int position) {
        holder.chatText.setText(chatItemArrayList.get(position).text);
    }




    @Override
    public int getItemCount() {
        Log.d("chat adapater count",chatItemArrayList.size()+"");
        return chatItemArrayList.size();
    }







}

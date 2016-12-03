package mobi.roomies.Adapters;

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

    public ChatAdapter(ArrayList<ChatItem> chatItemArrayList){
        Log.d("YO","YO");
        this.chatItemArrayList = new ArrayList<>();
        this.chatItemArrayList.add(new ChatItem());
        this.chatItemArrayList.add(new ChatItem());
        this.chatItemArrayList.add(new ChatItem());
        this.chatItemArrayList.add(new ChatItem());
        this.chatItemArrayList.add(new ChatItem());
        this.chatItemArrayList.add(new ChatItem());
        this.chatItemArrayList.add(new ChatItem());
    }


    public class ChatViewHolder extends RecyclerView.ViewHolder {
        public TextView chatText;

        public ChatViewHolder(View view) {
            super(view);
            chatText= (TextView) view.findViewById(R.id.chatText);

        }
    }

    @Override
    public int getItemCount() {
        Log.d("ABC",chatItemArrayList.size()+"");
        return chatItemArrayList.size();
    }

    @Override
    public void onBindViewHolder(ChatAdapter.ChatViewHolder holder, int position) {
        //holder.chatText.setText("YOU OWE ME MONEY HOE WHERE IS THE MONEY AT. I NEED MY MONEYYYYYY. LOOK THIS TEXT WRAPS ALL THE WAY AROUND BECAUES I NEED IT FOR TESTING PURPOSES OMG LOOK. MORE TEXT. WOW THIS TEXT KEEPS GOING. I AM DOG WOOF WOOF WOOF WOOF WOOF WOOF WOOF WOOF WOOF.");

    }


    @Override
    public ChatAdapter.ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_chat_item,parent,false);
        return new ChatAdapter.ChatViewHolder(item);
    }

}

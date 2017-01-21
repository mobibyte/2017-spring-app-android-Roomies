package mobi.roomies.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import mobi.roomies.Adapters.ChatAdapter;
import mobi.roomies.R;
import mobi.roomies.models.ChatItem;

/*
    Created by Kevin Chung
    Fragment used to contain the chat functionality UI
    this fragment will utilize firebase to handle messaging via firebase
 */
public class ChatFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";





    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    private ChatAdapter chatAdapter;


    public ChatFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chatAdapter = new ChatAdapter(new ArrayList<ChatItem>());
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chat,container,false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.chat_recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        // Inflate the layout for this fragment

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(chatAdapter);

        return view;


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
    public static ChatFragment newInstance(String page, String title) {
        ChatFragment chatFragment = new ChatFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, page);
        args.putString(ARG_PARAM2, title);
        chatFragment.setArguments(args);
        return chatFragment;
    }
}

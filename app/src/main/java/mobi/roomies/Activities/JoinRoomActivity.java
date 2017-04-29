package mobi.roomies.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import mobi.roomies.Interfaces.SingletonGroup;
import mobi.roomies.Interfaces.SingletonUser;
import mobi.roomies.R;

public class JoinRoomActivity extends AppCompatActivity {



    private Button joinRoomBTN;
    private EditText joinRoomEditText;
    private DatabaseReference db;
    private ValueEventListener joinCreateRoomListener;
    private ValueEventListener userHaveRoomListener;
    private ValueEventListener roomMembersListener;
    private static final String TAG = "ROOMJOIN";
    private SingletonUser singleUser;
    private SingletonGroup singleGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_room);


        joinRoomBTN = (Button)findViewById(R.id.join_room_btn);
        joinRoomEditText = (EditText)findViewById(R.id.join_room_edit_text);
        this.db = FirebaseDatabase.getInstance().getReference();
        singleUser = SingletonUser.getInstance();
        singleGroup = SingletonGroup.getInstance();




        //Check if user is already in a group
        /*
        userHaveRoomListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue()==null){
                    //User already in a room
                    String userGroupKey = dataSnapshot.getValue().toString();




                }
                else{
                    //Room does exist. Join it.





                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        db.child("users").child(singleUser.getId()).addListenerForSingleValueEvent(userHaveRoomListener);

        */



        //This is called only once they attempt to join a room
        joinCreateRoomListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d(TAG,dataSnapshot.getValue().toString());
                if (dataSnapshot.getValue()==null){
                    //Room doesn't exist. We need to make it
                    Log.d(TAG,"Room doesn't exsist. Need logic to create room");





                }
                else{
                    //Room does exist. Join it.
                    singleGroup.setId(dataSnapshot.getValue().toString());
                    DatabaseReference roomMembersReference = db.child("groups").child(singleGroup.getId()).child("members").child(singleUser.getId());
                    roomMembersReference.setValue(true);

                    //TODO get add members to singleton

                    Intent intent = new Intent(JoinRoomActivity.this,HomeActivity.class);
                    startActivity(intent);




                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };




        joinRoomBTN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG,"join room button.");
                String joinRoomString = joinRoomEditText.getText().toString();
                singleGroup.setJoinKey(joinRoomString);
                DatabaseReference roomKeysReference = db.child("groupKeys").child(joinRoomString);
                //set a listener for a single response.
                roomKeysReference.addListenerForSingleValueEvent(joinCreateRoomListener);

                // Perform action on click
            }
        });

        //This is called only once they attempt to join a room



    }




}

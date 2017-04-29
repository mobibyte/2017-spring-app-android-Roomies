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

import java.util.ArrayList;

import mobi.roomies.Interfaces.SingletonGroup;
import mobi.roomies.Interfaces.SingletonUser;
import mobi.roomies.R;
import mobi.roomies.models.User;

public class JoinRoomActivity extends AppCompatActivity {



    private Button joinRoomBTN;
    private EditText joinRoomEditText;
    private DatabaseReference db;
    private ValueEventListener retrieveGroupKeyListener;
    private ValueEventListener userHaveRoomListener;
    private ValueEventListener getGroupMembersInformationListener;
    private ValueEventListener getUserInformationListener;
    private static final String TAG = "ROOMJOIN";
    private SingletonUser singleUser;
    private SingletonGroup singleGroup;
    private ArrayList<User> userList;
    private ArrayList<String> userKeys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_room);


        joinRoomBTN = (Button)findViewById(R.id.join_room_btn);
        joinRoomEditText = (EditText)findViewById(R.id.join_room_edit_text);
        this.db = FirebaseDatabase.getInstance().getReference();
        singleUser = SingletonUser.getInstance();
        singleGroup = SingletonGroup.getInstance();
        userKeys = new ArrayList<String>();

        //Get list of users based on userKeys, save them to the singleton
        //starts in /users/
        //Starts the next activity once it does
        getUserInformationListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                userList = singleGroup.getUserList();
                //make our list of users based on keys we got earlier.
                for (int i = 0; i< userKeys.size(); i++){
                    User newUser = new User();
                    String userKey = userKeys.get(i);
                    DataSnapshot user = dataSnapshot.child(userKey);
                    newUser.setName(user.child("name").getValue().toString());
                    newUser.setId(user.getKey().toString());
                    newUser.setEmail(user.child("email").getValue().toString());
                    newUser.setAvatarURL(user.child("avatarUrl").getValue().toString());
                    userList.add(newUser);
                }
                Intent intent = new Intent(JoinRoomActivity.this,HomeActivity.class);
                startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        //Get information about the members of group the user has joined
        //starts in /groups/"groupKey"/members
        //After getting user keys from the group, start listener to getUserInformation
        getGroupMembersInformationListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d(TAG,"about to add members to userKeys");
                for (DataSnapshot messageSnapshot: dataSnapshot.getChildren()){
                    userKeys.add(messageSnapshot.getKey().toString());

                }
                DatabaseReference usersDatabase = db.child("users");
                usersDatabase.addListenerForSingleValueEvent(getUserInformationListener);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };


        //Check if user is already in a group TODO
        userHaveRoomListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue()==null){
                    //User isn't in a room.





                }
                else{
                    //User is already in a room
                    String userGroupKey = dataSnapshot.getValue().toString();
                    singleGroup.setId(userGroupKey);
                    //get the join key and Members, then launch the next intent.
                    DatabaseReference joiningThisGroup = db.child("groups").child(singleGroup.getId());
                    joiningThisGroup.addListenerForSingleValueEvent(getGroupMembersInformationListener);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        db.child("users").child(singleUser.getId()).child("group").addListenerForSingleValueEvent(userHaveRoomListener);





        //This is called only once they attempt to join a room
        //Room doesn't exist TODO
        //Room Exists - add self to room and , add room to self, set listener to get group information
        retrieveGroupKeyListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d(TAG,dataSnapshot.getValue().toString());
                if (dataSnapshot.getValue()==null){
                    //Room doesn't exsist. Need logic to create room
                    Log.d(TAG,"Room doesn't exsist. Need logic to create room");





                }
                else{
                    //Room key does exsist.
                    singleGroup.setId(dataSnapshot.getValue().toString());
                    Log.d(TAG,"group ID"+singleGroup.getId());
                    Log.d(TAG,"group key"+singleGroup.getJoinKey());
                    DatabaseReference groupMembersSelfIDReference = db.child("groups").child(singleGroup.getId()).child("members").child(singleUser.getId());
                    groupMembersSelfIDReference.setValue(true);
                    //set our own users/userKey/group to group key
                    DatabaseReference selfUserGroupKey = db.child("users").child(singleUser.getId()).child("group");
                    selfUserGroupKey.setValue(singleGroup.getId());
                    //TODO get add members to singleton
                    //set listener to get list of memebers that are in the group
                    DatabaseReference currentGroupDatabaseReference = db.child("groups").child(singleGroup.getId()).child("members");
                    currentGroupDatabaseReference.addListenerForSingleValueEvent(getGroupMembersInformationListener);



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
                DatabaseReference groupKeysDatabaseReference = db.child("groupKeys").child(joinRoomString);
                //set a listener for a single response.
                groupKeysDatabaseReference.addListenerForSingleValueEvent(retrieveGroupKeyListener);

                // Perform action on click
            }
        });

        //This is called only once they attempt to join a room



    }






}

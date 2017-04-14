package mobi.roomies.Activities;

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

import mobi.roomies.R;

public class JoinRoomActivity extends AppCompatActivity {



    private Button joinRoomBTN;
    private EditText joinRoomEditText;
    private DatabaseReference db;
    private ValueEventListener roomDataListener;
    private static final String TAG = "ROOMJOIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_room);


        joinRoomBTN = (Button)findViewById(R.id.join_room_btn);
        joinRoomEditText = (EditText)findViewById(R.id.join_room_edit_text);
        this.db = FirebaseDatabase.getInstance().getReference();








        //This is called only once after we recieve data about the room from Firebase
        roomDataListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue()==null){
                    //Room doesn't exist. We need to make it




                }
                else{
                    //Room does exist. Join it.





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
                String joinRoomString = joinRoomEditText.getText().toString();
                DatabaseReference roomReference = db.child("groupKeys").child(joinRoomString);
                //set a listener for a single response.
                roomReference.addListenerForSingleValueEvent(roomDataListener);

                // Perform action on click
            }
        });


    }
}

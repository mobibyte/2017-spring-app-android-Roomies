package mobi.roomies.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;

import com.squareup.timessquare.CalendarPickerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import mobi.roomies.Fragments.TaskFragment;
import mobi.roomies.R;
import mobi.roomies.models.Task;

import static com.squareup.timessquare.CalendarPickerView.SelectionMode.RANGE;

/**
 * Created by kolten on 2/10/17.
 */

public class AddTaskActivity extends AppCompatActivity implements View.OnClickListener {

    EditText taskTitle;
    EditText taskSubtask;

    Button addSubtask;
    Button date;    // Temp, this is hideous
    Button done;

    RatingBar ratingBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        taskTitle = (EditText) findViewById(R.id.et_task_title);
        taskSubtask = (EditText) findViewById(R.id.et_task_subtask);

        addSubtask = (Button) findViewById(R.id.btn_task_subtask_add);

        date = (Button)findViewById(R.id.btn_task_date);
        done = (Button)findViewById(R.id.btn_tasks_done);

        ratingBar = (RatingBar) findViewById(R.id.rb_task_priority);

        date.setOnClickListener(this);
        done.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_task_subtask_add:
                // Add more EditText views dynamically
                break;

            case R.id.btn_tasks_done:
                // Done
                if(inputIsValid()) {
                    // Return Task Object
                }
                break;
        }
    }

    private boolean inputIsValid() {
        if (taskTitle.getText() != null){ // Add more error checking
            return true;
        }

        return false;
    }

}

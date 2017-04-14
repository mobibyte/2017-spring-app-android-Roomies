package mobi.roomies.Adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import mobi.roomies.R;
import mobi.roomies.models.Task;

/**
 * Created by kolten on 12/2/16.
 */

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TaskViewHolder> {

    private ArrayList<Task> taskList;


    public class TaskViewHolder extends RecyclerView.ViewHolder {

        public TextView title, dueBy, createdBy;
        public RatingBar priority;

        public TaskViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.tv_title);
            dueBy = (TextView) view.findViewById(R.id.tv_due);
            createdBy = (TextView) itemView.findViewById(R.id.tv_createdBy);
            priority = (RatingBar) view.findViewById(R.id.priority);
        }
    }

    public TasksAdapter(ArrayList<Task> taskList){
        this.taskList = taskList;
        taskList.add(new Task("lol", "kolten", 5));

    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_layout_row, parent, false);
        RecyclerView.ViewHolder viewHolder = new TaskViewHolder(item);
        return (TaskViewHolder) viewHolder;
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        holder.title.setText(taskList.get(position).getTitle());
        holder.createdBy.append(taskList.get(position).getCreatedBy());
        //holder.dueBy.append(taskList.get(position).getDueBy());
        holder.priority.setIsIndicator(true);
        holder.priority.setRating(taskList.get(position).getPriority());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public void add(Task task){
        taskList.add(task);
        taskList.notifyAll();
    }

}

package com.example.todoenhanced;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.List;

public class TaskAdapter extends ArrayAdapter<String> {
    private int resourceLayout;
    private Context mContext;

    public TaskAdapter(@NonNull Context context, int resource, List<String> items) {
        super(context, resource, items);
        this.resourceLayout = resource;
        this.mContext = context;
    }

    @Override
    public	View	getView(int	position,	View	convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(resourceLayout, null);
        }
        String p = getItem(position);

        if (p != null) {
            TextView	tt	= v.findViewById(R.id.textViewTaskDescription);
            Button bt = v.findViewById(R.id.buttonDeleteTask);
            if (tt != null) {
                tt.setText(p);
            }
            if (bt != null) {
                bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    remove(p); // Remove the item from the list
                    notifyDataSetChanged(); // Notify the adapter to refresh the list
                }
            });
            }
        }
        return v;
    }

}

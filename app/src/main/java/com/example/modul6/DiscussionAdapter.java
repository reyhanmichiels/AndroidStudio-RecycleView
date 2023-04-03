package com.example.modul6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DiscussionAdapter extends RecyclerView.Adapter<DiscussionAdapter.DiscussionViewHolder> {
    private Context context;
    private List<DiscussionModel> disscussionList;
    private static ClickListener clickListener;

    public DiscussionAdapter(Context context, List<DiscussionModel> disscussionList) {
        this.context = context;
        this.disscussionList = disscussionList;
    }

    @NonNull
    @Override
    public DiscussionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new DiscussionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscussionViewHolder holder, int position) {
        final DiscussionModel discussionModel = disscussionList.get(position);

        holder.tv_name.setText(discussionModel.getName());
        holder.tv_comment.setText(discussionModel.getComment());
    }

    @Override
    public int getItemCount() {
        return disscussionList.size();
    }

    public class DiscussionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_name, tv_comment;
        Button btn_delete;

        public DiscussionViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_comment = itemView.findViewById(R.id.tv_comment);
            btn_delete = itemView.findViewById(R.id.btn_delete);

            btn_delete.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition(), itemView);
        }
    }

    public void setOnItemClickListener(DiscussionAdapter.ClickListener clickListener){
        DiscussionAdapter.clickListener = clickListener;
    }

    interface ClickListener {
        void onItemClick(int position, View v);
    }
}

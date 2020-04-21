package com.job4j.retrofitexample.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.job4j.retrofitexample.R;
import com.job4j.retrofitexample.model.Comment;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentHolder> {

    private List<Comment> comments;

    public CommentAdapter(List<Comment> comments) {
        this.comments = comments;
    }

    @NonNull
    @Override
    public CommentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_info, parent, false);
        return new CommentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentHolder holder, int position) {
        Comment comment = comments.get(position);
        TextView text = holder.itemView.findViewById(R.id.comment_info);
        String content = String.format(
                "ID: %s\n post ID: %s\n Name: %s\nEmail: %s\nComment: %s\n\n",
                comment.getId(), comment.getPostId(), comment.getName(), comment.getEmail(), comment.getBody());
        text.setText(content);
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class CommentHolder extends RecyclerView.ViewHolder {

        public CommentHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

package com.example.gmd507;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Locale;

public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;

    public ViewHolder(TextView itemView) {
        super(itemView);

        this.textView = itemView;
        this.textView.setTextSize(24f);
    }

    public void setData(int position) {
        textView.setText(String.format(Locale.US, "Hello %d", position));
    }
}

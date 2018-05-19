package com.example.hsport.c196mobileappdevelopmentbheller;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TermListAdapter extends RecyclerView.Adapter<TermListAdapter.TermViewHolder> {
    class TermViewHolder extends RecyclerView.ViewHolder {
        private final TextView termItemView;

        private TermViewHolder(View itemView) {
            super(itemView);
            termItemView = itemView.findViewById(R.id.itemTermView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Term> mTerms; // Cached copy of terms

    TermListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public TermViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.term_view, parent, false);
        return new TermViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TermViewHolder holder, int position) {
        if (mTerms != null) {
            Term current = mTerms.get(position);
            holder.termItemView.setText(current.getTermName());
        } else {
            // Covers the case of data not being ready yet.
            holder.termItemView.setText("No Terms");
        }
    }

    void setTerms(List<Term> terms){
        mTerms = terms;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mTerms != null)
            return mTerms.size();
        else return 0;
    }


}

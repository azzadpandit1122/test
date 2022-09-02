package com.azzadpandit.azadproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.azzadpandit.azadproject.Model.Data;
import com.azzadpandit.azadproject.R;
import com.azzadpandit.azadproject.databinding.TDataViewBinding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;

public class TDataRowAdapter extends RecyclerView.Adapter<TDataRowAdapter.DataView> {

    Context context;
    ArrayList<Data.TData> mainData;

    public TDataRowAdapter(Context context, ArrayList<Data.TData> mainData) {
        this.context = context;
        this.mainData = mainData;
    }

    @NonNull
    @Override
    public DataView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TDataViewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.t_data_view, parent, false);
        return new DataView(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DataView holder, int position) {

        if (holder.getPosition()==0){
            holder.binding.tid.setVisibility(View.VISIBLE);
        }else {
            holder.binding.tid.setVisibility(View.GONE);
        }
        holder.binding.narration.setText(mainData.get(position).getNarration());
        holder.binding.amount.setText("\u20B9 "+mainData.get(position).getAmount());
        holder.binding.tid.setText("Tid :"+mainData.get(position).getTid());

    }

    @Override
    public int getItemCount() {
        return mainData.size();
    }

    public class DataView extends RecyclerView.ViewHolder {

        TDataViewBinding binding;

        public DataView(TDataViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

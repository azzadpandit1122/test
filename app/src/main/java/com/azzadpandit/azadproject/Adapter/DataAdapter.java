package com.azzadpandit.azadproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.azzadpandit.azadproject.Model.Data;
import com.azzadpandit.azadproject.R;
import com.azzadpandit.azadproject.databinding.DataViewBinding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataView> {

    Context context;
    public ArrayList<Data> mainData;
    boolean openclose = false;

    public DataAdapter(Context context, ArrayList<Data> mainData) {
        this.context = context;
        this.mainData = mainData;
    }

    @NonNull
    @Override
    public DataView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DataViewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.data_view, parent, false);
        return new DataView(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DataView holder, int position) {
        holder.binding.mid.setText("Mid " + mainData.get(position).getMid());

        holder.itemView.setOnClickListener(view -> {

            if ( holder.binding.tdata.getVisibility()==View.VISIBLE) {
               holder.binding.tdata.setVisibility(View.GONE);
            }else if (holder.binding.tdata.getVisibility()==View.GONE){
                holder.binding.tdata.setVisibility(View.GONE);

                ArrayList<Data.TData> data = mainData.get(holder.getAdapterPosition()).getData();
                if (data.size() > 0)
                {

//                for (int i = 0; i < data.size(); i++) {
//                    for (int j = i + 1; j < data.size(); j++) {
//                        if (data.get(i).getTid().equals(data.get(j).getTid())) {
//                            data.remove(j).getTid();
//                            j--;
//                        }
//                    }
//                }

//                holder.binding.tdata.setAdapter(new TDataRowAdapter(context, (ArrayList<Data.TData>) removeDuplicates(data))); // correctc

                    holder.binding.tdata.setAdapter(new TDataRowAdapter(context, data));
                    holder.binding.tdata.setVisibility(View.VISIBLE);
                }
            }

        });

//        holder.binding.mid.setOnClickListener(v -> {
//            holder.binding.tdata.setVisibility(View.GONE);
//            ArrayList<Data.TData> data = mainData.get(holder.getAdapterPosition()).getData();
//            if (data.size() > 0) {
//                holder.binding.tdata.setAdapter(new TDataRowAdapter(context, data));
//                holder.binding.tdata.setVisibility(View.VISIBLE);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mainData.size();
    }

    public class DataView extends RecyclerView.ViewHolder {

        DataViewBinding binding;

        public DataView(DataViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.tdata.setHasFixedSize(true);
            binding.tdata.setLayoutManager(new LinearLayoutManager(context));
        }
    }

    public List<Data.TData> removeDuplicates(List<Data.TData> list) {
        // Set set1 = new LinkedHashSet(list);
        Set set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (((Data.TData) o1).getTid().equalsIgnoreCase(((Data.TData) o2).getTid())) {
                    return 0;
                }
                return 1;
            }
        });
        set.addAll(list);
        final List newList = new ArrayList(set);
        return newList;
    }
}

package com.app.discoverytrails.base;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.RecyclerViewHolder> {


    private Context BASE_CONTEXT;
    private int layout_id;
    private List<?> dataList;


    public BaseAdapter(Context BASE_CONTEXT, int layout_id) {
        this.BASE_CONTEXT = BASE_CONTEXT;
        this.layout_id = layout_id;
        this.dataList = new ArrayList<>();
    }

    private ViewDataBinding mViewDataBinding;


    public ViewDataBinding getmViewDataBinding() {
        return mViewDataBinding;
    }


    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        mViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), layout_id, viewGroup, false);
        return new RecyclerViewHolder(mViewDataBinding);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {


//        holder.setIsRecyclable(false);

        onBindViewHold(holder, dataList.get(position));


    }


    public void setItems(List items) {
        int curSize = getItemCount();


        if (items == null) {
            throw new IllegalArgumentException("Cannot set `null` item to the Recycler adapter");
        }
        this.dataList.clear();
        this.dataList.addAll(items);
        notifyItemRangeInserted(curSize, this.dataList.size());
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public void remove(Object item) {
        int position = dataList.indexOf(item);
        if (position > -1) {

            Log.d("44444444444 remove", " ---     " + position);

            dataList.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, dataList.size());

            //   Log.d("44444444444 iiii", " ---     " + new Gson().toJson(getDataList()));
        }
    }


    public List<?> getDataList() {
        return dataList;
    }

    public abstract void onBindViewHold(RecyclerView.ViewHolder viewHolder, Object itemView);


    @Override
    public int getItemCount() {


        int ixt = this.dataList.size() == 0 ? 0 : this.dataList.size();

        return ixt;
    }


    class RecyclerViewHolder extends RecyclerView.ViewHolder {


        ViewDataBinding binding;

        public RecyclerViewHolder(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

    }


}

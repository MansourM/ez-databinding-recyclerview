package ir.masterz.mansour.ez.databinding.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public abstract class DataBindingRecyclerViewAdapter<T> extends RecyclerView.Adapter<DataBindingViewHolder<T>> {

    private ArrayList<T> ItemList;
    private SimpleOnClickListener SimpleOnClickListener;

    public DataBindingRecyclerViewAdapter(ArrayList<T> itemList) {
        ItemList = itemList;
    }

    public DataBindingRecyclerViewAdapter(ArrayList<T> itemList, SimpleOnClickListener simpleOnClickListener) {
        ItemList = itemList;
        SimpleOnClickListener = simpleOnClickListener;
    }

    @NonNull
    @Override
    public DataBindingViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);
        return new DataBindingViewHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(DataBindingViewHolder<T> holder, int position) {
        T obj = getObjForPosition(position);
        if (SimpleOnClickListener != null)
            holder.itemView.setOnClickListener(v -> SimpleOnClickListener.onClick(position));
        holder.bind(obj);
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }

    @Override
    public int getItemCount() {
        return ItemList.size();
    }

    public T getObjForPosition(int position) {
        return ItemList.get(position);
    }

    protected abstract int getLayoutIdForPosition(int position);

}

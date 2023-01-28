package ir.masterz.mansour.ez.databinding.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public abstract class DataBindingRecyclerViewAdapter<T, B> extends RecyclerView.Adapter<DataBindingViewHolder<B>> {

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
    public DataBindingViewHolder<B> onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);
        return new DataBindingViewHolder<>(binding);
    }

    /**
     * !!IMPORTANT!! Don't forget to bind your object with holder.bind(variableId, objectToBind)
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(DataBindingViewHolder<B> holder, int position) {
        if (SimpleOnClickListener != null)
            holder.itemView.setOnClickListener(v -> SimpleOnClickListener.onClick(position));
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

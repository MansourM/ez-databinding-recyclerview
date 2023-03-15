package ir.masterz.mansour.ez.databinding.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * @param <T> Object Type
 * @param <B> Binding Class
 */
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

    //Layout is selected from <B> which is the binding class of that XML
    @NonNull
    @Override
    public DataBindingViewHolder<B> onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        //FIXME
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);
        return new DataBindingViewHolder<>(binding);
    }

    /**
     * !!IMPORTANT!! Don't forget to bind your object with holder.bind(variableId, objectToBind)
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(DataBindingViewHolder<B> holder, int position) {
        if (SimpleOnClickListener != null)
            holder.itemView.setOnClickListener(v -> SimpleOnClickListener.onClick(position));
    }

    /**
     * if you overwrite this method you need to to also overwrite onCreateViewHolder
     **/
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

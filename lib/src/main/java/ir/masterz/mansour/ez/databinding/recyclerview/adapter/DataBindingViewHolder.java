package ir.masterz.mansour.ez.databinding.recyclerview.adapter;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import ir.masterz.mansour.ez.databinding.recyclerview.adapter.BR;

public class DataBindingViewHolder<T> extends RecyclerView.ViewHolder {

    private final ViewDataBinding binding;

    public DataBindingViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(T object) {
        binding.setVariable(BR.objectToBind, object);
        binding.executePendingBindings();
    }

    //get from BR.
    public void bind(int VariableId, T object) {
        binding.setVariable(VariableId, object);
        binding.executePendingBindings();
    }

}

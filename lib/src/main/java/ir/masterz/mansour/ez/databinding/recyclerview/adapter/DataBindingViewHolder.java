package ir.masterz.mansour.ez.databinding.recyclerview.adapter;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class DataBindingViewHolder<T, B> extends RecyclerView.ViewHolder {

    private ViewDataBinding binding;

    public DataBindingViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    //fixme: add support for when each item has a different layout/binding

    //TODO: make this safe!
    //B needs to be a Auto generated DataBinding class!
    public B getBinding() {
        return (B) binding;
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

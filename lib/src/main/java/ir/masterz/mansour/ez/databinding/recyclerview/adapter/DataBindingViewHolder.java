package ir.masterz.mansour.ez.databinding.recyclerview.adapter;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class DataBindingViewHolder<B> extends RecyclerView.ViewHolder {

    private ViewDataBinding binding;

    public DataBindingViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    //TODO: make this safe!
    //B needs to be a Auto generated DataBinding class!
    public B getBinding() {
        return (B) binding;
    }


    //get VariableId from BR., executePendingBindings = true
    public void bind(int variableId, Object object) {
        bind(variableId, object, true);

    }

    //get VariableId from BR.
    public void bind(int variableId, Object object, boolean executePendingBindings) {
        binding.setVariable(variableId, object);
        if (executePendingBindings)
            binding.executePendingBindings();
    }

}

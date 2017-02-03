package com.dabe.baddooooo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dabe.baddooooo.R;
import com.dabe.baddooooo.model.data.local.Product;
import com.dabe.baddooooo.view.views.IProductView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> products;
    private IProductView callbackListener;

    public ProductAdapter(List<Product> products, IProductView callbackListener) {
        this.products = products;
        this.callbackListener = callbackListener;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_list_element, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        final Product product = products.get(position);
        holder.title.setText(product.getSku());
        holder.subtitle.setText(product.getFormattedTransCount());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callbackListener != null) {
                    callbackListener.onProductSelected(product.getSku());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (products != null) {
            return products.size();
        } else {
            return 0;
        }
    }

    public void updateProducts(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.subtitle)
        TextView subtitle;

        private ProductViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

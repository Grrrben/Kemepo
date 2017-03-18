package com.atog.grrrben.kemepo.helpers;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;

import com.atog.grrrben.kemepo.R;
import com.atog.grrrben.kemepo.classes.Product;

import java.util.List;

/**
 * The is the adapter for the product list view
 * - active (switch)
 * - title
 * - price
 */
public class ProductListAdapter extends ArrayAdapter<Product> {

    public static String TAG = "ProductListAdapter";

    public ProductListAdapter(Context context, List<Product> products) {
        super(context, 0, products);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.d(TAG, "getView: running");

        // Get the data item for this position
        Product product = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.product_snippet, parent, false);
        }

        // Lookup view for data population
        Switch active = (Switch) convertView.findViewById(R.id.switch1);
        TextView name = (TextView) convertView.findViewById(R.id.product_name);
        TextView price = (TextView) convertView.findViewById(R.id.product_price);

        name.setText(product.name);
        price.setText(Double.toString(product.price));
        active.setChecked(product.active);

        // Return the completed view to render on screen
        return convertView;
    }
}
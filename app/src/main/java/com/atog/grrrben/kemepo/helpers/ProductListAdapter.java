package com.atog.grrrben.kemepo.helpers;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.atog.grrrben.kemepo.R;
import com.atog.grrrben.kemepo.classes.Product;

import java.util.List;

/**
 * Created by Gerben on 21-Jun-15.
 * Dit is de view offer_search_result_item voor de lijst met daghappen
 * - title
 * - description
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
        TextView name = (TextView) convertView.findViewById(R.id.product_name);
        name.setText(product.name);

        // Return the completed view to render on screen
        return convertView;
    }
}
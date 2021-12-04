package as.course.foodslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class FoodsAdapter extends ArrayAdapter<Food>  {
    private LayoutInflater inflater;
    private int layout;
    private List<Food> foods;

    public FoodsAdapter(@NonNull Context context,
                        int resource,
                        @NonNull List<Food> objects) {
        super(context, resource, objects);
        this.foods = objects;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view=inflater.inflate(this.layout, parent, false);

        TextView foodNameView = view.findViewById(R.id.foodName);
        TextView priceView = view.findViewById(R.id.price);

        Food food = foods.get(position);

        foodNameView.setText(food.getName());
        priceView.setText(String.valueOf(food.getPrice()));

        return view;
    }

}

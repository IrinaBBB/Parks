package ru.irinavb.parks.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ru.irinavb.parks.R;
import ru.irinavb.parks.model.Park;

public class ParkRecyclerViewAdapter extends RecyclerView.Adapter<ParkRecyclerViewAdapter.ParkViewHolder> {

    private final List<Park> parks;

    public ParkRecyclerViewAdapter(List<Park> parks) {
        this.parks = parks;
    }

    @NonNull
    @Override
    public ParkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_parks, parent, false);
        return new ParkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParkViewHolder holder, int position) {
        Park park = this.parks.get(position);
        holder.parkName.setText(park.getName());
        holder.parkType.setText(park.getDesignation());
        holder.parkState.setText(park.getStates());

        if (park.getImages().size() > 0) {
            Picasso.get()
                    .load(park.getImages().get(0).getUrl())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(android.R.drawable.stat_notify_error)
                    .resize(300, 300)
                    .centerCrop()
                    .into(holder.parkImage);
        }
    }

    @Override
    public int getItemCount() {
        return parks.size();
    }

    class ParkViewHolder extends RecyclerView.ViewHolder {

        public ImageView parkImage;
        public TextView parkName, parkType, parkState;

        public ParkViewHolder(@NonNull View itemView) {
            super(itemView);
            parkImage = itemView.findViewById(R.id.park_image_view);
            parkName = itemView.findViewById(R.id.park_name_text_view);
            parkType = itemView.findViewById(R.id.park_category_text_view);
            parkState = itemView.findViewById(R.id.park_state_text_view);
        }
    }

}

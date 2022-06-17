package ru.irinavb.parks.adapter;

import android.view.View;

import ru.irinavb.parks.model.Park;

public interface OnParkClickListener {
    void onParkClicked(View view, Park park);
}

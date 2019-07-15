package com.example.taipeizoodemo

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("app:visibility")
fun visibility(view: View, visibility: Int) {
    view.visibility = visibility
}
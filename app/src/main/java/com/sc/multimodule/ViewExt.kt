package com.sc.multimodule

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("app:isVisible")
fun View.isVisible(visibility: Boolean?) {
    this.visibility = if (visibility == true) View.VISIBLE else View.INVISIBLE
}
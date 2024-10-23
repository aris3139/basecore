package com.base.base_source.extentions

import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified T : ViewBinding> Fragment.viewBinding() =
    ViewBindingExtension(T::class.java)

class ViewBindingExtension<T : ViewBinding>(
    private val bindingClass: Class<T>
) : ReadOnlyProperty<Fragment, T> {

    private var binding: T? = null

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        binding?.let { return it }

        val inflateMethod = bindingClass.getMethod("inflate", LayoutInflater::class.java)
        val viewBinding = inflateMethod.invoke(null, thisRef.layoutInflater) as T

        return viewBinding.also { this.binding = it }
    }
}

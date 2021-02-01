package com.example.testproject.ui.base

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.testproject.R
import com.example.testproject.util.extentions.hideKeyboard

abstract class BaseActivity<B : ViewDataBinding>(private val layoutId: Int) : AppCompatActivity(),
    BaseActivityActions {

    abstract fun initUI()
    open fun initObservers() {}
    open fun iniListeners() {}

    private var viewBinding: B? = null
    protected val binding: B
        get() = viewBinding
            ?: throw IllegalStateException("Trying to access the binding outside of the view lifecycle.")

    private val mProgressDialog: AlertDialog by lazy {
        AlertDialog.Builder(this)
            .setView(R.layout.progressbar)
            .setCancelable(false)
            .create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView<B>(this, layoutId)
        initUI()
        iniListeners()
    }

    override fun onDestroy() {
        viewBinding = null
        super.onDestroy()
    }

    fun hideKeyboard() {
        currentFocus?.hideKeyboard()
    }

    override fun showProgressDialog(state: Boolean) {
        with(mProgressDialog) {
            this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            if (state) show() else dismiss()
        }
    }
}

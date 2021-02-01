package com.example.testproject.ui.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<B : ViewBinding>(private val layoutId: Int) : Fragment() {

    private var viewBinding: B? = null

    protected val binding: B
        get() = viewBinding
            ?: throw IllegalStateException("Trying to access the binding outside of the view lifecycle.")

    protected val navController by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        savedInstanceState?.clear()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hideKeyboardListener(view)
        initUI()
        initObservers()
        initListeners()
    }

    override fun onDestroyView() {
        viewBinding = null
        super.onDestroyView()
    }

    open fun initUI() {}
    open fun initListeners() {}
    open fun initObservers() {}

    private fun hideKeyboardListener(view: View) {
        view.setOnTouchListener { v, _ ->
            (activity as? BaseActivity<*>)?.hideKeyboard()
            v.performClick()
            return@setOnTouchListener false
        }
    }

    protected fun showErrorLog(text: String? = null, tr: Throwable? = null) {
        Log.e(navController.currentDestination?.label.toString(), text ?: "error", tr)
    }

    protected fun showLog(text: String) {
        Log.d(navController.currentDestination?.label.toString(), text)
    }

    protected fun showToast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_LONG).show()
    }

    protected fun showProgressDialog(isLoading: Boolean) {
        (requireActivity() as? BaseActivityActions)?.showProgressDialog(isLoading)
    }
}

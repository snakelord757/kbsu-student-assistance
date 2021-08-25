package com.snakelord.pets.kbsustudentassistance.presentation.common.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.snakelord.pets.kbsustudentassistance.presentation.application.KbsuStudentAssistanceApp
import com.snakelord.pets.kbsustudentassistance.presentation.common.extensions.moveToTop
import com.snakelord.pets.kbsustudentassistance.presentation.common.state.UIStates
import com.snakelord.pets.kbsustudentassistance.presentation.common.viewmodel.BaseViewModel

abstract class BaseFragment<VM : BaseViewModel> : Fragment() {

    private val factory = KbsuStudentAssistanceApp.applicationComponent.viewModelFactory()
    protected lateinit var viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this, factory)[getViewModelClass()]
        viewModel.uiStates.observe(viewLifecycleOwner, ::updateUIState)
    }

    abstract fun getViewModelClass(): Class<VM>

    open fun updateUIState(state: UIStates) {}

    protected fun showError(@StringRes errorMessageResId: Int) {
        Snackbar.make(requireView(), errorMessageResId, Snackbar.LENGTH_LONG)
            .moveToTop()
            .show()
    }
}
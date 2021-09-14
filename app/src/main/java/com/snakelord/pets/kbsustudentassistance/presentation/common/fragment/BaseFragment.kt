package com.snakelord.pets.kbsustudentassistance.presentation.common.fragment

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.snakelord.pets.kbsustudentassistance.R
import com.snakelord.pets.kbsustudentassistance.presentation.application.KbsuStudentAssistanceApp
import com.snakelord.pets.kbsustudentassistance.presentation.common.dialog.ErrorDialog
import com.snakelord.pets.kbsustudentassistance.presentation.common.state.UIStates

/**
 * Базовый фрагмент для всех фрагментов в приложении
 *
 * Содержит базовое поведение для:
 * * отображения ошибок,
 * * изменения сотояния экрана в зависимости от [UIStates]
 *
 * @author Murad Luguev on 27-08-2021
 */
abstract class BaseFragment : Fragment() {

    protected val factory = KbsuStudentAssistanceApp
        .applicationComponent
        .viewModelFactory()

    @IdRes
    protected val navGraphId = R.id.nav_graph

    /**
     * Функция для обновления экрана в зависимости от состояния [UIStates]
     *
     * @param state экземпляр sealed-класса [UIStates]
     */
     protected fun updateUIState(state: UIStates) {
        when (state) {
            is UIStates.Loading -> {
                onLoading()
            }
            is UIStates.Successful -> {
                onSuccess()
            }
            is UIStates.Error -> {
                showError(state.error.errorMessageResId)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUnspecifiedOrientation()
    }

    /**
     * Функция для отображения состояния загрузки
     */
    open fun onLoading() {
        //Переопределяется по мере необходимости
    }

    /**
     * Функция для отображения успеха операции
     */
    open fun onSuccess() {
        //Переопределяется по мере необходимости
    }

    /**
     * Функция для отображения ошибки
     *
     * Отображает диалоговое окно с сообщением об ошибке
     *
     * @param errorMessageResId строковый ресурс для отоюражения ошибки
     */
    protected open fun showError(@StringRes errorMessageResId: Int) {
        val errorDialog = ErrorDialog.Builder()
            .errorMessage(errorMessageResId)
            .onTryAction(getOnTryAction())
            .create()
        errorDialog.show(parentFragmentManager, ERROR_DIALOG_TAG)
    }

    /**
     * Функция, которая устанавливает действие для повтора в диалоговом окне ошибки
     *
     * @return функцию, которая не возвращает ничего
     */
    open fun getOnTryAction(): (() -> Unit)? {
        return null
    }

    @SuppressLint("SourceLockedOrientationActivity")
    protected fun setPortraitOrientation() {
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    private fun setUnspecifiedOrientation() {
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
    }

    companion object {
        private const val ERROR_DIALOG_TAG = "error_dialog"
    }
}
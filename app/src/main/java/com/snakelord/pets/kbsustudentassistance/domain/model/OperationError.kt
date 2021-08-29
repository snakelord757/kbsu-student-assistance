package com.snakelord.pets.kbsustudentassistance.domain.model

import androidx.annotation.StringRes

/**
 * Модель ошибки, возникшей во время выполнения какой-либо операции
 *
 * @property errorMessageResId идентификатор строкового ресурса для отображения ошибки [StringRes]
 *
 * @author Murad Luguev on 27-08-2021
 */
data class OperationError(
    @StringRes
    val errorMessageResId: Int
)

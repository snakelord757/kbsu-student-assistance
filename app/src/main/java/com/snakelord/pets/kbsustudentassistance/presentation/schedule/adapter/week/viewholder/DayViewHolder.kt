package com.snakelord.pets.kbsustudentassistance.presentation.schedule.adapter.week.viewholder

import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.snakelord.pets.kbsustudentassistance.R
import com.snakelord.pets.kbsustudentassistance.presentation.common.extensions.viewContext
import com.snakelord.pets.kbsustudentassistance.databinding.ItemDayBinding
import com.snakelord.pets.kbsustudentassistance.domain.model.schedule.DayOfWeek

/**
 * ViewHolder для отображения дня недели
 *
 * @property itemDayBinding ViewBinding для работы с View
 * @property itemClickListener слушатель нажатий для передачи позиции элемента
 *
 * @author Murad Luguev on 01-09-2021
 */
class DayViewHolder(
    private val itemDayBinding: ItemDayBinding,
    private val itemClickListener: (Int) -> Unit,
) : RecyclerView.ViewHolder(itemDayBinding.root) {

    /**
     * Связывает поля из модели дня недели [DayOfWeek] с View
     *
     * @param dayOfWeek модель дня недели [DayOfWeek]
     */
    fun bind(dayOfWeek: DayOfWeek) {
        itemDayBinding.dayTextView.text = dayOfWeek.dayOfMonth.toString()
        itemDayBinding.dayNameTextView.text = itemView.context.getString(dayOfWeek.dayOfWeek)
        itemView.setOnClickListener { itemClickListener.invoke(adapterPosition) }
    }

    /**
     * Обновляет состояние [RecyclerView.ViewHolder] если он выбран
     *
     * @param selectedItem индекс выбранного элемента
     */
    fun updateSelectState(selectedItem: Int) {
        val isSelected = (selectedItem == adapterPosition)
        if (isSelected)
            updateViewHolder(isSelected = isSelected)
        else
            updateViewHolder(
                isSelected =isSelected,
                dayInMonthColor = R.color.primaryTextColor,
                dayInMonth = android.R.color.darker_gray
            )
    }

    private fun updateViewHolder(
        isSelected: Boolean,
        @ColorRes dayInMonthColor: Int = R.color.white,
        @ColorRes dayInMonth: Int = R.color.white
    ) {
        itemView.isSelected = isSelected

        itemDayBinding.dayTextView.setTextColor(
            ContextCompat.getColor(
                viewContext,
                dayInMonthColor
            )
        )

        itemDayBinding.dayNameTextView.setTextColor(
            ContextCompat.getColor(
                viewContext,
                dayInMonth
            )
        )
    }
}

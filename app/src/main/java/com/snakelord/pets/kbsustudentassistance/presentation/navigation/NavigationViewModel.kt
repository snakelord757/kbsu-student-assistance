package com.snakelord.pets.kbsustudentassistance.presentation.navigation

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.snakelord.pets.kbsustudentassistance.data.model.location.LocationModel
import com.snakelord.pets.kbsustudentassistance.domain.interactor.navigation.LocationInteractor
import com.snakelord.pets.kbsustudentassistance.presentation.application.KbsuStudentAssistanceApp
import com.yandex.mapkit.MapKitFactory

/**
 * ViewModel для фрагмента навигации
 *
 * @property locationInteractor интерактор для отображения локаций
 *
 * @author Murad Luguev on 26-08-2021
 */
class NavigationViewModel(
    private val locationInteractor: LocationInteractor
) : AndroidViewModel(KbsuStudentAssistanceApp.application) {

    private val currentLocationMutableLiveData = MutableLiveData<LocationModel>()
    val currentLocation: LiveData<LocationModel>
        get() = currentLocationMutableLiveData

    private val locationsMutableLiveData = MutableLiveData<List<LocationModel>>()
    val locations: LiveData<List<LocationModel>>
        get() = locationsMutableLiveData

    init {
        MapKitFactory.initialize(getApplication())
        prepareMap()
    }

    private fun prepareMap() {
        currentLocationMutableLiveData.value = locationInteractor.getMainEnterPoint()

        locationsMutableLiveData.value = locationInteractor.getEnterPoints()
    }

    /**
     * Метод для отображения выбранной локации. Необходим для восстановления состояния
     * при изменении конфигурации
     *
     * @param locationModel экземпляр [LocationModel] выбранной локации
     */
    fun showSelectedEntrance(locationModel: LocationModel) {
        currentLocationMutableLiveData.value = locationModel
    }
}
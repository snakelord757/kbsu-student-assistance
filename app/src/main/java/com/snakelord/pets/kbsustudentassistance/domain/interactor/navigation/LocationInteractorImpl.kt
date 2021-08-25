package com.snakelord.pets.kbsustudentassistance.domain.interactor.navigation

import com.snakelord.pets.kbsustudentassistance.data.model.location.LocationModel
import com.snakelord.pets.kbsustudentassistance.domain.repository.navigation.LocationRepository
import javax.inject.Inject

/**
 * Имплементация интерфейса [LocationInteractor]
 *
 * @property locationRepository репозиторий для получения списка локаций
 *
 * @author Murad Luguev on 26-08-2021
 */
class LocationInteractorImpl @Inject constructor(
    private val locationRepository: LocationRepository
) : LocationInteractor {

    override fun getEnterPoints(): List<LocationModel> {
        return locationRepository.getEnterPoints()
    }

    override fun getMainEnterPoint(): LocationModel {
        return locationRepository.getMainEnterPoint()
    }
}
package com.snakelord.pets.kbsustudentassistance.di.pass.component

import com.snakelord.pets.kbsustudentassistance.di.common.component.ApplicationComponent
import com.snakelord.pets.kbsustudentassistance.di.pass.module.PassModule
import com.snakelord.pets.kbsustudentassistance.di.pass.scope.PassScope
import com.snakelord.pets.kbsustudentassistance.domain.interactor.pass.PassInteractor
import dagger.Component

@Component(
    dependencies = [ApplicationComponent::class],
    modules = [PassModule::class]
)
@PassScope
interface PassComponent {
    fun passInteractor(): PassInteractor
}
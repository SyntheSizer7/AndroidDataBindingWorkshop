package com.synthesizer7.androiddatabinding.workshop.profile

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    val title = MutableLiveData<String>()
    val firstName = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()
    val nickname = MutableLiveData<String>()
    val isChecked = MutableLiveData<Boolean>()
    val openSettingsScreen = MutableLiveData<Unit>()

    fun loadProfile() {
        // Load profile from repository
        title.value = "Profile"
        firstName.value = "SyntheSizer"
        lastName.value = "Seven"
        nickname.value = "7"
    }

    fun goToSettingsScreen() {
        openSettingsScreen.value = Unit
    }

}
package com.gilorroristore.horoscapplication

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class HoroscApplication @Inject constructor() : Application() {
}
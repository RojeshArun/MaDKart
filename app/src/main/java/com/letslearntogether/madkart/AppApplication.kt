package com.letslearntogether.madkart

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
//Step 1 Hilt -  Application will tell to Start generating Code
@HiltAndroidApp
class AppApplication: Application()

//Hilt - Uses Dagger - Famous depedency Injection lib but its little complext
//Hilt is little simpler and cleaner and easier
//Hilt under the hood uses Dagger

//DI
//D - Dependency Inversion principle
//
//Depend on abstraction, do not depend on concretion
// Eg: buy Laptop



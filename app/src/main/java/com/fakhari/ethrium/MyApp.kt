package com.fakhari.ethrium

import android.app.Application
import org.web3j.crypto.ECKeyPair

//project application class
class MyApp : Application() {

companion object{
    lateinit var ecKeyPair : ECKeyPair
}
    override fun onCreate() {
        super.onCreate()
    }
}
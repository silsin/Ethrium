package com.fakhari.ethrium.utils

import android.os.Build
import androidx.annotation.RequiresApi
import org.web3j.crypto.Bip39Wallet
import org.web3j.crypto.MnemonicUtils
import java.nio.file.Files
import java.security.SecureRandom


class ethereum {


   @RequiresApi(Build.VERSION_CODES.O)
   fun CreateMneminicKet(): String? {
       MnemonicUtils.getWords();
       val bytes = ByteArray(16)
        SecureRandom.getInstanceStrong().nextBytes(bytes)
        return MnemonicUtils.generateMnemonic(bytes)
   }
    @RequiresApi(Build.VERSION_CODES.O)
    fun GenerateAddress(mnemonic:String): Bip39Wallet? {
        val tempFile = Files.createTempFile(null, null).toFile()
       return Bip39Wallet(tempFile.name, mnemonic);
    }

}
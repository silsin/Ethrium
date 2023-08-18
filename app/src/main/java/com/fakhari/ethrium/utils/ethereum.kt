package com.fakhari.ethrium.utils

import android.os.Build
import androidx.annotation.RequiresApi
import org.web3j.crypto.Bip39Wallet
import org.web3j.crypto.MnemonicUtils
import org.web3j.crypto.WalletUtils
import java.security.SecureRandom


class ethereum {


   @RequiresApi(Build.VERSION_CODES.O)
   fun CreateMneminicKet(): String? {
       MnemonicUtils.getWords();
       val bytes = ByteArray(16)
        SecureRandom.getInstanceStrong().nextBytes(bytes)
        return MnemonicUtils.generateMnemonic(bytes)
   }
    fun GenerateAddress(password:String,mnemonic:String): Bip39Wallet? {
      return  WalletUtils.generateBip39WalletFromMnemonic(password,mnemonic,null);
    }

}
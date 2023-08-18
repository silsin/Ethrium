package com.fakhari.ethrium.View

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.fakhari.ethrium.MyApp
import com.fakhari.ethrium.R
import com.fakhari.ethrium.databinding.FragmentFirstBinding
import com.fakhari.ethrium.utils.ethereum
import org.web3j.crypto.Credentials
import org.web3j.crypto.WalletUtils

class FirstFragment : Fragment() , View.OnClickListener {

    private var _binding: FragmentFirstBinding? = null
    private var _bundle : Bundle? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //generate inital address
        Regenrate()
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //initialize the view actions (regenerate and sign)
    private fun  initView(){
        binding.reGenerate.setOnClickListener(this)
        binding.SignAMessage.setOnClickListener(this)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun Regenrate(){
        //data generator
        val data = ethereum().CreateMneminicKet()
        var wallet =  ethereum().GenerateAddress(data!!)
        val credentials: Credentials = WalletUtils.loadBip39Credentials("", wallet!!.mnemonic)

        //setup global key
        MyApp.ecKeyPair = credentials.ecKeyPair

        //data setter to view
        binding.privateData.text = credentials.ecKeyPair.privateKey.toString()
        binding.addressData.text = credentials.address
        binding.mnemonicData.text = data

        //bundle message to send anothe fragment
        _bundle = bundleOf("sampleMessage" to data)
    }

    override fun onClick(p0: View?) {
       when(p0?.id){
           R.id.re_generate->{
               Regenrate()
           }
           R.id.Sign_a_message->{
               findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment,_bundle)
           }
       }

    }
}
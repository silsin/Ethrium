package com.fakhari.ethrium.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.fakhari.ethrium.R
import com.fakhari.ethrium.databinding.FragmentSecondBinding
import com.fakhari.ethrium.utils.ethereum
import org.web3j.crypto.ECKeyPair
import org.web3j.crypto.Sign
import java.math.BigInteger


class SecondFragment : Fragment(),View.OnClickListener {

    private var _binding: FragmentSecondBinding? = null
    private var simpleMessage : String = ""
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.SignAMessage.setOnClickListener {
            signMessage()
        }
        InitBundle()
         InitView()



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //init view
    private  fun InitView(){
        binding.messageData.setText(simpleMessage)
        binding.SignAMessage.setOnClickListener(this)
    }
    //get data from pervius fragment
    private fun InitBundle(){
        simpleMessage = arguments?.getString("sampleMessage").toString()
    }
    private fun  signMessage(){
     var signMessage =  ethereum().SignMessage(simpleMessage)
        binding?.signData?.text = signMessage?.s?.joinToString(" ")
        binding?.nonceData?.text = signMessage?.v?.joinToString(" ")
    }

    override fun onClick(p0: View?) {
      signMessage()
    }
}
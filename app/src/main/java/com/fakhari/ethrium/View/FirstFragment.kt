package com.fakhari.ethrium.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.fakhari.ethrium.R
import com.fakhari.ethrium.databinding.FragmentFirstBinding
import com.fakhari.ethrium.utils.ethereum
import org.web3j.crypto.MnemonicUtils

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() , View.OnClickListener {

    private var _binding: FragmentFirstBinding? = null

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

        binding.SignAMessage.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
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
    }

    fun Regenrate(){
        val data = ethereum().CreateMneminicKet()
        try {
            var wallet = data?.let { ethereum().GenerateAddress("abcd", it) }
        }catch (e:Exception){
        }
        binding.mnemonicData.text = data
    }

    override fun onClick(p0: View?) {
       when(p0?.id){
           R.id.re_generate->{
               Regenrate()
           }
       }

    }
}
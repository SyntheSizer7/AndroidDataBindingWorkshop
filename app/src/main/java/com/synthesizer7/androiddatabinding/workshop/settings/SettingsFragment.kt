package com.synthesizer7.androiddatabinding.workshop.settings

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.synthesizer7.androiddatabinding.workshop.R
import com.synthesizer7.androiddatabinding.workshop.databinding.FragmentSettingsBinding
import com.synthesizer7.androiddatabinding.workshop.extension.getViewModel

class SettingsFragment : Fragment() {

    companion object {
        val TAG = this::class.java.canonicalName as String

        fun newInstance(): SettingsFragment {
            return SettingsFragment()
        }
    }

    private val viewModel: SettingsViewModel by lazy {
        getViewModel {
            SettingsViewModel()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = DataBindingUtil.inflate<FragmentSettingsBinding>(inflater,
                R.layout.fragment_settings, container, false).apply {
            model = viewModel
        }
        view.setLifecycleOwner(this)

        return view.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadProfile()
    }

    private fun bindingViewModel() {

    }

}
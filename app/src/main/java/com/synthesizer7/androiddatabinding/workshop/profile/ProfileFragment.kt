package com.synthesizer7.androiddatabinding.workshop.profile

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.synthesizer7.androiddatabinding.workshop.R
import com.synthesizer7.androiddatabinding.workshop.databinding.FragmentProfileBinding
import com.synthesizer7.androiddatabinding.workshop.extension.getViewModel
import com.synthesizer7.androiddatabinding.workshop.settings.SettingsFragment

class ProfileFragment : Fragment() {

    companion object {
        val TAG = this::class.java.canonicalName as String

        fun newInstance(): ProfileFragment {
            return ProfileFragment()
        }
    }

    private val viewModel: ProfileViewModel by lazy {
        getViewModel {
            ProfileViewModel()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = DataBindingUtil.inflate<FragmentProfileBinding>(inflater,
                R.layout.fragment_profile, container, false).apply {
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
        viewModel.openSettingsScreen.observe(this, Observer {
            fragmentManager?.let {
                it.beginTransaction()
                        .replace(android.R.id.content, SettingsFragment.newInstance(), ProfileFragment.TAG)
                        .addToBackStack("")
                        .commit()
            }
        })
    }

}
package com.idealorb.tracketv.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.idealorb.tracketv.R

class ShowTrackingFragment : Fragment() {

    companion object {
        fun newInstance() = ShowTrackingFragment()
    }

    private lateinit var viewModel: ShowTrackingViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.show_tracking_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ShowTrackingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
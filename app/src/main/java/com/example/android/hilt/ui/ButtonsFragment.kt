package com.example.android.hilt.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.android.hilt.R
import com.example.android.hilt.data.LoggerDataSource
import com.example.android.hilt.data.local.LoggerLocalDataSource
import com.example.android.hilt.databinding.FragmentButtonsBinding
import com.example.android.hilt.di.LocalLogger
import com.example.android.hilt.di.MemoryLogger
import com.example.android.hilt.navigator.AppNavigator
import com.example.android.hilt.navigator.Screens
import com.example.samplemodule.SampleObject
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ButtonsFragment : Fragment() {

    @Inject @LocalLogger
    lateinit var logger: LoggerDataSource
    @Inject lateinit var navigator: AppNavigator


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentButtonsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.button1).setOnClickListener {
            logger.addLog("Interaction with 'Button 1'")
        }

        view.findViewById<Button>(R.id.button2).setOnClickListener {
            logger.addLog("Interaction with 'Button 2'")
        }

        view.findViewById<Button>(R.id.button3).setOnClickListener {
            logger.addLog("Interaction with 'Button 3'")
        }

        view.findViewById<Button>(R.id.all_logs).setOnClickListener {
            navigator.navigateTo(Screens.LOGS)
        }

        view.findViewById<Button>(R.id.delete_logs).setOnClickListener {
            logger.removeLogs()
        }
    }
}

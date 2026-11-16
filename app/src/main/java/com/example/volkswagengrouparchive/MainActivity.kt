package com.example.volkswagengrouparchive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.volkswagengrouparchive.ui.VolkswagenGroupApp
import com.example.volkswagengrouparchive.ui.theme.VolkswagenGroupArchiveTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VolkswagenGroupArchiveTheme {
                    VolkswagenGroupApp()
                }
            }
        }
    }


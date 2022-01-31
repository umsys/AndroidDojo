package com.example.trycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.rememberCoroutineScope
import com.example.trycompose.ui.theme.TryComposeTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TryComposeTheme {
                val modalBottomSheetState = rememberModalBottomSheetState(
                    ModalBottomSheetValue.Hidden
                )
                val coroutineScope = rememberCoroutineScope()

                BottomSheet(
                    coroutineScope = coroutineScope,
                    modalBottomSheetState = modalBottomSheetState,
                ) {
                    Column {
                        AppBar(modalBottomSheetState)
                        Conversation(SampleData.conversationSample)
                    }
                }
            }
        }
    }
}

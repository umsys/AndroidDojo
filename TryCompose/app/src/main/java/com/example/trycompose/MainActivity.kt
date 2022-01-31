package com.example.trycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import com.example.trycompose.ui.theme.TryComposeTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TryComposeTheme {
                val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
                    bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
                )
                val coroutineScope = rememberCoroutineScope()

                BottomSheet(
                    coroutineScope = coroutineScope,
                    bottomSheetScaffoldState = bottomSheetScaffoldState,
                ) {
                    Column {
                        AppBar(bottomSheetScaffoldState)
                        Conversation(SampleData.conversationSample)
                    }
                }
            }
        }
    }
}

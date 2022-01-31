package com.example.trycompose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trycompose.ui.theme.TryComposeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun BottomSheet(
    coroutineScope: CoroutineScope,
    modalBottomSheetState: ModalBottomSheetState,
    content: @Composable () -> Unit
) {
    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetContent = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "CLOSE",
                    Modifier
                        .padding(top = 32.dp)
                        .align(
                            alignment = Alignment.End
                        )
                        .clickable {
                            coroutineScope.launch {
                                modalBottomSheetState.show()
                            }
                        })
                Spacer(modifier = Modifier.height(50.dp))
            }
        },
        sheetShape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
        sheetBackgroundColor = Color(0xfff5f5f5)
    ) {
        content.invoke()
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun PreviewBottomSheet() {
    TryComposeTheme {
        BottomSheet(
            coroutineScope = rememberCoroutineScope(),
            modalBottomSheetState = rememberModalBottomSheetState(
                ModalBottomSheetValue.Expanded
            )
        ) {
            Column {
                AppBar(
                    rememberModalBottomSheetState(
                        ModalBottomSheetValue.Expanded
                    )
                )
                Conversation(SampleData.conversationSample)
            }
        }
    }
}

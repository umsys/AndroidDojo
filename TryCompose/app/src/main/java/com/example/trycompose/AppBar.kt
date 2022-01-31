package com.example.trycompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trycompose.ui.theme.TryComposeTheme
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun AppBar(modalBottomSheetState: ModalBottomSheetState) {
    val scope = rememberCoroutineScope()
    Column(
        horizontalAlignment = Alignment.End,
        modifier = Modifier
            .background(
                color = MaterialTheme.colors.secondary
            )
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_open_24),
            contentDescription = "Close button",
            alignment = Alignment.CenterEnd,
            modifier = Modifier
                .size(40.dp)
                .clickable {
                    scope.launch {
                        if (modalBottomSheetState.isVisible) {
                            modalBottomSheetState.hide()
                        } else {
                            modalBottomSheetState.show()
                        }
                    }
                }
        )
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun PreviewAppBar() {
    TryComposeTheme {
        AppBar(
            rememberModalBottomSheetState(
                ModalBottomSheetValue.Hidden
            )
        )
    }
}
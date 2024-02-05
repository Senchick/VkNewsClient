package com.sench.vknewsclient.util

import android.content.res.Configuration
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sench.vknewsclient.ui.theme.VkNewsClientTheme

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
annotation class PreviewTheme

@Composable
fun PreviewTheme(content: @Composable () -> Unit) {
    VkNewsClientTheme {
        Surface {
            content()
        }
    }
}
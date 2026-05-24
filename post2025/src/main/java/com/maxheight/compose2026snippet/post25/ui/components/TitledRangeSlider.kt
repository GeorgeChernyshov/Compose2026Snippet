package com.maxheight.compose2026snippet.post25.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewWrapper
import com.maxheight.compose2026snippet.post25.ui.theme.ThemePreviewWrapper

@Composable
fun TitledRangeSlider(
    title: String,
    value: ClosedFloatingPointRange<Float>,
    onValueChange: (ClosedFloatingPointRange<Float>) -> Unit,
    modifier: Modifier = Modifier,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f
) {
    Column(modifier = modifier) {
        Text(title)

        RangeSlider(
            value = value,
            onValueChange = onValueChange,
            valueRange = valueRange
        )
    }
}

@PreviewWrapper(ThemePreviewWrapper::class)
@Preview
@Composable
fun TitledRangeSliderPreview() {
    TitledRangeSlider(
        title = "Title",
        value = 0.2f..0.7f,
        onValueChange = {}
    )
}
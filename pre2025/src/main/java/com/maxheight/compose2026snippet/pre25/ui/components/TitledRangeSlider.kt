package com.maxheight.compose2026snippet.pre25.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.maxheight.compose2026snippet.pre25.ui.theme.Compose2025SnippetTheme

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

@Preview
@Composable
fun TitledRangeSliderPreview() {
    Compose2025SnippetTheme {
        TitledRangeSlider(
            title = "Title",
            value = 0.2f..0.7f,
            onValueChange = {}
        )
    }
}
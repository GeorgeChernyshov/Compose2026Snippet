package com.maxheight.compose2026snippet.pre25.ui.screen.grid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.maxheight.compose2026snippet.pre25.R
import com.maxheight.compose2026snippet.pre25.ui.components.TitledRangeSlider
import com.maxheight.compose2026snippet.pre25.ui.theme.Compose2025SnippetTheme
import com.maxheight.compose2026snippet.pre25.ui.util.distanceToOne
import com.maxheight.compose2026snippet.pre25.ui.util.width

@Composable
fun GridScreen() {
    var middleColumnHorizontalPosition by remember { mutableStateOf(0.33f..0.67f) }
    var middleRowVerticalPosition by remember { mutableStateOf(0.33f..0.67f) }

    Surface {
        Column(
            modifier = Modifier
                .safeDrawingPadding()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(stringResource(R.string.grid_description))

            Grid(
                middleColumnHorizontalPosition = middleColumnHorizontalPosition,
                middleRowVerticalPosition = middleRowVerticalPosition,
                modifier = Modifier.weight(1f)
            )

            TitledRangeSlider(
                title = stringResource(R.string.grid_slider_columns),
                value = middleColumnHorizontalPosition,
                onValueChange = { middleColumnHorizontalPosition = it }
            )

            TitledRangeSlider(
                title = stringResource(R.string.grid_slider_rows),
                value = middleRowVerticalPosition,
                onValueChange = { middleRowVerticalPosition = it }
            )
        }
    }
}

@Composable
fun Grid(
    middleColumnHorizontalPosition: ClosedFloatingPointRange<Float>,
    middleRowVerticalPosition: ClosedFloatingPointRange<Float>,
    modifier: Modifier = Modifier,
    gap: Dp = 8.dp
) {
    Column(
        modifier = Modifier.then(modifier),
        verticalArrangement = Arrangement.spacedBy(gap)
    ) {
        Row(
            modifier = Modifier.weight(middleRowVerticalPosition.endInclusive),
            horizontalArrangement = Arrangement.spacedBy(gap)
        ) {
            GridTile(
                number = 1,
                modifier = Modifier.weight(middleColumnHorizontalPosition.endInclusive),
            )

            Column(
                modifier = Modifier.weight(middleColumnHorizontalPosition.distanceToOne),
                verticalArrangement = Arrangement.spacedBy(gap)
            ) {
                GridTile(
                    number = 2,
                    modifier = Modifier.weight(middleRowVerticalPosition.start)
                )

                GridTile(
                    number = 3,
                    modifier = Modifier.weight(middleRowVerticalPosition.width)
                )
            }
        }

        Row(
            modifier = Modifier.weight(middleRowVerticalPosition.distanceToOne),
            horizontalArrangement = Arrangement.spacedBy(gap)
        ) {
            GridTile(
                number = 4,
                modifier = Modifier.weight(middleColumnHorizontalPosition.start)
            )

            GridTile(
                number = 5,
                modifier = Modifier.weight(
                    middleColumnHorizontalPosition.width
                        .plus(middleColumnHorizontalPosition.distanceToOne)
                )
            )
        }
    }
}

@Composable
fun GridTile(
    number: Int,
    modifier: Modifier = Modifier
) {
    Card(modifier = Modifier.fillMaxSize()
        .then(modifier)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(number.toString())
        }
    }
}

@Composable
@Preview
fun GridTilePreview() {
    Compose2025SnippetTheme {
        GridTile(1)
    }
}

@Composable
@Preview
fun GridPreview() {
    Compose2025SnippetTheme {
        Grid(
            middleColumnHorizontalPosition = 0.33f..0.67f,
            middleRowVerticalPosition = 0.33f..0.67f
        )
    }
}

@Composable
@Preview
fun GridScreenPreview() {
    Compose2025SnippetTheme {
        GridScreen()
    }
}
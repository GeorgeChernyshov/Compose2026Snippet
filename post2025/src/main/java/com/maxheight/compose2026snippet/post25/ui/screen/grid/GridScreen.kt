package com.maxheight.compose2026snippet.post25.ui.screen.grid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalGridApi
import androidx.compose.foundation.layout.Grid
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
import androidx.compose.ui.tooling.preview.PreviewWrapper
import androidx.compose.ui.unit.dp
import com.maxheight.compose2026snippet.post25.R
import com.maxheight.compose2026snippet.post25.ui.components.TitledRangeSlider
import com.maxheight.compose2026snippet.post25.ui.theme.ThemePreviewWrapper
import com.maxheight.compose2026snippet.post25.ui.util.distanceToOne
import com.maxheight.compose2026snippet.post25.ui.util.width

@OptIn(ExperimentalGridApi::class)
@Composable
@Preview
@PreviewWrapper(ThemePreviewWrapper::class)
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
                modifier = Modifier.weight(1f),
                config = {
                    column(weight = middleColumnHorizontalPosition.start.fr)
                    column(weight = middleColumnHorizontalPosition.width.fr)
                    column(weight = middleColumnHorizontalPosition.distanceToOne.fr)

                    row(weight = middleRowVerticalPosition.start.fr)
                    row(weight = middleRowVerticalPosition.width.fr)
                    row(weight = middleRowVerticalPosition.distanceToOne.fr)

                    rowGap(8.dp)
                    columnGap(8.dp)
                }
            ) {
                GridTile(
                    number = 1,
                    modifier = Modifier.gridItem(
                        rowSpan = 2,
                        columnSpan = 2
                    )
                )

                GridTile(
                    number = 2,
                    modifier = Modifier.gridItem(column = -1)
                )

                GridTile(
                    number = 3,
                    modifier = Modifier.gridItem(
                        row = 2,
                        column = -1
                    )
                )

                GridTile(
                    number = 4,
                    modifier = Modifier.gridItem(row = -1)
                )

                GridTile(
                    number = 5,
                    modifier = Modifier.gridItem(
                        row = -1,
                        column = 2,
                        columnSpan = 2
                    )
                )
            }

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
@PreviewWrapper(ThemePreviewWrapper::class)
fun GridTilePreview() { GridTile(1) }
package com.maxheight.compose2026snippet.pre25.ui.util

val ClosedFloatingPointRange<Float>.width: Float
    get() = maxOf(this.endInclusive - this.start, 0.02f)

val ClosedFloatingPointRange<Float>.distanceToOne: Float
    get() = maxOf(1 - this.endInclusive, 0.02f)
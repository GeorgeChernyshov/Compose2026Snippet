package com.maxheight.compose2026snippet.post25.ui.util

val ClosedFloatingPointRange<Float>.width: Float
    get() = this.endInclusive - this.start

val ClosedFloatingPointRange<Float>.distanceToOne: Float
    get() = 1 - this.endInclusive
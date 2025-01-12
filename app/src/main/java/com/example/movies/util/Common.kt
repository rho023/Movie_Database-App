package com.example.movies.util

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun MySpacer(size: Dp) = Spacer(modifier = Modifier.height(size))

fun String.trimStartEnd() = this.trimStart().trimEnd()
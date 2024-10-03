package com.example.composeApp.enums

import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.StringResource
import watcheat.composeapp.generated.resources.Res
import watcheat.composeapp.generated.resources.gramme
import watcheat.composeapp.generated.resources.kilogramme
import watcheat.composeapp.generated.resources.liters
import watcheat.composeapp.generated.resources.milliliters
import watcheat.composeapp.generated.resources.piece

enum class ProductUnit @OptIn(ExperimentalResourceApi::class) constructor(
    val textId: StringResource,
) {
    @OptIn(ExperimentalResourceApi::class)
    KILOGRAMME(Res.string.kilogramme),

    @OptIn(ExperimentalResourceApi::class)
    PIECE(Res.string.piece),

    @OptIn(ExperimentalResourceApi::class)
    MILLILITERS(Res.string.milliliters),

    @OptIn(ExperimentalResourceApi::class)
    LITERS(Res.string.liters),

    @OptIn(ExperimentalResourceApi::class)
    GRAMME(Res.string.gramme)
}
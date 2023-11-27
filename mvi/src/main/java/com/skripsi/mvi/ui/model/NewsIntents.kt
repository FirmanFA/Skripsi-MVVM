package com.skripsi.mvi.ui.model

sealed class NewsIntents {
    object LatestCnnNews : NewsIntents()
    object LatestBBCNews : NewsIntents()
    object LatestESPNNews : NewsIntents()
}
package com.example.infoapp.utils

sealed class DrawerEvents {
    data class OnItemClick(val title: String, val index: Int): DrawerEvents()
}

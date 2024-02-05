package com.sench.vknewsclient.util

fun Long.formatToCompactForm(): String {
    return when {
        this >= 1_000_000 -> "${this / 1_000_000}M"
        this >= 1_000 -> "${this / 1_000}K"
        else -> this.toString()
    }
}
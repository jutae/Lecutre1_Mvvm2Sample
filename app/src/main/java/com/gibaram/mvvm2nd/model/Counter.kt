package com.gibaram.mvvm2nd.model

data class Counter(var number: Int = 1) {

    fun increase() {
        this.number++
    }
}
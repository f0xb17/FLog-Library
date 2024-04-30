package com.foxbit

import com.foxbit.flog.Flogger

fun main() {
    val flog = Flogger("logfile.txt")

    flog.log("Hello World, this is a test.", 1)
    flog.log("File is not writable!", 2)
    flog.log("A file with the name XYZ already exists.", 3)
    try {
        val exception = true
        if(exception) {
            throw IllegalArgumentException("This is a test exception.");
        }
    } catch (e: IllegalArgumentException) {
        flog.log(e.toString(), 4)
    }
}
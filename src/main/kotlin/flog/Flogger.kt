/**
 * Flogger.kt
 * Represents a simple logging library that can write all events to a corresponding file.
 *
 * Created by f0xb17 on 04/30/2024.
 * Copyright © 2024 f0xb17. All rights reserved.
 */

package com.foxbit.flog

import java.io.FileWriter
import java.text.SimpleDateFormat
import java.util.*

/**
 * Class Flogger which is used to write the logfile.
 * @param [filePath] File path to the file that is to be treated as a log file.
 */
class Flogger(private val filePath: String) {

    /**
     * Formats the subsequent timestamp according to the desired pattern.
     */
    private val dateFormat: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd | HH:mm:ss")

    /**
     * This class returns an error level, from @link[FloggerLevel].
     * @param [level] Numerical value used to determine the error level.
     * @return an error level from @link[FloggerLevel].
     */
    private fun getLevel(level: Int): FloggerLevel {
        return FloggerLevel.getLoggerLevel(level)
    }

    /**
     * A method that returns a formatted timestamp.
     * @return A formatted timestamp based on the previously defined pattern at @link[dateFormat]
     */
    private fun getTimeStamp(): String {
        return this.dateFormat.format(Date())
    }

    /**
     * This method writes the desired @link[event], with the desired @link[level],
     * to a previously defined @link[filePath].
     *
     * @param [event] The message to be logged.
     * @param [level] A numerical value to determine the error level.
     */
    private fun write(event: String, level: Int) {
        FileWriter(this.filePath, true).use { writer ->
            writer.appendLine("${this.getTimeStamp()}: ${this.getLevel(level)} - $event")
        }
    }

    /**
     * This method calls the write function.
     *
     * @param [event] The message to be logged.
     * @param [level] A numerical value to determine the error level.
     */
    fun log(event: String, level: Int) {
        try {
            this.write(event, level)
        } catch (e: Exception) {
            this.write(e.stackTraceToString(), 4).also {
                println("${this.getTimeStamp()}: ${this.getLevel(4)} - ${e.printStackTrace()}")
            }
        }
    }
}
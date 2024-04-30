/**
 * FloggerLevel.kt
 * Represents a simple logging library that can write all events to a corresponding file.
 *
 * Created by f0xb17 on 04/30/2024.
 * Copyright © 2024 f0xb17. All rights reserved.
 */

package com.foxbit.flog

/**
 * The enum sets the problem level using a number.
 * @param [level] Represents the problem level using am integer value.
 */
enum class FloggerLevel(private val level: Int) {
    Info(1),
    Error(2),
    Problem(3),
    JVMException(4);

    companion object {
        /**
         * This method returns the problem level that it determines using the numerical value @link[value].
         * @param [value] Represents the problem level using am integer value.
         * @return The problem level from @link[value]
         */
        fun getLoggerLevel(value: Int): FloggerLevel {
            return when(value) {
                1 -> Info
                2 -> Error
                3 -> Problem
                4 -> JVMException
                else -> throw IllegalArgumentException("Invalid argument: $value")
            }
        }
    }

}
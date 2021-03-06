/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.trackmysleepquality.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Delete

// treat Interface with Database
@Dao
interface SleepDatabaseDao{

    // SQL
    //   INSERT INTO daily_slee?quality_table(nightId, start_time_milli, end_time_milli, quality_rating)
    //   VALEUS (night.nightId, night.startTimeMilli, night.endTimeMilli, night.sleep...)
    @Insert
    suspend fun insert(night: SleepNight)

    // suspend == takes a certain time until the result comes == acync

    @Update
    suspend fun update(night: SleepNight)

    @Query("SELECT * from daily_sleep_quality_table WHERE nightId = :key")
    suspend fun get(key: Long): SleepNight?

    @Query("SELECT * from daily_sleep_quality_table ORDER BY nightId")
    suspend fun getTonight(): SleepNight?

    @Query("SELECT * from daily_sleep_quality_table ORDER BY nightId DESC")
    fun getAllNights(): LiveData<List<SleepNight>>

    // delete everything from the database
    @Query("DELETE FROM daily_sleep_quality_table")
    suspend fun clear()
}
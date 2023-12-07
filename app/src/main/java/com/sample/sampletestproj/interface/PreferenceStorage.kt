package com.sample.sampletestproj.`interface`

import kotlinx.coroutines.flow.Flow

interface PreferenceStorage {
    suspend fun saveDetails(guestDetails: GuestDetails)

    suspend fun getDetails(): Flow<GuestDetails>
}
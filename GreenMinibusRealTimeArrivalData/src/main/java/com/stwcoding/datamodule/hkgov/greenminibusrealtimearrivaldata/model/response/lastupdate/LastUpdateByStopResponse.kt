/*
 * Copyright© 2024. singtsun9941. All rights reserved.
 * 版權所有© 2024. singtsun9941
 */

package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.lastupdate


import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.GMBResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LastUpdateByStopResponse(
    @SerialName("type")
    override val type: String = "", // Last-Update
    @SerialName("version")
    override val version: String = "", // 1.0
    @SerialName("generated_timestamp")
    override val generatedTimestamp: String = "", // 2024-09-21T16:14:26.225+08:00
    @SerialName("data")
    override val data: List<Data> = listOf()
) :GMBResponse{
    @Serializable
    data class Data(
        @SerialName("stop_id")
        val stopId: Int = 0, // 20012054
        @SerialName("last_update_date")
        val lastUpdateDate: String = "" // 2023-01-30T16:02:25.069+00:00
    )
}
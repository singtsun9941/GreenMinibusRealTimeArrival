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
    override val generatedTimestamp: String = "", // 2020-11-25T10:34:10.082+08:00
    @SerialName("data")
    override val data: Data = Data()
) : GMBResponse {
    @Serializable
    data class Data(
        @SerialName("data_timestamp")
        val dataTimestamp: List<DataTimestamp> = listOf()
    ) {
        @Serializable
        data class DataTimestamp(
            @SerialName("stop_id")
            val stopId: Int = 0, // 20000849
            @SerialName("last_update_date")
            val lastUpdateDate: String = "" // 2020-09-24T08:24:45.401+08:00
        )
    }
}
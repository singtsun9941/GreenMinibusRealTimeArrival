/*
 * Copyright© 2024. singtsun9941. All rights reserved.
 * 版權所有© 2024. singtsun9941
 */

package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.lastupdate


import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.GMBResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LastUpdateSingleDataResponse(
    @SerialName("type")
    override val type: String = "", // Last-Update
    @SerialName("version")
    override val version: String = "", // 1.0
    @SerialName("generated_timestamp")
    override val generatedTimestamp: String = "", // 2020-12-28T16:49:26.877+08:00
    @SerialName("data")
    override val data: Data = Data()
) : GMBResponse {
    @Serializable
    data class Data(
        @SerialName("last_update_date")
        val lastUpdateDate: String = "" // 2020-12-23T13:23:09.065+08:00
    )
}
/*
 * Copyright© 2024. singtsun9941. All rights reserved.
 * 版權所有© 2024. singtsun9941
 */

package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.lastupdate

import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.GMBResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LastUpdateByRouteResponse(
    @SerialName("type")
    override val type: String = "", // Last-Update
    @SerialName("version")
    override val version: String = "", // 1.0
    @SerialName("generated_timestamp")
    override val generatedTimestamp: String = "", // 2024-09-14T21:38:58.804+08:00
    @SerialName("data")
    val data: List<Data> = listOf()
) : GMBResponse {
    @Serializable
    data class Data(
        @SerialName("route_id")
        val routeId: Int = 0, // 2000410
        @SerialName("last_update_date")
        val lastUpdateDate: String = "" // 2024-08-22T09:21:06.168+00:00
    )
}
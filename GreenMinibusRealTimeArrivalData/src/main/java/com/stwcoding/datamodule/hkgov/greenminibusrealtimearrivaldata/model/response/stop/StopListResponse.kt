/*
 * Copyright© 2024. singtsun9941. All rights reserved.
 * 版權所有© 2024. singtsun9941
 */

package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.stop


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StopListResponse(
    @SerialName("type")
    val type: String = "", // Route-Stop
    @SerialName("version")
    val version: String = "", // 1.0
    @SerialName("generated_timestamp")
    val generatedTimestamp: String = "", // 2020-12-28T14:51:23.258+08:00
    @SerialName("data")
    val data: Data
) {
    @Serializable
    data class Data(
        @SerialName("route_stops")
        val routeStops: List<RouteStop> = listOf(),
        @SerialName("data_timestamp")
        val dataTimestamp: String = "" // 2020-12-23T13:23:09.065+08:00
    ) {
        @Serializable
        data class RouteStop(
            @SerialName("stop_seq")
            val stopSeq: Int = 0, // 1
            @SerialName("stop_id")
            val stopId: Int = 0, // 20003337
            @SerialName("name_tc")
            val nameTc: String = "", // 數碼港公共運輸交匯處
            @SerialName("name_sc")
            val nameSc: String = "", // 数码港公共运输交汇处
            @SerialName("name_en")
            val nameEn: String = "" // Cyberport Public Transport Interchange
        )
    }
}
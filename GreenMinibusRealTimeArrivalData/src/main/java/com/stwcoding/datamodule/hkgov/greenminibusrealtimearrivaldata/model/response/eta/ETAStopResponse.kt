/*
 * Copyright© 2024. singtsun9941. All rights reserved.
 * 版權所有© 2024. singtsun9941
 */

package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.eta


import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.GMBResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ETAStopResponse(
    @SerialName("type")
    override val type: String = "", // ETA-Stop
    @SerialName("version")
    override val version: String = "", // 1.0
    @SerialName("generated_timestamp")
    override val generatedTimestamp: String = "", // 2024-09-21T22:26:17.704+08:00
    @SerialName("data")
    override val `data`: List<Data> = listOf()
) : GMBResponse {
    @Serializable
    data class Data(
        @SerialName("route_id")
        val routeId: Int = 0, // 2004164
        @SerialName("route_seq")
        val routeSeq: Int = 0, // 2
        @SerialName("stop_seq")
        val stopSeq: Int = 0, // 1
        @SerialName("enabled")
        val enabled: Boolean = false, // true
        @SerialName("eta")
        val eta: List<Eta> = listOf()
    ) {
        @Serializable
        data class Eta(
            @SerialName("eta_seq")
            val etaSeq: Int = 0, // 1
            @SerialName("diff")
            val diff: Int = 0, // 0
            @SerialName("timestamp")
            val timestamp: String = "", // 2024-09-21T22:26:02.760+08:00
            @SerialName("remarks_tc")
            val remarksTc: String? = null, // 未開出
            @SerialName("remarks_sc")
            val remarksSc: String? = null, // 未开出
            @SerialName("remarks_en")
            val remarksEn: String? = null // Scheduled
        )
    }
}
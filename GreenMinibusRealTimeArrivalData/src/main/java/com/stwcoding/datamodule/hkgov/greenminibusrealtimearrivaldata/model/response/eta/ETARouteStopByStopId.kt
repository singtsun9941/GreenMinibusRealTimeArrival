/*
 * Copyright© 2024. singtsun9941. All rights reserved.
 * 版權所有© 2024. singtsun9941
 */

package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.eta


import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.GMBResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ETARouteStopByStopId(
    @SerialName("type")
    override val type: String = "", // ETA-Route-Stop
    @SerialName("version")
    override val version: String = "", // 1.0
    @SerialName("generated_timestamp")
    override val generatedTimestamp: String = "", // 2024-09-21T22:11:44.213+08:00
    @SerialName("data")
    override val data: List<Data> = listOf()
) : GMBResponse {
    @Serializable
    data class Data(
        @SerialName("route_seq")
        val routeSeq: Int = 0, // 1
        @SerialName("stop_seq")
        val stopSeq: Int = 0, // 1
        @SerialName("enabled")
        val enabled: Boolean = false, // true

        // When ETA is enabled
        @SerialName("eta")
        val eta: List<Eta>? = null,

        // When ETA is disabled
        @SerialName("description_tc")
        val descriptionTc: String? = null, // <到站預報暫停原因>
        @SerialName("description_sc")
        val descriptionSc: String? = null, // <到站預報暫停原因>
        @SerialName("description_en")
        val descriptionEn: String? = null // <Reason of ETA Service Unavailable>
    ) {
        @Serializable
        data class Eta(
            @SerialName("eta_seq")
            val etaSeq: Int = 0, // 1
            @SerialName("diff")
            val diff: Int = 0, // 0
            @SerialName("timestamp")
            val timestamp: String = "", // 2024-09-21T22:12:00.000+08:00
            @SerialName("remarks_tc")
            val remarksTc: String? = null, // 未開出
            @SerialName("remarks_sc")
            val remarksSc: String? = null, // 未开出
            @SerialName("remarks_en")
            val remarksEn: String? = null, // Scheduled
        )
    }
}
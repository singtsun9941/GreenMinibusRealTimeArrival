/*
 * Copyright© 2024. singtsun9941. All rights reserved.
 * 版權所有© 2024. singtsun9941
 */

package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.stop


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StopDetailsResponse(
    @SerialName("type")
    val type: String = "", // Stop
    @SerialName("version")
    val version: String = "", // 1.0
    @SerialName("generated_timestamp")
    val generatedTimestamp: String = "", // 2020-10-07T09:53:17.114+08:00
    @SerialName("data")
    val data: Data = Data()
) {
    @Serializable
    data class Data(
        @SerialName("coordinates")
        val coordinates: Coordinates = Coordinates(),
        @SerialName("enabled")
        val enabled: Boolean = false, // true
        @SerialName("remarks_tc")
        val remarksTc: String? = null, // null
        @SerialName("remarks_sc")
        val remarksSc: String? = null, // null
        @SerialName("remarks_en")
        val remarksEn: String? = null, // null
        @SerialName("data_timestamp")
        val dataTimestamp: String = "" // 2020-09-24T16:19:19.858+08:00
    ) {
        @Serializable
        data class Coordinates(
            @SerialName("wgs84")
            val wgs84: Wgs84 = Wgs84(),
            @SerialName("hk80")
            val hk80: Hk80 = Hk80()
        ) {
            @Serializable
            data class Wgs84(
                @SerialName("latitude")
                val latitude: Double = 0.0, // 22.261913456129104
                @SerialName("longitude")
                val longitude: Double = 0.0 // 114.13014951276878
            )

            @Serializable
            data class Hk80(
                @SerialName("latitude")
                val latitude: Double = 0.0, // 813678.9998333427
                @SerialName("longitude")
                val longitude: Double = 0.0 // 831452.0004168812
            )
        }
    }
}
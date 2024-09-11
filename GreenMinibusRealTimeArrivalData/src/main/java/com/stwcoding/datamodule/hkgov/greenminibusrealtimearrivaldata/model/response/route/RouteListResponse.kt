/*
 * Copyright© 2024. singtsun9941. All rights reserved.
 * 版權所有© 2024. singtsun9941
 */

package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.route


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RouteListResponse(
    @SerialName("type")
    val type: String = "", // Stop-Route
    @SerialName("version")
    val version: String = "", // 1.0
    @SerialName("generated_timestamp")
    val generatedTimestamp: String = "", // 2020-12-28T15:13:24.880+08:00
    @SerialName("data")
    val data: List<Data> = listOf()
) {
    @Serializable
    data class Data(
        @SerialName("route_id")
        val routeId: Int = 0, // 2000410
        @SerialName("route_seq")
        val routeSeq: Int = 0, // 1
        @SerialName("stop_seq")
        val stopSeq: Int = 0, // 6
        @SerialName("name_tc")
        val nameTc: String = "", // 域多利道, 近免疫學研究院
        @SerialName("name_sc")
        val nameSc: String = "", // 域多利道, 近免疫学研究院
        @SerialName("name_en")
        val nameEn: String = "" // Victoria Road, near Department Of Health Institute Of Immunology
    )
}
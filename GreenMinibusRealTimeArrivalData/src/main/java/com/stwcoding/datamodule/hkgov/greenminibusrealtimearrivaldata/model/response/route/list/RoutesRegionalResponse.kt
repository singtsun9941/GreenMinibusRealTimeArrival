/*
 * Copyright© 2024. singtsun9941. All rights reserved.
 * 版權所有© 2024. singtsun9941
 */

package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.route.list

import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.GMBResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RoutesRegionalResponse(
    @SerialName("type")
    override val type: String = "", // Routes-Regional
    @SerialName("version")
    override val version: String = "", // 1.0
    @SerialName("generated_timestamp")
    override val generatedTimestamp: String = "", // 2020-12-28T11:23:23.381+08:00
    @SerialName("data")
    val data: Data = Data()
) : GMBResponse, IRouteListingResponse {
    @Serializable
    data class Data(
        @SerialName("routes")
        val routes: List<String> = listOf(),
        @SerialName("data_timestamp")
        val dataTimestamp: String = "" // 2020-12-22T11:27:48.705+08:00
    )
}
/*
 * Copyright© 2024. singtsun9941. All rights reserved.
 * 版權所有© 2024. singtsun9941
 */

package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.route.list


import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.GMBResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RoutesAllResponse(
    @SerialName("type")
    override val type: String = "", // Routes-All
    @SerialName("version")
    override val version: String = "", // 1.0
    @SerialName("generated_timestamp")
    override val generatedTimestamp: String = "", // 2020-12-28T11:14:21.326+08:00
    @SerialName("data")
    override val data: Data = Data(),
) : IRouteListingResponse {
    @Serializable
    data class Data(
        @SerialName("routes")
        val routes: Routes = Routes(),
        @SerialName("data_timestamp")
        val dataTimestamp: String = "" // 2020-12-22T11:27:48.705+08:00
    ) {
        @Serializable
        data class Routes(
            @SerialName("HKI")
            val hkiRoutes: List<String> = listOf(),
            @SerialName("NT")
            val ntRoutes: List<String> = listOf(),
            @SerialName("KLN")
            val klnRoutes: List<String> = listOf()
        )
    }
}
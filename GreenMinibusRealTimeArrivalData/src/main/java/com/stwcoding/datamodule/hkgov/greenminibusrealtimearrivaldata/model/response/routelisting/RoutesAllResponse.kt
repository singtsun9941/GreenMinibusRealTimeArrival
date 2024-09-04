package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.routelisting


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
    val data: Data = Data(),
    @SerialName("data_timestamp")
    val dataTimestamp: String = "" // 2020-12-22T11:27:48.705+08:00
): IRouteListingResponse {
    @Serializable
    data class Data(
        @SerialName("routes")
        val routes: Routes = Routes()
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
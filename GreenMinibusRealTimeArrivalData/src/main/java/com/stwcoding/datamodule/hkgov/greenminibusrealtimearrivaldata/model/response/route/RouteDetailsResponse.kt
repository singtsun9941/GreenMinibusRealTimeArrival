/*
 * Copyright© 2024. singtsun9941. All rights reserved.
 * 版權所有© 2024. singtsun9941
 */

package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.route


import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.GMBResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RouteDetailsResponse(
    @SerialName("type")
    override val type: String = "", // Route
    @SerialName("version")
    override val version: String = "", // 1.0
    @SerialName("generated_timestamp")
    override val generatedTimestamp: String = "", // 2020-12-28T15:07:55.373+08:00
    @SerialName("data")
    val data: List<Data> = listOf()
) : GMBResponse {
    @Serializable
    data class Data(
        @SerialName("region")
        val region: String? = null, // HKI
        @SerialName("route_code")
        val routeCode: String? = null, // 69
        @SerialName("route_id")
        val routeId: Int = 0, // 2000410
        @SerialName("description_tc")
        val descriptionTc: String = "", // 正常班次
        @SerialName("description_sc")
        val descriptionSc: String = "", // 正常班次
        @SerialName("description_en")
        val descriptionEn: String = "", // Normal Schedule
        @SerialName("directions")
        val directions: List<Direction> = listOf(),
        @SerialName("data_timestamp")
        val dataTimestamp: String = "" // 2020-12-23T12:59:10.918+08:00
    ) {
        @Serializable
        data class Direction(
            @SerialName("route_seq")
            val routeSeq: Int = 0, // 1
            @SerialName("orig_tc")
            val origTc: String = "", // 數碼港
            @SerialName("orig_sc")
            val origSc: String = "", // 数码港
            @SerialName("orig_en")
            val origEn: String = "", // Cyberport
            @SerialName("dest_tc")
            val destTc: String = "", // 鰂魚涌(船塢里)(循環線)
            @SerialName("dest_sc")
            val destSc: String = "", // 鲗鱼涌(船坞里)(循环线)
            @SerialName("dest_en")
            val destEn: String = "", // Quarry Bay (Shipyard Lane) (Circular)
            @SerialName("remarks_tc")
            val remarksTc: String? = null, // null
            @SerialName("remarks_sc")
            val remarksSc: String? = null, // null
            @SerialName("remarks_en")
            val remarksEn: String? = null, // null
            @SerialName("headways")
            val headways: List<Headway> = listOf(),
            @SerialName("data_timestamp")
            val dataTimestamp: String = "" // 2020-12-23T12:59:10.918+08:00
        ) {
            @Serializable
            data class Headway(
                @SerialName("weekdays")
                val weekdays: List<Boolean> = listOf(),
                @SerialName("public_holiday")
                val publicHoliday: Boolean = false, // false
                @SerialName("headway_seq")
                val headwaySeq: Int = 0, // 1
                @SerialName("start_time")
                val startTime: String = "", // 06:30:00
                @SerialName("end_time")
                val endTime: String? = null, // 07:00:00
                @SerialName("frequency")
                val frequency: Int? = null, // 15
                @SerialName("frequency_upper")
                val frequencyUpper: Int? = null // null
            )
        }
    }
}
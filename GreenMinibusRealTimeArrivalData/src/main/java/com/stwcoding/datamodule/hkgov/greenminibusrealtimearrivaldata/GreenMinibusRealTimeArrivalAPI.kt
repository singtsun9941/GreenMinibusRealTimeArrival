package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata

import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.request.AllRoutesRequest
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.request.RegionalRoutesRequest
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.request.RouteDetailsRequest
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.lastupdate.LastUpdateByRouteResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.route.RouteDetailsResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.route.list.RoutesAllResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.route.list.RoutesRegionalResponse
import com.stwcoding.networkmodule.ktothelper.HttpClientConfig
import com.stwcoding.networkmodule.ktothelper.KtorAPI
import com.stwcoding.networkmodule.ktothelper.model.API
import com.stwcoding.networkmodule.ktothelper.model.request.Platform

object GreenMinibusRealTimeArrivalAPI : KtorAPI(
    HttpClientConfig(
        platform = Platform.ANDROID,
        domain = "https://data.etagmb.gov.hk"
    )
) {
    val regionalRouteListRegionalAPI =
        object : API<RegionalRoutesRequest, RoutesRegionalResponse>("route") {
            override suspend fun sendRequest(request: RegionalRoutesRequest): Result<RoutesRegionalResponse> {
                return request(path, request)
            }
        }

    val lastUpdateRegionalRouteListRegionalAPI =
        object : API<RegionalRoutesRequest, RoutesRegionalResponse>("last-update/route") {
            override suspend fun sendRequest(request: RegionalRoutesRequest): Result<RoutesRegionalResponse> {
                return request(path, request)
            }
        }

    val allRouteListAPI = object : API<AllRoutesRequest, RoutesAllResponse>("route") {
        override suspend fun sendRequest(request: AllRoutesRequest): Result<RoutesAllResponse> {
            return request(path, request)
        }
    }

    val lastUpdateAllRouteListAPI =
        object : API<AllRoutesRequest, RoutesAllResponse>("last-update/route") {
            override suspend fun sendRequest(request: AllRoutesRequest): Result<RoutesAllResponse> {
                return request(path, request)
            }
        }


    // TODO when routeCode is empty string(""), api return RouteList json
    val routeDetailsAPI = object : API<RouteDetailsRequest, RouteDetailsResponse>("route") {
        override suspend fun sendRequest(request: RouteDetailsRequest): Result<RouteDetailsResponse> {
            return request(path, request)
        }
    }

    // TODO when routeCode is empty string(""), api return RouteList json
    val routeDetailsLastUpdateAPI =
        object : API<RouteDetailsRequest, LastUpdateByRouteResponse>("last-update/route") {
            override suspend fun sendRequest(request: RouteDetailsRequest): Result<LastUpdateByRouteResponse> {
                return request(path, request)
            }
        }

//    fun getStopDetailsAPI(stopId: String) = object : StopDetailsAPI("stop/$stopId") {
//        override suspend fun fetch(): Result<StopDetailsResponse> =
//            get(path)
//
//        override suspend fun getETA(): Result<ETAStopResponse> =
//            get("/eta/$path")
//
//        override suspend fun fetchLastUpdate(): Result<LastUpdateSingleDataResponse> =
//            get("/last-update/$path")
//
//    }
//
//    fun getStopListByRouteAPI(
//        routeId: String,
//        routeSequence: String
//    ) = object : StopListByRouteAPI("route-stop/$routeId/$routeSequence") {
//        override suspend fun fetch(): Result<StopListResponse> {
//            return get(path)
//        }
//
//        override suspend fun fetchLastUpdate(): Result<LastUpdateSingleDataResponse> {
//            return get("/last-update/$path")
//        }
//    }
//
//    fun getStopListByRouteETAAPI(
//        routeId: String,
//        routeSequence: String,
//        stopSeq: String,
//    ) = object : StopListByRouteETAAPI("route-stop/$routeId/$routeSequence/$stopSeq") {
//        override suspend fun getETA(): Result<ETARouteStopByStopId> {
//            return get("/eta/$path")
//        }
//    }
//
//    suspend fun getRouteListByStopAPI(stopId: String) =
//        object : RouteListByStopAPI("stop-route/$stopId") {
//            override suspend fun fetch(): Result<RouteListResponse> {
//                return get("path")
//            }
//
//            override suspend fun fetchLastUpdate(): Result<LastUpdateByRouteResponse> {
//                return get("/last-update/$path")
//            }
//        }
//
//    fun getRouteStopLastUpdateAPI() = object : RouteStopLastUpdateAPI("route-stop") {
//        override suspend fun fetchLastUpdate(): Result<LastUpdateByRouteResponse> =
//            get("last-update/$path")
//    }
}
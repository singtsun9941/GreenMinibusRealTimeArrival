package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata

import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.RegionModel
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.api.RouteDetailsAPI
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.api.RouteListAPI
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.api.RouteListByStopAPI
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.api.StopDetailsAPI
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.api.StopListByRouteAPI
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.lastupdate.LastUpdateByRouteResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.lastupdate.LastUpdateSingleDataResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.route.RouteDetailsResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.route.RouteListResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.route.list.IRouteListingResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.route.list.RoutesAllResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.route.list.RoutesRegionalResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.stop.StopDetailsResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.stop.StopListResponse
import com.stwcoding.networkmodule.ktothelper.HttpClientHelper
import com.stwcoding.networkmodule.ktothelper.createHttpClient
import io.ktor.client.engine.okhttp.OkHttp

class GreenMinibusRealTimeArrivalClient : HttpClientHelper(
    createHttpClient(
        engine = OkHttp.create(),
        domain = "https://data.etagmb.gov.hk"
    )
) {
    fun getRouteListAPI(region: RegionModel? = null) = object : RouteListAPI("route") {
        override suspend fun fetch(): Result<IRouteListingResponse> {
            return region?.let {
                get<RoutesRegionalResponse>("$path/${region.id}")
            } ?: get<RoutesAllResponse>(path)
        }

        override suspend fun getLastUpdate(): Result<LastUpdateByRouteResponse> {
            return get("/last-update/$path/${region?.id.orEmpty()}")
        }
    }

    // TODO when routeCode is empty string(""), api return RouteList json
    fun getRouteDetailsAPI(
        region: RegionModel,
        routeCode: String
    ) = object : RouteDetailsAPI("route/${region.id}/$routeCode") {
        override suspend fun fetch(): Result<RouteDetailsResponse> {
            return get(path)
        }

        override suspend fun getLastUpdate(): Result<LastUpdateByRouteResponse> {
            return get("/last-update/$path")
        }
    }

    // TODO when routeCode is empty string(""), api return RouteList json
    suspend fun getRouteDetailsAPI(
        routeId: String
    ) = object : RouteDetailsAPI("route/$routeId") {
        override suspend fun fetch(): Result<RouteDetailsResponse> {
            return get(path)
        }

        override suspend fun getLastUpdate(): Result<LastUpdateByRouteResponse> {
            return get("/last-update/$path")
        }
    }

    fun getStopDetailsAPI(stopId: String) = object : StopDetailsAPI("stop/$stopId") {
        override suspend fun fetch(): Result<StopDetailsResponse> =
            get(path)
        override suspend fun getETA(): Result<LastUpdateSingleDataResponse> =
            get("/eta/$path")
        override suspend fun getLastUpdate(): Result<LastUpdateSingleDataResponse> =
            get("/last-update/$path")

    }

    fun getStopListByRouteAPI(
        routeId: String,
        routeSequence: String
    ) = object : StopListByRouteAPI("route-stop/$routeId/$routeSequence") {
        override suspend fun fetch(): Result<StopListResponse> {
            return get(path)
        }

        override suspend fun getLastUpdate(): Result<LastUpdateSingleDataResponse> {
            return get("/last-update/$path")
        }
    }

    suspend fun getRouteListByStopAPI(stopId: String) =
        object : RouteListByStopAPI("stop-route/$stopId") {
            override suspend fun fetch(): Result<RouteListResponse> {
                return get("path")
            }

            override suspend fun getLastUpdate(): Result<LastUpdateByRouteResponse> {
                return get("/last-update/$path")
            }
        }
}
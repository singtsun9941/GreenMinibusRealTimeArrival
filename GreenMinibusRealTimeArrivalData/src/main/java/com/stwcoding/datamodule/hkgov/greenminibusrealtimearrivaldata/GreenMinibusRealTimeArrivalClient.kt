package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata

import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.RegionModel
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.api.AllStopLastUpdateAPI
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.api.RouteDetailsAPI
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.api.RouteListAPI
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.api.RouteListByStopAPI
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.api.StopDetailsAPI
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.api.StopListByRouteAPI
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.lastupdate.LastUpdateByRouteResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.lastupdate.LastUpdateByStopResponse
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
    fun getRouteListAPI(region: RegionModel? = null) = object : RouteListAPI() {
        override suspend fun fetch(): Result<IRouteListingResponse> {
            return region?.let {
                get<RoutesRegionalResponse>("route/${region.id}")
            } ?: get<RoutesAllResponse>("route")
        }

        override suspend fun getLastUpdate(): Result<LastUpdateByRouteResponse> {
            return get("/last-update/route/${region?.id.orEmpty()}")
        }
    }

    // TODO when routeCode is empty string(""), api return RouteList json
    fun getRouteDetailsAPI(
        region: RegionModel,
        routeCode: String
    ) = object : RouteDetailsAPI() {
        override suspend fun fetch(): Result<RouteDetailsResponse> {
            return get("route/${region.id}/$routeCode")
        }

        override suspend fun getLastUpdate(): Result<LastUpdateByRouteResponse> {
            return get("/last-update/route/${region.id}/$routeCode")
        }
    }

    // TODO when routeCode is empty string(""), api return RouteList json
    suspend fun getRouteDetailsAPI(
        routeId: String
    ) = object : RouteDetailsAPI() {
        override suspend fun fetch(): Result<RouteDetailsResponse> {
            return get("route/$routeId")
        }

        override suspend fun getLastUpdate(): Result<LastUpdateByRouteResponse> {
            return get("/last-update/route//$routeId")
        }
    }

    fun getStopDetailsAPI(stopId: String) = object : StopDetailsAPI() {
        override suspend fun fetch(): Result<StopDetailsResponse> {
            return get("stop/$stopId")
        }

        override suspend fun getLastUpdate(): Result<LastUpdateSingleDataResponse> {
            return get("/last-update/stop/$stopId")
        }
    }

    fun getStopListByRouteAPI(
        routeId: String,
        routeSequence: String
    ) = object : StopListByRouteAPI() {
        override suspend fun fetch(): Result<StopListResponse> {
            return get("route-stop/$routeId/$routeSequence")
        }

        override suspend fun getLastUpdate(): Result<LastUpdateSingleDataResponse> {
            return get("/last-update/route-stop/$routeId/$routeSequence")
        }
    }

    suspend fun getRouteListByStopAPI(stopId: String) = object : RouteListByStopAPI() {
        override suspend fun fetch(): Result<RouteListResponse> {
            return get("stop-route/$stopId")
        }

        override suspend fun getLastUpdate(): Result<LastUpdateByRouteResponse> {
            return get("/last-update/stop-route/$stopId")
        }
    }

    suspend fun getAllStopLastUpdateAPI(stopId: String) = object : AllStopLastUpdateAPI() {
        override suspend fun getLastUpdate(): Result<LastUpdateByStopResponse> {
            return get("/last-update/stop")
        }
    }
}
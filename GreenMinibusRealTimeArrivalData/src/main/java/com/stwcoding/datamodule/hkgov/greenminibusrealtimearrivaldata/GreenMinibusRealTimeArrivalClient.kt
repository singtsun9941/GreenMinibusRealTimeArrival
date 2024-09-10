package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata

import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.RegionModel
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.route.RouteDetailsResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.routelisting.IRouteListingResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.routelisting.RoutesAllResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.routelisting.RoutesRegionalResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.stoproute.StopRouteListResponse
import com.stwcoding.networkmodule.ktothelper.HttpClientHelper
import com.stwcoding.networkmodule.ktothelper.createHttpClient
import io.ktor.client.engine.okhttp.OkHttp

class GreenMinibusRealTimeArrivalClient : HttpClientHelper(
    createHttpClient(
        engine = OkHttp.create(),
        domain = "https://data.etagmb.gov.hk"
    )
) {
    suspend fun routeListing(region: RegionModel? = null): Result<IRouteListingResponse> {
        return region?.let {
            get<RoutesRegionalResponse>("route/${region.id}")
        } ?: get<RoutesAllResponse>("route")
    }

    suspend fun routeDetails(region: RegionModel, routeCode: String): Result<RouteDetailsResponse> {
        return get("route/${region.id}/$routeCode")
    }

    suspend fun routeDetails(routeCodeId: String): Result<RouteDetailsResponse> {
        return get("route/$routeCodeId")
    }

    suspend fun fetchStopRouteList(routeId: String, routeSequence: String): Result<StopRouteListResponse> {
        return get("route-stop/$routeId/$routeSequence")
    }
}
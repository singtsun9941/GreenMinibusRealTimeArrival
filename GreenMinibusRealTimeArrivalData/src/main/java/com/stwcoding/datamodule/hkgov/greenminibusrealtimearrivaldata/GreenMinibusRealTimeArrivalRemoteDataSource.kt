package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata

import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.request.RegionalRoutesRequest
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class GreenMinibusRealTimeArrivalRemoteDataSource(
    private val gmbApi :GreenMinibusRealTimeArrivalAPI = GreenMinibusRealTimeArrivalAPI,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun fetchRegionalRouteListRegional(
        request: RegionalRoutesRequest
    ) = withContext(ioDispatcher) {
        gmbApi.regionalRouteListRegionalAPI.sendRequest(request)
    }

    suspend fun fetchLastUpdateRegionalRouteListRegional(
        request: RegionalRoutesRequest
    ) = withContext(ioDispatcher) {
        gmbApi.lastUpdateRegionalRouteListRegionalAPI.sendRequest(request)
    }
}
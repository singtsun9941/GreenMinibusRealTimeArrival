/*
 * Copyright© 2024. singtsun9941. All rights reserved.
 * 版權所有© 2024. singtsun9941
 */

package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata

import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.Region
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.request.AllRoutesRequest
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.request.RegionalRoutesRequest
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.GMBResponse

object GreenMinibusRealTimeArrivalRepository {
    private val dataSource = GreenMinibusRealTimeArrivalRemoteDataSource()

    suspend fun fetchRouteList(region: Region?) : GMBResponse?{
        val result = region?.let {
            dataSource.fetchRegionalRouteListRegional(RegionalRoutesRequest(region))
        } ?: dataSource.fetchAllRouteListRegional(AllRoutesRequest)
        return result.getOrNull()
    }
}
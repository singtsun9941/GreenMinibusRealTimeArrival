/*
 * Copyright© 2024. singtsun9941. All rights reserved.
 * 版權所有© 2024. singtsun9941
 */

package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.request

import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.Region
import com.stwcoding.networkmodule.ktothelper.model.request.HttpMethod
import com.stwcoding.networkmodule.ktothelper.model.request.Request


abstract class RouteDetailsRequest : Request(HttpMethod.GET)

data class RouteDetailsByRouteCodeRequest(
    val region: Region,
    val routeCode: String
) : RouteDetailsRequest() {
    init {
        addPathSegments(
            region.id,
            routeCode,
        )
    }
}

data class RouteDetailsByRouteIDRequest(
    val routeId: String
) : RouteDetailsRequest() {
    init {
        addPathSegments(
            routeId
        )
    }
}

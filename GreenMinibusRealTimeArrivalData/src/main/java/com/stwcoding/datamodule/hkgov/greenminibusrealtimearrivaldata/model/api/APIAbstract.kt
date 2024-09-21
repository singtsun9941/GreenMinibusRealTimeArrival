/*
 * Copyright© 2024. singtsun9941. All rights reserved.
 * 版權所有© 2024. singtsun9941
 */

package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.api

import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.lastupdate.LastUpdateByRouteResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.lastupdate.LastUpdateSingleDataResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.route.RouteDetailsResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.route.RouteListResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.route.list.IRouteListingResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.stop.StopDetailsResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.stop.StopListResponse

abstract class RouteListAPI(
    override val path: String,
) : API, Fetchable<IRouteListingResponse>, HaveLastUpdate<LastUpdateByRouteResponse>

abstract class RouteDetailsAPI(
    override val path: String,
) : API, Fetchable<RouteDetailsResponse>, HaveLastUpdate<LastUpdateByRouteResponse>

abstract class StopDetailsAPI(
    override val path: String,
) : API, Fetchable<StopDetailsResponse>, HaveLastUpdate<LastUpdateSingleDataResponse>

abstract class StopListByRouteAPI(
    override val path: String,
) : API, Fetchable<StopListResponse>, HaveLastUpdate<LastUpdateSingleDataResponse>

abstract class RouteListByStopAPI(
    override val path: String,
) : API, Fetchable<RouteListResponse>, HaveLastUpdate<LastUpdateByRouteResponse>
/*
 * Copyright© 2024. singtsun9941. All rights reserved.
 * 版權所有© 2024. singtsun9941
 */

package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.api

import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.eta.ETAStopResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.lastupdate.LastUpdateByRouteResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.lastupdate.LastUpdateSingleDataResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.route.RouteDetailsResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.route.RouteListResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.route.list.IRouteListingResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.stop.StopDetailsResponse
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.stop.StopListResponse

abstract class RouteListAPI(
    path: String,
) : API(path), Fetchable<IRouteListingResponse>, HaveLastUpdate<LastUpdateByRouteResponse>

abstract class RouteDetailsAPI(
    path: String,
) : API(path), Fetchable<RouteDetailsResponse>, HaveLastUpdate<LastUpdateByRouteResponse>

abstract class StopDetailsAPI(
    path: String,
) : API(path),
    Fetchable<StopDetailsResponse>,
    HaveLastUpdate<LastUpdateSingleDataResponse>,
    ETA<ETAStopResponse>

abstract class StopListByRouteAPI(
    path: String,
) : API(path), Fetchable<StopListResponse>, HaveLastUpdate<LastUpdateSingleDataResponse>

abstract class RouteListByStopAPI(
    path: String,
) : API(path), Fetchable<RouteListResponse>, HaveLastUpdate<LastUpdateByRouteResponse>


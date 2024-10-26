/*
 * Copyright© 2024. singtsun9941. All rights reserved.
 * 版權所有© 2024. singtsun9941
 */

package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.request

import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.Region
import com.stwcoding.networkmodule.ktothelper.model.request.HttpMethod
import com.stwcoding.networkmodule.ktothelper.model.request.Request

data class RegionalRoutesRequest(
    val regional : Region
):Request(HttpMethod.GET){
    init {
        addPathSegments(regional.id)
    }
}

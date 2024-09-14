/*
 * Copyright© 2024. singtsun9941. All rights reserved.
 * 版權所有© 2024. singtsun9941
 */

package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.api

import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.GMBResponse

interface Fetchable<T: GMBResponse>{
    suspend fun fetch() : Result<T>
}

interface HaveLastUpdate<T: GMBResponse>{
    suspend fun getLastUpdate() : Result<T>
}

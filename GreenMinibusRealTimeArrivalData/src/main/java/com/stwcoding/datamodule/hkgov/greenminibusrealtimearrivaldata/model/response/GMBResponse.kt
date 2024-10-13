/*
 * Copyright© 2024. singtsun9941. All rights reserved.
 * 版權所有© 2024. singtsun9941
 */

package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response

import com.stwcoding.networkmodule.ktothelper.model.Response

interface GMBResponse: Response {
    val type: String
    val version: String
    val generatedTimestamp: String
    val data: Any
}
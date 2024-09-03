package com.stwcoding.datamodule.hkgov

import com.stwcoding.networkmodule.ktothelper.HttpClientHelper
import com.stwcoding.networkmodule.ktothelper.createHttpClient
import io.ktor.client.engine.okhttp.OkHttp

class GreenMinibusRealTimeArrivalClient : HttpClientHelper(
    createHttpClient(
        engine = OkHttp.create(),
        domain = "https://data.etagmb.gov.hk"
    )
) {
    suspend fun censorWords(uncensored: String): Result<String> {
        return get("route/NT")
    }
}
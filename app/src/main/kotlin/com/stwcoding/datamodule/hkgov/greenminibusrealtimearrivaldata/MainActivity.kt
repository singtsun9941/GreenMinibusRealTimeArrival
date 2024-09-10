/*
 * Copyright© 2024. singtsun9941. All rights reserved.
 * 版權所有© 2024. singtsun9941
 */

package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.rememberCoroutineScope
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.ui.APITestingScreen
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.ui.RouteDetailsByRouteIdRequest
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.ui.RouteDetailsRequest
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.ui.RouteListingRequest
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.ui.StopDetailsRequest
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.ui.StopListByRouteRequest
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.ui.theme.GreenMinibusRealTimeArrivalTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val client = GreenMinibusRealTimeArrivalClient()
            val scope = rememberCoroutineScope()

            GreenMinibusRealTimeArrivalTheme {
                APITestingScreen(
                    title = "Green Minibus Real Time Arrival API",
                    { responseState ->
                        RouteListingRequest(
                            client = client,
                        ) { response ->
                            scope.launch {
                                responseState.emit(response.toString())
                            }
                        }
                    },
                    { responseState ->
                        RouteDetailsRequest(
                            client = client,
                        ) { response ->
                            scope.launch {
                                responseState.emit(response.toString())
                            }
                        }
                    },
                    { responseState ->
                        RouteDetailsByRouteIdRequest(
                            client = client,
                        ) { response ->
                            scope.launch {
                                responseState.emit(response.toString())
                            }
                        }
                    },
                    { responseState ->
                        StopListByRouteRequest(
                            client = client,
                        ) { response ->
                            scope.launch {
                                responseState.emit(response.toString())
                            }
                        }
                    },
                    { responseState ->
                        StopDetailsRequest(
                            client = client,
                        ) { response ->
                            scope.launch {
                                responseState.emit(response.toString())
                            }
                        }
                    },
                )
            }
        }
    }
}
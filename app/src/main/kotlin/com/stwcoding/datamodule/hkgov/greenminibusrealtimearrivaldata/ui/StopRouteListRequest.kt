/*
 * Copyright© 2024. singtsun9941. All rights reserved.
 * 版權所有© 2024. singtsun9941
 */

package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.GreenMinibusRealTimeArrivalClient
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.stop.StopListResponse
import kotlinx.coroutines.launch

@Composable
fun StopRouteListRequest(
    modifier: Modifier = Modifier,
    client: GreenMinibusRealTimeArrivalClient,
    onResponseReceived: (StopListResponse?) -> Unit
) = Box(modifier = modifier) {
    val scope = rememberCoroutineScope()
    var routeId by rememberSaveable { mutableStateOf("") }
    var routeSequence by rememberSaveable { mutableStateOf("") }


    Column {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .weight(5f),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextField(
                modifier = modifier.fillMaxWidth(),
                value = routeId,
                onValueChange = { routeId = it },
                label = {
                    Text(text = "Route Id")
                }
            )

            TextField(
                modifier = modifier.fillMaxWidth(),
                value = routeSequence,
                onValueChange = { routeSequence = it },
                label = {
                    Text(text = "Region Sequence")
                }
            )
        }


        Button(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
                .weight(1f),
            onClick = {
                scope.launch {
                    onResponseReceived(
                        client.fetchStopListByRoute(routeId, routeSequence).getOrNull()
                    )
                }
            }
        ) {
            Text(text = "Fetch Stop Route List")
        }
    }
}
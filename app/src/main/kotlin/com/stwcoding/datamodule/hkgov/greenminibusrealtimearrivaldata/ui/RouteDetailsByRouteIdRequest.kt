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
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.route.RouteDetailsResponse
import kotlinx.coroutines.launch

@Composable
fun RouteDetailsByRouteIdRequest(
    modifier: Modifier = Modifier,
    client: GreenMinibusRealTimeArrivalClient,
    onResponseReceived: (RouteDetailsResponse?) -> Unit
) = Box(modifier = modifier) {
    val scope = rememberCoroutineScope()
    var regionId by rememberSaveable { mutableStateOf("") }

    Column {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .weight(5f),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextField(
                modifier = modifier.fillMaxWidth(),
                value = regionId,
                onValueChange = { regionId = it },
                label = {
                    Text(text = "Region Id")
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
                        client.fetchRouteDetails(regionId).getOrNull()
                    )
                }
            }
        ) {
            Text(text = "Fetch Route Details")
        }
    }
}
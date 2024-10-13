/*
 * Copyright© 2024. singtsun9941. All rights reserved.
 * 版權所有© 2024. singtsun9941
 */

package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.GreenMinibusRealTimeArrivalRemoteDataSource
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.Region
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.GMBResponse
import kotlinx.coroutines.launch

@Composable
fun RouteListingRequest(
    modifier: Modifier = Modifier,
    client: GreenMinibusRealTimeArrivalRemoteDataSource,
    onResponseReceived: (GMBResponse?) -> Unit
) = Box(modifier = modifier) {
    val scope = rememberCoroutineScope()
    var region by rememberSaveable { mutableStateOf<Region?>(null) }
    val api by remember(region) {
        mutableStateOf(client.getRouteListAPI(region))
    }

    Column {
        DropdownInput(
            modifier = modifier
                .padding(16.dp)
                .weight(5f),
            description = "RegionModel: $region",
            radioList = Region.entries.map {
                it.name to it
            }
        ) {
            region = it
        }

        Button(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
                .weight(1f),
            onClick = {
                scope.launch {
                    onResponseReceived(
                        api.fetch().getOrNull()
                    )
                }
            }
        ) {
            Text(text = "Fetch Route List")
        }

        Button(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
                .weight(1f),
            onClick = {
                scope.launch {
                    onResponseReceived(
                        api.fetchLastUpdate().getOrNull()
                    )
                }
            }
        ) {
            Text(text = "Route List Last update")
        }
    }
}
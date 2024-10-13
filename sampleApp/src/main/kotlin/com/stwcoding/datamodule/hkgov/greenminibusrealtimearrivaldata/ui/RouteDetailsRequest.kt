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
fun RouteDetailsRequest(
    modifier: Modifier = Modifier,
    client: GreenMinibusRealTimeArrivalRemoteDataSource,
    onResponseReceived: (GMBResponse?) -> Unit
) = Box(modifier = modifier) {
    val scope = rememberCoroutineScope()

    var region by rememberSaveable { mutableStateOf(Region.NewTerritories) }
    var regionCode by rememberSaveable { mutableStateOf("") }
    val api by remember(region, regionCode) {
        mutableStateOf(client.getRouteDetailsAPI(region, regionCode))
    }

    Column {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .weight(5f),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DropdownInput(
                description = "RegionModel: $region",
                radioList = Region.entries.map {
                    it.name to it
                },
                isNullable = false
            ) {
                it?.let {
                    region = it
                }
            }

            TextField(
                modifier = modifier.fillMaxWidth(),
                value = regionCode,
                onValueChange = { regionCode = it },
                label = {
                    Text(text = "Region Code")
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
                        api.fetch().getOrNull()
                    )
                }
            }
        ) {
            Text(text = "Fetch Route Details")
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
            Text(text = "Fetch Route Details Last update")
        }
    }
}
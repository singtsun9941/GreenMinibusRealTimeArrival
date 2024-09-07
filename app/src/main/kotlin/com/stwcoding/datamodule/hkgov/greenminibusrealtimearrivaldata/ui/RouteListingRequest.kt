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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.GreenMinibusRealTimeArrivalClient
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.RegionModel
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.response.routelisting.IRouteListingResponse
import kotlinx.coroutines.launch

@Composable
fun RouteListingRequest(
    modifier: Modifier = Modifier,
    client: GreenMinibusRealTimeArrivalClient,
    onResponseReceived: (IRouteListingResponse?) -> Unit
) = Box(modifier = modifier) {
    val scope = rememberCoroutineScope()
    var regionModel by rememberSaveable { mutableStateOf<RegionModel?>(null) }

    Column {
        DropdownInput(
            modifier = modifier
                .padding(16.dp)
                .weight(5f),
            description = "RegionModel: $regionModel",
            radioList = RegionModel.entries.map {
                it.name to it
            }
        ) {
            regionModel = it
        }

        Button(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
                .weight(1f),
            onClick = {
                scope.launch {
                    onResponseReceived(
                        client.routeListing(regionModel).getOrNull()
                    )
                }
            }
        ) {
            Text(text = "Route Listing")
        }
    }
}
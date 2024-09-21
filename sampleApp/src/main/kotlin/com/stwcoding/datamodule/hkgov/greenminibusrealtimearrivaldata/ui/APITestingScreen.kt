/*
 * Copyright© 2024. singtsun9941. All rights reserved.
 * 版權所有© 2024. singtsun9941
 */

package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun APITestingScreen(
    title: String,
    vararg requestTestingBlocks: @Composable (MutableStateFlow<String?>) -> Unit
) = Scaffold { innerPadding ->
    val scaffoldState = rememberBottomSheetScaffoldState()
    val responseState = MutableStateFlow<String?>(null)
    val responseString by responseState.collectAsState()

    BottomSheetScaffold(
        modifier = Modifier.padding(innerPadding),
        scaffoldState = scaffoldState,
        sheetPeekHeight = 100.dp,
        sheetContent = {
            Column(
                modifier = Modifier
                    .height(500.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(text = "Response:")
                Text(text = responseString.orEmpty())
            }
        },
    ) {
        val pagerState = rememberPagerState(
            pageCount = { requestTestingBlocks.size }
        )
        Column(
            modifier = Modifier.padding(bottom = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = title,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                lineHeight = 34.sp,
            )
            HorizontalPager(
                modifier = Modifier.fillMaxSize(),
                state = pagerState,
            ) { index ->
                requestTestingBlocks[index](responseState)
            }
        }
    }
}
/*
 * Copyright© 2024. singtsun9941. All rights reserved.
 * 版權所有© 2024. singtsun9941
 */

package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> DropdownInput(
    modifier: Modifier = Modifier,
    description: String,
    radioList: List<Pair<String, T>>,
    isNullable: Boolean = true,
    onSelected: (T?) -> Unit
) {
    var isContextMenuVisible by rememberSaveable { mutableStateOf(false) }

    Box(modifier = modifier) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                isContextMenuVisible = true
            }
        ) {
            Text(
                modifier = Modifier.padding(12.dp),
                text = description
            )
            DropdownMenu(
                expanded = isContextMenuVisible,
                onDismissRequest = { isContextMenuVisible = false }) {
                if (isNullable) {
                    DropdownMenuItem(
                        onClick = {
                            onSelected(null)
                            isContextMenuVisible = false
                        },
                        text = { Text(text = "null") }
                    )
                }
                radioList.forEach { (description, value) ->
                    DropdownMenuItem(
                        onClick = {
                            onSelected(value)
                            isContextMenuVisible = false
                        },
                        text = { Text(text = description) }
                    )
                }
            }
        }
    }
}
package com.plcoding.translator_kmm.android.translate.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.plcoding.translator_kmm.R
import com.plcoding.translator_kmm.android.TranslatorTheme
import com.plcoding.translator_kmm.android.core.theme.LightBlue
import com.plcoding.translator_kmm.android.translate.presentation.compose.TPreviewScreens
import com.plcoding.translator_kmm.core.domain.language.Language
import com.plcoding.translator_kmm.core.presentation.UiLanguage

@Composable
fun LanguageDropDown(
    language: UiLanguage,
    isOpen: Boolean,
    onClick: () -> Unit,
    onDismiss: () -> Unit,
    onSelectLanguage: (UiLanguage) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        DropdownMenu(
            expanded = isOpen,
            onDismissRequest = onDismiss
        ) {
            UiLanguage.allLanguages.forEach { language ->
                LanguageDropDownItem(
                    language = language,
                    onClick = {
                        onSelectLanguage(language)
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Row(
            modifier = Modifier
                .clickable(onClick = onClick)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = language.drawableRes,
                contentDescription = language.language.langName,
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = language.language.langName,
                color = LightBlue
            )
            Icon(
                imageVector = if (isOpen) Icons.Default.ArrowDropUp else Icons.Default.ArrowDropDown,
                contentDescription = if (isOpen) {
                    stringResource(id = com.plcoding.translator_kmm.android.R.string.close)
                } else {
                    stringResource(id = com.plcoding.translator_kmm.android.R.string.open)
                },
                tint = LightBlue,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}

@Composable
@TPreviewScreens
private fun LanguageDropDownPreview() {
    TranslatorTheme {
        LanguageDropDown(
            language = UiLanguage(
                drawableRes = R.drawable.english,
                language = Language.ENGLISH
            ),
            isOpen = true,
            onClick = {},
            onDismiss = {},
            onSelectLanguage = { },
            modifier = Modifier
                .fillMaxSize()
        )
    }
}
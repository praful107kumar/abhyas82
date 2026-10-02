package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF90CAF9),
    onPrimary = Color(0xFF003258),
    primaryContainer = Color(0xFF0D47A1),
    onPrimaryContainer = Color(0xFFD1E4FF),
    secondary = Color(0xFF80DEEA),
    onSecondary = Color(0xFF00363D),
    secondaryContainer = Color(0xFF004F58),
    onSecondaryContainer = Color(0xFFBCEBF2),
    tertiary = AbhyasAmber,
    onTertiary = Color(0xFF3E2800),
    tertiaryContainer = Color(0xFF5B3C00),
    onTertiaryContainer = Color(0xFFFFDEA8),
    background = Color(0xFF0F172A),
    surface = Color(0xFF1E293B),
    surfaceVariant = Color(0xFF334155),
    onBackground = Color(0xFFF1F5F9),
    onSurface = Color(0xFFF8FAFC)
)

private val LightColorScheme = lightColorScheme(
    primary = AbhyasNavy,
    onPrimary = Color.White,
    primaryContainer = AbhyasLightBlue,
    onPrimaryContainer = Color(0xFF072146),
    secondary = AbhyasTeal,
    onSecondary = Color.White,
    secondaryContainer = AbhyasTealLight,
    onSecondaryContainer = Color(0xFF004D40),
    tertiary = AbhyasAmber,
    onTertiary = Color.White,
    tertiaryContainer = AbhyasAmberLight,
    onTertiaryContainer = Color(0xFF78350F),
    background = BackgroundLight,
    surface = SurfaceLight,
    surfaceVariant = SurfaceVariantLight,
    onBackground = TextPrimary,
    onSurface = TextPrimary,
    outline = OutlineLight
)

@Composable
fun AbhyasTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Use our branded theme by default
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

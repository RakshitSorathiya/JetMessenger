package com.se7en.jetmessenger.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Box
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Stack
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.se7en.jetmessenger.data.me
import dev.chrisbanes.accompanist.coil.CoilImageWithCrossfade


@Composable
fun CircleBorderAvatar(
    imageData: Any,
    size: Dp = 56.dp,
    modifier: Modifier = Modifier,
    border: BorderStroke? = null,
    borderInnerPadding: Dp = 5.dp
) {
    Box(
        modifier = modifier.size(size),
        shape = CircleShape,
        border = border,
        padding = if(border != null) borderInnerPadding else 0.dp,
    ) {
        CircleImage(imageData)
    }
}

@Composable
fun CircleBadgeAvatar(
    imageData: Any,
    size: Dp = 56.dp,
    modifier: Modifier = Modifier,
    showBadge: Boolean = true,
    badgeColor: Color = Color.Green,
    badgeBackgroundColor: Color = MaterialTheme.colors.background
) {
    Stack(
        modifier = modifier.size(size)
    ) {
        CircleImage(
            imageData,
            modifier = Modifier.align(Alignment.Center)
        )

        if(showBadge) {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(size / 3)
                    .background(badgeBackgroundColor, CircleShape)
                    .padding(4.dp)
                    .background(badgeColor, CircleShape)
            )
        }
    }
}

@Composable
fun CircleImage(
    imageData: Any,
    modifier: Modifier = Modifier
) {
    CoilImageWithCrossfade(
        data = imageData,
        modifier = modifier
            .aspectRatio(1f)
            .clip(CircleShape),
        contentScale = ContentScale.Crop
    )
}

@Preview(showBackground = true)
@Composable
fun CircleBorderAvatarPreview() {
    CircleBorderAvatar(
        me.picture.medium,
        border = BorderStroke(2.dp, Color.Blue)
    )
}

@Preview(showBackground = true)
@Composable
fun CircleBadgeAvatarPreview() {
    CircleBadgeAvatar(me.picture.medium)
}

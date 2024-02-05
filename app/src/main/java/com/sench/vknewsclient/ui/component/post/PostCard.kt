package com.sench.vknewsclient.ui.component.post

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Chat
import androidx.compose.material.icons.automirrored.rounded.ReplyAll
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.RemoveRedEye
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sench.vknewsclient.R
import com.sench.vknewsclient.util.PreviewTheme
import com.sench.vknewsclient.util.formatToCompactForm

@Composable
fun PostCard(
    publicImage: Painter,
    postImage: Painter,
    publicTitle: String,
    timePost: String,
    description: String,
    socialCounters: SocialCounters,
    onClickOptions: () -> Unit
) {
    Card(modifier = Modifier.padding(8.dp)) {
        Column {
            PostCardHeader(
                image = publicImage,
                publicTitle = publicTitle,
                time = timePost,
                onClickOptions = onClickOptions,
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 12.dp,
                    bottom = 16.dp,
                    end = 4.dp
                )
            )

            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 12.dp),
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = postImage,
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
            PostCardFooter(
                socialCounters = socialCounters,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
private fun PostCardHeader(
    image: Painter,
    publicTitle: String,
    time: String,
    onClickOptions: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
        )
        Column(modifier = Modifier.padding(start = 16.dp)) {
            Text(
                text = publicTitle,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = time,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = onClickOptions) {
            Icon(imageVector = Icons.Rounded.MoreVert, contentDescription = null)
        }
    }
}

@Composable
private fun PostCardFooter(
    socialCounters: SocialCounters,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SocialCounter(
            imageVector = Icons.Rounded.FavoriteBorder,
            count = socialCounters.likes
        )

        SocialCounter(
            imageVector = Icons.AutoMirrored.Rounded.Chat,
            count = socialCounters.comments
        )

        SocialCounter(
            imageVector = Icons.AutoMirrored.Rounded.ReplyAll,
            count = socialCounters.reposts
        )

        Spacer(modifier = Modifier.weight(1f))

        SocialCounter(
            imageVector = Icons.Rounded.RemoveRedEye,
            count = socialCounters.views,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun SocialCounter(
    imageVector: ImageVector,
    count: Long,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onSurface
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            modifier = Modifier
                .padding(end = 8.dp)
                .size(18.dp),
            tint = color
        )

        Text(
            text = count.formatToCompactForm(),
            style = MaterialTheme.typography.labelSmall,
            color = color
        )
    }
}

@Composable
@PreviewTheme
private fun PreviewPostCard() {
    PreviewTheme {
        PostCard(
            publicImage = painterResource(id = R.drawable.post_comunity_thumbnail),
            postImage = painterResource(id = R.drawable.post_content_image),
            socialCounters = SocialCounters(views = 10000),
            publicTitle = "уволено",
            timePost = "14:00",
            description = "кабаныч, когда узнал, что " +
                    "если сотрудникам не платить, то они начинают умирать от голода",
            onClickOptions = {}
        )
    }
}
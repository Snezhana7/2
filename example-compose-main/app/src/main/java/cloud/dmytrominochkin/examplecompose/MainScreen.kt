package cloud.dmytrominochkin.examplecompose

import androidx.activity.compose.BackHandler
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import cloud.dmytrominochkin.examplecompose.model.User
import cloud.dmytrominochkin.examplecompose.ui.components.StatusBarColorProvider
import cloud.dmytrominochkin.examplecompose.ui.feed.Feed
import cloud.dmytrominochkin.examplecompose.ui.profile.Profile

@ExperimentalAnimationApi
@Composable
fun MainScreen() {
    StatusBarColorProvider()
    Surface(color = MaterialTheme.colors.onSurface) {
        var selectedId by rememberSaveable { mutableStateOf<String?>(null) }
        Crossfade(targetState = selectedId) { id ->
            if (id == null) {
                Feed(
                    users,
                    onSelected = { selectedId = it.id }
                )
            } else {
                Profile(users.first { it.id == id })
                BackHandler {
                    selectedId = null
                }
            }
        }
    }
}

private val users = mutableListOf(
    User(
        "1",
        "Крош",
        "Man",
        R.drawable.an1,
        "18",
        "Весёлый и энергичный кролик-непоседа, по темпераменту холерик. Он суетлив и часто перебивает собеседника, часто моргает сначала правым глазом, потом левым, любит приключения вроде похода в горы или подводного плавания и всё время втягивает Ёжика в свои авантюры.",
        listOf("food", "fashion", "nature", "dogs", "people", "selfies", "style", "fashion", "cats"),

    ),
    User(
        "2",
        "Бараш",
        "Man",
        R.drawable.an2,
        "18",
        "Это барашек, поэт-лирик, он вздыхает и пишет стихи о печали, меланхолик. Его тонкую натуру легко обидеть, поэтому Бараш требует много внимания от окружающих, которое он привлекает своей несчастностью и непонятливостью.",
        listOf("people", "selfies", "style", "fashion"),

    ),
    User(
        "3",
        "Ёжик",
        "Man",
        R.drawable.an3,
        "18",
        "Серьёзный и совестливый друг Кроша, флегматик. В отличие от своего приятеля, Ёжик очень хорошо воспитан, рассудителен, и потому не сопротивляется активности и напористости друга. Он понимает, когда Крош не прав, и помогает ему в общении с другими.",
        listOf("selife", "cats", "nature", "fashion"),

    )
)
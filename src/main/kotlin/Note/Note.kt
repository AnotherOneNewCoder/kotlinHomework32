package Note

/*title string Заголовок заметки.
text string Текст заметки.
privacy integer Уровень доступа к заметке.
Возможные значения:
0 — все пользователи,
1 — только друзья,
2 — друзья и друзья друзей,
3 — только пользователь.
comment_privacy integer Уровень доступа к комментированию заметки.
Возможные значения:
0 — все пользователи,
1 — только друзья,
2 — друзья и друзья друзей,
3 — только пользователь.
privacy_view string Настройки приватности просмотра заметки в специальном формате - Это значение я пропущу.
privacy_comment string Настройки приватности комментирования заметки в специальном формате - Это значение я пропущу.*/

data class Note(
    val id: Int,
    val title: String,
    val text: String,
    val privacy: Int,
    val comment_privacy: Int
) {
    override fun toString(): String {
        return "Note: id $id title $title"
    }
}
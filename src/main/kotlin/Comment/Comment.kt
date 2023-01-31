package Comment

data class Comment(
    val note_id: Int,
    val cid: Int,
    val message: String
) {
    override fun toString(): String {
        return "Note_id: $note_id, Cid: $cid, Messege: $message"
    }
}
package Note

import Comment.Comment
/*add - Создает новую заметку у текущего пользователя.
createComment - Добавляет новый комментарий к заметке.
delete - Удаляет заметку текущего пользователя.
deleteComment - Удаляет комментарий к заметке.
edit - Редактирует заметку текущего пользователя.
editComment - Редактирует указанный комментарий у заметки.
get - Возвращает список заметок, созданных пользователем.
getById - Возвращает заметку по её id.
getComments - Возвращает список комментариев к заметке.
getFriendsNotes - Возвращает список заметок друзей пользователя.
restoreComment- Восстанавливает удалённый комментарий*/
object WorkWithNotes {
    var noteId = 0
    var commetId = 0
    var noteArray = mutableListOf<Note>()
    var commentArray = mutableListOf<Comment>()
    var deletedCommentsArray = mutableListOf<Comment>()

    class GenericPair<A,B>(var first:A, var second:B)
    fun add(note: Note): Note {
        val addedNote = note.copy(id =++noteId)
        noteArray.add(addedNote)
        return noteArray.last()
    }
    fun printNotes(){
        for (note in noteArray)
            println(note)
    }
    fun createComment(count:Int,comment: Comment ): Boolean{
        for (note in noteArray) {
            if (count == note.id){
                val createComment = comment.copy(note_id =note.id, cid = ++commetId)
                commentArray.add(createComment)
                return true
            }
        }
        return false
    }
    fun printComments(){
        for (comment in commentArray)
            println(comment)
    }
    fun deleteComment(count: Int){
        for (comment in commentArray){
                if (count == comment.cid) {
                    deletedCommentsArray.add(comment)

                }
        }
        commentArray.removeAll { it.cid ==count }
    }
    fun edit(count: Int, newNote: Note) : Boolean{
        for ((index, note) in noteArray.withIndex()) {
            if (note.id == count) {
                val newN = note.copy(id = note.id, title = newNote.title, text = newNote.text, privacy = newNote.privacy, comment_privacy = newNote.comment_privacy)
                noteArray.set(index, newN)
                return true
            }
        }
        return false
    }

    fun editComment() {
        TODO("Not yet implemented")
    }

    fun get() {
        TODO("Not yet implemented")
    }

    fun getById() {
        TODO("Not yet implemented")
    }

    fun getComments() {
        TODO("Not yet implemented")
    }

    fun getFriendsNotes() {
        TODO("Not yet implemented")
    }

    fun restoreComment() {
        TODO("Not yet implemented")
    }

}



package Note

import Comment.Comment
import Generics.CrudService


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



    fun add(note: Note): Note {
        val addedNote = note.copy(id =++noteId)
        noteArray.add(addedNote)
        return noteArray.last()
    }
    // Для проверки:
//    fun printNotes(){
//        for (note in noteArray)
//            println(note)
//    }
    fun createComment(noteId:Int,comment: Comment ): Boolean{
        for (note in noteArray) {
            if (noteId == note.id){
                val createComment = comment.copy(note_id =note.id, cid = ++commetId)
                commentArray.add(createComment)
                return true
            }
        }
        return false
    }
    // Для проверки:
    fun printComments(){
        for (comment in commentArray)
            println(comment)
    }
    fun delete(noteId: Int): Boolean {
        var success = false
        for (note in noteArray) {
            if (note.id == noteId)
                success = true
        }
        noteArray.removeAll { it.id == noteId }
        commentArray.removeAll { it.note_id == noteId }
        return success
    }
    fun deleteComment(commentId: Int): Boolean{
        var success = false
        for (comment in commentArray){
                if (commentId == comment.cid) {
                    deletedCommentsArray.add(comment)
                    success = true
                }
        }
        commentArray.removeAll { it.cid ==commentId }
        return success
    }
    fun edit(noteId: Int, newNote: Note) : Boolean{
        for ((index, note) in noteArray.withIndex()) {
            if (note.id == noteId) {
                val newN = note.copy(id = note.id, title = newNote.title, text = newNote.text, privacy = newNote.privacy, comment_privacy = newNote.comment_privacy)
                noteArray.set(index, newN)
                return true
            }
        }
        return false
    }


    fun editComment(commentId: Int, comment: Comment): Boolean {
        for ((index, comm) in commentArray.withIndex()) {
            if (comm.cid == commentId) {
                val editComment = comment.copy(note_id = comm.note_id, cid = comm.cid)
                commentArray.set(index,editComment)
                return true
            }
        }
        return false
    }

    fun get(): List<Note> {
        return noteArray
    }

    fun getById(noteId: Int): Note? {
        for (note in noteArray){
            if (note.id == noteId){
                return note
            }
        }
        return null
    }

    fun getComments(noteId: Int): List<Comment> {
        val temList = mutableListOf<Comment>()
        for (comm in commentArray) {
            if (comm.note_id == noteId) {
                temList.add(comm)
            }

        }
        return temList
    }

    fun getFriendsNotes():List<Note> {
        val tempFriendsNotesList = mutableListOf<Note>()
        for (note in noteArray) {
            if (note.privacy == 1) {
                tempFriendsNotesList.add(note)
            }
        }
        return tempFriendsNotesList
    }

    fun restoreComment(commentId: Int): Boolean {
        var success:Boolean = false
        for (comm in deletedCommentsArray) {
            if (commentId == comm.cid) {
                commentArray.add(comm)
                success = true
            }
        }
        if (success == true)
            deletedCommentsArray.removeAll { it.cid ==commentId }
        return success
    }


}



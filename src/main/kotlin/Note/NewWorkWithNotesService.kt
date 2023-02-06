package Note

import Comment.Comment
import Generics.CrudService

class NewWorkWithNotesService(first: MutableList<Note>, second: MutableList<Comment>, third: MutableList<Comment>):
    CrudService<Note, Comment>(first, second, third) {
    var noteId = 0
    var commetId = 0
    var noteArray = first
    var commentArray = second
    var deletedCommentsArray = third

    fun add(note: Note): Note {
        val addedNote = note.copy(id =++WorkWithNotes.noteId)
        WorkWithNotes.noteArray.add(addedNote)
        return WorkWithNotes.noteArray.last()
    }
    // Для проверки:
//    fun printNotes(){
//        for (note in noteArray)
//            println(note)
//    }
    fun createComment(noteId:Int,comment: Comment ): Boolean{
        for (note in WorkWithNotes.noteArray) {
            if (noteId == note.id){
                val createComment = comment.copy(note_id =note.id, cid = ++WorkWithNotes.commetId)
                WorkWithNotes.commentArray.add(createComment)
                return true
            }
        }
        return false
    }
    // Для проверки:
    fun printComments(){
        for (comment in WorkWithNotes.commentArray)
            println(comment)
    }
    fun delete(noteId: Int): Boolean {
        var success = false
        for (note in WorkWithNotes.noteArray) {
            if (note.id == noteId)
                success = true
        }
        WorkWithNotes.noteArray.removeAll { it.id == noteId }
        WorkWithNotes.commentArray.removeAll { it.note_id == noteId }
        return success
    }
    fun deleteComment(commentId: Int): Boolean{
        var success = false
        for (comment in WorkWithNotes.commentArray){
            if (commentId == comment.cid) {
                WorkWithNotes.deletedCommentsArray.add(comment)
                success = true
            }
        }
        WorkWithNotes.commentArray.removeAll { it.cid ==commentId }
        return success
    }
    fun edit(noteId: Int, newNote: Note) : Boolean{
        for ((index, note) in WorkWithNotes.noteArray.withIndex()) {
            if (note.id == noteId) {
                val newN = note.copy(id = note.id, title = newNote.title, text = newNote.text, privacy = newNote.privacy, comment_privacy = newNote.comment_privacy)
                WorkWithNotes.noteArray.set(index, newN)
                return true
            }
        }
        return false
    }


    fun editComment(commentId: Int, comment: Comment): Boolean {
        for ((index, comm) in WorkWithNotes.commentArray.withIndex()) {
            if (comm.cid == commentId) {
                val editComment = comment.copy(note_id = comm.note_id, cid = comm.cid)
                WorkWithNotes.commentArray.set(index,editComment)
                return true
            }
        }
        return false
    }

    fun get(): List<Note> {
        return WorkWithNotes.noteArray
    }

    fun getById(noteId: Int): Note? {
        for (note in WorkWithNotes.noteArray){
            if (note.id == noteId){
                return note
            }
        }
        return null
    }

    fun getComments(noteId: Int): List<Comment> {
        val temList = mutableListOf<Comment>()
        for (comm in WorkWithNotes.commentArray) {
            if (comm.note_id == noteId) {
                temList.add(comm)
            }

        }
        return temList
    }

    fun getFriendsNotes():List<Note> {
        val tempFriendsNotesList = mutableListOf<Note>()
        for (note in WorkWithNotes.noteArray) {
            if (note.privacy == 1) {
                tempFriendsNotesList.add(note)
            }
        }
        return tempFriendsNotesList
    }

    fun restoreComment(commentId: Int): Boolean {
        var success:Boolean = false
        for (comm in WorkWithNotes.deletedCommentsArray) {
            if (commentId == comm.cid) {
                WorkWithNotes.commentArray.add(comm)
                success = true
            }
        }
        if (success == true)
            WorkWithNotes.deletedCommentsArray.removeAll { it.cid ==commentId }
        return success
    }

}
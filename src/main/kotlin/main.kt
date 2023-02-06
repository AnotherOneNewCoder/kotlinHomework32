import Comment.Comment
import Note.NewWorkWithNotesService
import Note.Note
import Note.WorkWithNotes

fun main() {
    val firstNote = Note(144,"first note","bla-bla",0,0)
    val secondNote = Note(144,"second note","bla-bla",0,0)
    val thirdNote = Note(144,"third note","bla-bla",0,0)
    val editedNote = Note(144,"edited note","bla-bla",0,0)

    val firstComment = Comment(111, 111, "first comment")
    val secondComment = Comment(111, 111, "second comment")
    val thirdComment = Comment(111, 111, "third comment")
    val editComment = Comment(111, 111, "edit comment")
    var noteArray = mutableListOf<Note>()
    var commentArray = mutableListOf<Comment>()
    var deletedCommentsArray = mutableListOf<Comment>()

    val service = NewWorkWithNotesService(noteArray,commentArray,deletedCommentsArray)
    service.add(firstNote)
    service.add(secondNote)
    service.add(thirdNote)
    println(service.get())
//    WorkWithNotes.add(firstNote)
//    WorkWithNotes.add(secondNote)
//    WorkWithNotes.add(thirdNote)
//    println(WorkWithNotes.get())
//    println(WorkWithNotes.getById(3))
//    println(WorkWithNotes.getById(44))
//    WorkWithNotes.edit(3,editedNote)
//
//
//    WorkWithNotes.createComment(2,firstComment)
//    WorkWithNotes.createComment(2,secondComment)
//    WorkWithNotes.createComment(3,thirdComment)
//    WorkWithNotes.editComment(3, editComment)
//    WorkWithNotes.printComments()
//    WorkWithNotes.deleteComment(1)
//    WorkWithNotes.printComments()
//    WorkWithNotes.restoreComment(1)
//    WorkWithNotes.printComments()
//    println(WorkWithNotes.get())
//    WorkWithNotes.delete(2)
//    println(WorkWithNotes.get())
//    WorkWithNotes.printComments()
//    println(WorkWithNotes.delete(111))
}
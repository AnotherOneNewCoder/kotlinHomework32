import Comment.Comment
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

    WorkWithNotes.add(firstNote)
    WorkWithNotes.add(secondNote)
    WorkWithNotes.add(thirdNote)
    WorkWithNotes.printNotes()

    WorkWithNotes.createComment(1,firstComment)
    WorkWithNotes.createComment(2,secondComment)
    WorkWithNotes.createComment(3,thirdComment)
    WorkWithNotes.printComments()
    WorkWithNotes.deleteComment(1)
    WorkWithNotes.printComments()
    WorkWithNotes.edit(3,editedNote)
    WorkWithNotes.printNotes()
}
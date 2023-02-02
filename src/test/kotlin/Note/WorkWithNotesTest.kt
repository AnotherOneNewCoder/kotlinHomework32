package Note

import Comment.Comment
import org.junit.Test

import org.junit.Assert.*

class WorkWithNotesTest {
    var noteId = 0
    var commetId = 0
    val service = WorkWithNotes
    val firstNote = Note(144,"first note","bla-bla",0,0)

    @Test
    fun add() {
        val tempNote = Note(11,"test","",0,0)
        ++noteId
        val result = service.add(tempNote)
        val expected = Note(4,"test", "",0,0)
        assertEquals(expected,result)
    }

    @Test
    fun createCommentDone() {
        val tempComment = Comment(111,111,"first comment")
        ++commetId
        service.add(firstNote)
        val result = service.createComment(1,tempComment)
        assertTrue(result)
    }
    @Test
    fun createCommentFail() {
        val tempComment = Comment(111,111,"first comment")
        val result = service.createComment(17,tempComment)
        assertFalse(result)
    }



    @Test
    fun deleteDone() {
        val result = service.delete(1)
        assertTrue(result)
    }
    @Test
    fun deleteFail() {
        val result = service.delete(111)
        assertFalse(result)
    }

    @Test
    fun deleteCommentDone() {
        val tempNote = Note(11,"test","",0,0)
        service.add(tempNote)
        val tempComment = Comment(1,1,"first comment")
        service.createComment(1,tempComment)
        val result = service.deleteComment(1)

        assertTrue(result)
    }
    @Test
    fun deleteCommentFail() {
        val result = service.deleteComment(11)
        assertFalse(result)
    }

    @Test
    fun editDone() {
        val tempNote = Note(11,"test2","111",0,0)
        val result = service.edit(1, tempNote)
        assertTrue(result)
    }
    @Test
    fun editFalse() {
        val tempNote = Note(11,"test2","111",0,0)
        val result = service.edit(13, tempNote)
        assertFalse(result)
    }
    @Test
    fun editCommentDone() {
        val tempComment = Comment(11,3,"test2")
        val result = service.editComment(2,tempComment)
        assertTrue(result)
    }

    @Test
    fun editCommentFail() {
        val tempArray = WorkWithNotes.getComments(1).toString()
        val tempComment = Comment(11,3,"test2")
        val result = service.editComment(42,tempComment)
        assertFalse(result)
    }

    @Test
    fun get() {

        val result = service.get().toString()
        val expected = "[Note: id 1 title test, Note: id 2 title Friend, Note: id 3 title first note, Note: id 4 title test]"
        assertEquals(expected,result)
    }

    @Test
    fun getById() {
        var result = service.getById(2)
        val expected = Note(2,"Friend", "note for friends", 1, 1)
        assertEquals(expected,result)
    }
    @Test
    fun getByIdNull() {
        var result = service.getById(4)
        val expected = null
        assertEquals(expected,result)
    }

    @Test
    fun getComments() {
        val result = service.getComments(1).toString()
        val expected = "[Note_id: 1, Cid: 2, Messege: test2]"
        assertEquals(expected,result)
    }

    @Test
    fun getFriendsNotes() {
        val tempNote = Note(333,"Friend", "note for friends", 1, 1)
        service.add(tempNote)
        val result = service.getFriendsNotes().toString()
        val expected = "[Note: id 2 title Friend]"
        assertEquals(expected,result)
    }

    @Test
    fun restoreCommentDone() {

        val restore = service.restoreComment(1)
        assertTrue(restore)
    }
    @Test
    fun restoreCommentFail() {

        val restore = service.restoreComment(16)
        assertFalse(restore)
    }
}
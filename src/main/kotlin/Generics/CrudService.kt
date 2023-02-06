package Generics

import Note.WorkWithNotes

open class CrudService<A, B>(var first: List<A>, var second: List<B>, var third: List<B>) {
}
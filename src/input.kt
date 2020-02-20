import java.io.File

data class Lib(val libid:Int,val bookPerDay:Int, val signUpTime:Int,val booksList:MutableList<Book>,var maxScore:Int=0)
data class Book(val id:Int,val  score:Int)

fun main() {
val file = File("abc.txt")
    val readLines = file.readLines()
    val mainInfo = readLines[0].split(" ").map { it.toInt() }
    val books=mainInfo[0]
    val libraries=mainInfo[1]
    val days=mainInfo[2]

    val scoresList = readLines[1].split(" ").map { it.toInt() }
    val map = (0 until libraries)
        .map { i ->
            val libINfo = readLines[i + 2].split(" ").map { it.toInt() }
            val bookInLib = readLines[i + 3].split(" ").map { it.toInt() }.map { Book(it, scoresList[it]) }.toMutableList()
            Lib(libINfo[2], libINfo[1], bookInLib)
        }

}
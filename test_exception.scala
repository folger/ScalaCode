import java.io.FileReader
import java.io.IOException
import java.io.FileNotFoundException

val file = new FileReader("input.txt")
try {
  // something
}
catch {
  case ex: FileNotFoundException => println("File not found")
  case ex: IOException => println("IO")
}
finally {
  file.close()
}

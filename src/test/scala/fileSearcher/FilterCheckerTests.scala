package fileSearcher

import org.scalatest.FlatSpec
import java.io.File

class FilterCheckerTests extends FlatSpec{
  "FilterChecker passed a list where one file matches the filter" should
  "return a list with that file" in {
    val matchingFile = new FileObject(new File("match"))
    val listOfFiles = List(new FileObject(new File("random")), matchingFile)
    val matchedFiles = FilterChecker("match") findMatchedFiles listOfFiles
    assert(matchedFiles == List(matchingFile))
  }
  
  "FilterChecker passed a list with a directory that matches the filter" should
  "should not return the directory" in {
    val listOfIOObjects = List(new FileObject(new File("random")), new DirectoryObject(new File("match")))
    val matchedFiles = FilterChecker("match") findMatchedFiles listOfIOObjects
    assert(matchedFiles.isEmpty)
  }
}

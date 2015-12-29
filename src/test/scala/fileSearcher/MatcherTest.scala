package fileSearcher

import org.scalatest.FlatSpec
import java.io.File;

class MatcherTest extends FlatSpec{
  "Matcher that is passed a file matching the filter should" should
  "return a list with that file name" in {
    val matcher = new Matcher("fake", "fakePath")

    val results = matcher.execute()

    assert(results == List("fakePath"))
  }

  "Matcher using a directory containing one file matching the filter" should
  "return a list with that file name" in {
    val matcher = new Matcher("txt", new File("./testfiles/").getCanonicalPath)

    val results = matcher.execute()

    assert(results == List("readme.txt"))
  }

  "Matcher that is not passed a root directory" should
  "should use current directory" in {
    val matcher = new Matcher("filter")

    assert(matcher.rootLocation == new File(".").getCanonicalPath())
  }

}

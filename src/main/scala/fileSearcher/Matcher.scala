package fileSearcher

import java.io.File

class Matcher(filter: String, rootLocation: String) {
  val rootIOObject = FileConverter.convertToIOObject(new File(rootLocation))
}

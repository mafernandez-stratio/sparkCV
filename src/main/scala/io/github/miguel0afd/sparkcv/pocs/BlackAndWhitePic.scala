/*
 * Copyright 2017 Miguel Angel Fernandez Diaz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.miguel0afd.sparkcv.pocs

import org.bytedeco.javacpp.opencv_core._
import org.bytedeco.javacpp.opencv_imgproc._
import org.bytedeco.javacpp.opencv_imgcodecs._

object BlackAndWhitePic extends App {

  //val file: BufferedSource = Source.fromResource("birds-of-paradise.jpg", getClass.getClassLoader)
  val image: IplImage = cvLoadImage("src/main/resources/birds-of-paradise.jpg")
  //val image: IplImage = cvLoadImage(file)

  if (image != null) {
    val grayImage: IplImage = cvCreateImage(cvSize(image.width, image.height), IPL_DEPTH_8U, 1)
    cvCvtColor(image, grayImage, CV_BGR2GRAY)
    cvSaveImage("/tmp/output.jpg", grayImage)
    cvReleaseImage(image)
    println("SUCCESS: image created")
  } else {
    println("ERROR: image not found")
  }


}

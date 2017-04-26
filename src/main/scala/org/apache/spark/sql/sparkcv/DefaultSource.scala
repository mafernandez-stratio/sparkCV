package org.apache.spark.sql.sparkcv

import org.apache.spark.internal.Logging
import org.apache.spark.sql.{DataFrame, SQLContext, SaveMode}
import org.apache.spark.sql.sources.{BaseRelation, CreatableRelationProvider, RelationProvider, SchemaRelationProvider}
import org.apache.spark.sql.types.StructType
import org.bytedeco.javacpp.opencv_core.IplImage
import org.bytedeco.javacpp.opencv_imgcodecs.cvLoadImage

class DefaultSource
  extends RelationProvider
    with SchemaRelationProvider
    with CreatableRelationProvider
    with Logging {

  /**
    * Creates a new relation for a jpg image.
    * Parameters:
    *
    *   path (required)  -- Local path to a jpg image
    *
    */
  override def createRelation(sqlContext: SQLContext, parameters: Map[String, String]): BaseRelation = {
    createRelation(sqlContext, parameters, new StructType())
  }

  override def createRelation(sqlContext: SQLContext, parameters: Map[String, String], schema: StructType): BaseRelation = {
    assert(parameters.get("path").isDefined, "path parameter is required")
    val image: IplImage = cvLoadImage("src/main/resources/birds-of-paradise.jpg")
    ImageRelation(sqlContext, parameters, schema)
  }

  override def createRelation(sqlContext: SQLContext, mode: SaveMode, parameters: Map[String, String], data: DataFrame): BaseRelation = {
    ImageRelation(sqlContext, parameters, data.schema)
  }
}

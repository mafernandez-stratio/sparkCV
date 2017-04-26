package org.apache.spark.sql.sparkcv

import org.apache.spark.internal.Logging
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Row, SQLContext}
import org.apache.spark.sql.sources.{BaseRelation, Filter, InsertableRelation, PrunedFilteredScan}
import org.apache.spark.sql.types.StructType

case class ImageRelation(sqlContext: SQLContext, parameters: Map[String, String], schema: StructType)
  extends BaseRelation
    with InsertableRelation
    with PrunedFilteredScan
    with Logging {

  override def insert(data: DataFrame, overwrite: Boolean): Unit = logInfo("[TODO] insert")

  override def buildScan(requiredColumns: Array[String], filters: Array[Filter]): RDD[Row] = sqlContext.emptyDataFrame.rdd
}

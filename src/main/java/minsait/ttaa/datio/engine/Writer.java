package minsait.ttaa.datio.engine;

import minsait.ttaa.datio.common.naming.configuracion;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import java.io.FileReader;
import java.util.Properties;

import static minsait.ttaa.datio.common.Common.*;
import static minsait.ttaa.datio.common.naming.PlayerInput.nationality;
import static minsait.ttaa.datio.common.naming.PlayerInput.teamPosition;
import static org.apache.spark.sql.SaveMode.Overwrite;

abstract class Writer {

    static void write(Dataset<Row> df) {

        configuracion config= new configuracion();

        df
                .coalesce(1)
                .write()
                .partitionBy(nationality.getName())
                .mode(Overwrite)
                .parquet(config.getOutput());
    }

}

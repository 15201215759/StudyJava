package com.xuanli.flinkDemo01;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.AggregateOperator;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.runtime.executiongraph.Execution;
import org.apache.flink.util.Collector;

/**
 * @author aidan.xuan
 * @version 1.0
 * @date 2021/02/07 11:18
 */
// TODO: 2021/02/07  批处理程序，使用DataSet Api
public class wordcount {

    public static void main(String[] args) throws Exception {
        //创建执行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        //文件路径
        String inputPath="F:\\codeworkspace\\" +
                         "StudyJava\\StudyFlinkDemo01\\" +
                         "src\\main\\resources\\wordcount.txt";
        DataSet<String> inputDataSet = env.readTextFile(inputPath);
        //对数据集进行打散操作，转换为（word，1）的一个二元组
        AggregateOperator<Tuple2<String, Integer>> resultset = inputDataSet.flatMap(new MyFlatMapMapper())
                                                                           .groupBy(0)//按照第一个字段，分组
                                                                           .sum(1);// 把第二个位置求和
        //打印输出，并跑出异常
        resultset.print();

    }

    /**
     * 实现FlatMap功能接口
     */
    public static class MyFlatMapMapper implements FlatMapFunction<String,Tuple2<String,Integer>>  {
        @Override
        public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
            String[] words = value.split(" ");//切分获取的数据
            for (String word:words) {                 //遍历数据并收集成元组（word，1），并返回结果
                out.collect(new Tuple2<>(word,1));
            }
        }
    }
}

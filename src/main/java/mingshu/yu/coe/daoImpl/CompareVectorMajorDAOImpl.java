package mingshu.yu.coe.daoImpl;

import java.io.IOException;
import java.util.ArrayList;

import mingshu.yu.coe.HBaseConn;
import mingshu.yu.coe.dao.CompareVectorMajorDAO;
import mingshu.yu.coe.domain.CompareVectorMajor;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Repository;


@Repository("CompareVectorMajor")
public class CompareVectorMajorDAOImpl implements CompareVectorMajorDAO {

	@Override
	public ArrayList<CompareVectorMajor> listAll() {
		// TODO Auto-generated method stub
		ArrayList<CompareVectorMajor> compareVectorMajors = new ArrayList<CompareVectorMajor>();
		Scan scan = new Scan();
		ResultScanner rs = null;
        HTable table = null;
        
        try {
			table = new HTable(HBaseConn.getConf(), Bytes.toBytes("compare_vector_major_test"));
            rs = table.getScanner(scan);
            for (Result r : rs) {
            	CompareVectorMajor compareVectorMajor = new CompareVectorMajor();
            	//assign fileds of cityCountDistribution
                for (KeyValue kv : r.list()) {
                	compareVectorMajor.setValue(Bytes.toInt(kv.getValue()));
                	compareVectorMajor.setLabel(Bytes.toString(kv.getRow()));
                	
                	
                	System.out.println(compareVectorMajor.getLabel()+":"+compareVectorMajor.getValue());
                }
                compareVectorMajors.add(compareVectorMajor);
            }
            return compareVectorMajors;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return compareVectorMajors;
		} finally {
            rs.close();
            HBaseConn.hTableClose(table);
        }
		
		
	}

}

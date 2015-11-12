package mingshu.yu.coe.daoImpl;

import java.io.IOException;
import java.util.ArrayList;

import mingshu.yu.coe.HBaseConn;
import mingshu.yu.coe.dao.CompareVectorMinorDAO;
import mingshu.yu.coe.domain.CompareVectorMinor;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Repository;

@Repository("CompareVectorMinor")
public class CompareVectorMinorDAOImpl implements CompareVectorMinorDAO {

	@Override
	public ArrayList<CompareVectorMinor> listAll() {
		// TODO Auto-generated method stub
		ArrayList<CompareVectorMinor> compareVectorMinors = new ArrayList<CompareVectorMinor>();
		Scan scan = new Scan();
		ResultScanner rs = null;
        HTable table = null;
        
        try {
			table = new HTable(HBaseConn.getConf(), Bytes.toBytes("compare_vector_minor_test"));
            rs = table.getScanner(scan);
            for (Result r : rs) {
            	CompareVectorMinor compareVectorMinor = new CompareVectorMinor();
            	//assign fileds of cityCountDistribution
                for (KeyValue kv : r.list()) {
                	compareVectorMinor.setLabel(Bytes.toString(kv.getRow()));
                	compareVectorMinor.setValue(Bytes.toString(kv.getValue()));
                	
                	
                	System.out.println(compareVectorMinor.getLabel()+":"+compareVectorMinor.getValue());
                }
                compareVectorMinors.add(compareVectorMinor);
            }
            return compareVectorMinors;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return compareVectorMinors;
		} finally {
            rs.close();
            HBaseConn.hTableClose(table);
        }
		
	}

}

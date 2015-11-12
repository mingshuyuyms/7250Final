package mingshu.yu.coe.daoImpl;

import java.io.IOException;
import java.util.ArrayList;

import mingshu.yu.coe.HBaseConn;
import mingshu.yu.coe.dao.ZipCountDAO;
import mingshu.yu.coe.domain.ZipCount;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Repository;

@Repository("ZipCount")
public class ZipCountDAOImpl implements ZipCountDAO {

	@Override
	public ArrayList<ZipCount> listAll() {
		// TODO Auto-generated method stub
		ArrayList<ZipCount> zipCounts = new ArrayList<ZipCount>();
		Scan scan = new Scan();
		ResultScanner rs = null;
        HTable table = null;
        
        try {
			table = new HTable(HBaseConn.getConf(), Bytes.toBytes("zip_count_test"));
            rs = table.getScanner(scan);
            for (Result r : rs) {
            	ZipCount zipCount = new ZipCount();
            	//assign fileds of cityCountDistribution
                for (KeyValue kv : r.list()) {
                	zipCount.setCountp(Bytes.toString(kv.getValue()));
                	zipCount.setZip(Bytes.toString(kv.getRow()));
                	
//                	System.out.println(zipCount.getZip()+":"+zipCount.getCountp());
                }
                zipCounts.add(zipCount);
            }
            return zipCounts;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return zipCounts;
		} finally {
            rs.close();
            HBaseConn.hTableClose(table);
        }
	}

}

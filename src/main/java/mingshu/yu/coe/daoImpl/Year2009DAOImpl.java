package mingshu.yu.coe.daoImpl;

import java.io.IOException;
import java.util.ArrayList;

import mingshu.yu.coe.HBaseConn;
import mingshu.yu.coe.dao.Year2009DAO;
import mingshu.yu.coe.domain.Year2009;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Repository;

@Repository("Year2009")
public class Year2009DAOImpl implements Year2009DAO {

	@Override
	public ArrayList<Year2009> listAll() {
		// TODO Auto-generated method stub
		ArrayList<Year2009> year2009s = new ArrayList<Year2009>();
		Scan scan = new Scan();
		ResultScanner rs = null;
        HTable table = null;
        
        try {
			table = new HTable(HBaseConn.getConf(), Bytes.toBytes("month_first_year"));
            rs = table.getScanner(scan);
            for (Result r : rs) {
            	Year2009 year2009 = new Year2009();
            	//assign fileds of cityCountDistribution
                for (KeyValue kv : r.list()) {
                	year2009.setValue(Bytes.toString(kv.getValue()));
                	year2009.setLabel(Bytes.toString(kv.getRow()));
                	
                	System.out.println(year2009.getLabel()+":"+year2009.getValue());
                }
                year2009s.add(year2009);
            }
            return year2009s;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return year2009s;
		} finally {
            rs.close();
            HBaseConn.hTableClose(table);
        }
	}

}

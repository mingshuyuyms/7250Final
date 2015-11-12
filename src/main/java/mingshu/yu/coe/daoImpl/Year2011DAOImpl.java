package mingshu.yu.coe.daoImpl;

import java.io.IOException;
import java.util.ArrayList;

import mingshu.yu.coe.HBaseConn;
import mingshu.yu.coe.dao.Year2011DAO;
import mingshu.yu.coe.domain.Year2011;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Repository;

@Repository("Year2011")
public class Year2011DAOImpl implements Year2011DAO {

	@Override
	public ArrayList<Year2011> listAll() {
		// TODO Auto-generated method stub
		ArrayList<Year2011> year2011s = new ArrayList<Year2011>();
		Scan scan = new Scan();
		ResultScanner rs = null;
        HTable table = null;
        
        try {
			table = new HTable(HBaseConn.getConf(), Bytes.toBytes("month_third_year"));
            rs = table.getScanner(scan);
            for (Result r : rs) {
            	Year2011 year2011 = new Year2011();
            	//assign fileds of cityCountDistribution
                for (KeyValue kv : r.list()) {
                	year2011.setValue(Bytes.toString(kv.getValue()));
                	year2011.setLabel(Bytes.toString(kv.getRow()));
                	
                	System.out.println(year2011.getLabel()+":"+year2011.getValue());
                }
                year2011s.add(year2011);
            }
            return year2011s;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return year2011s;
		} finally {
            rs.close();
            HBaseConn.hTableClose(table);
        }
	}

}

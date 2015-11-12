package mingshu.yu.coe.daoImpl;

import java.io.IOException;
import java.util.ArrayList;

import mingshu.yu.coe.HBaseConn;
import mingshu.yu.coe.dao.Year2010DAO;
import mingshu.yu.coe.domain.Year2010;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Repository;

@Repository("Year2010")
public class Year2010DAOImpl implements Year2010DAO {

	@Override
	public ArrayList<Year2010> listAll() {
		// TODO Auto-generated method stub
		ArrayList<Year2010> year2010s = new ArrayList<Year2010>();
		Scan scan = new Scan();
		ResultScanner rs = null;
        HTable table = null;
        
        try {
			table = new HTable(HBaseConn.getConf(), Bytes.toBytes("month_second_year"));
            rs = table.getScanner(scan);
            for (Result r : rs) {
            	Year2010 year2010 = new Year2010();
            	//assign fileds of cityCountDistribution
                for (KeyValue kv : r.list()) {
                	year2010.setValue(Bytes.toString(kv.getValue()));
                	year2010.setLabel(Bytes.toString(kv.getRow()));
                	
                	System.out.println(year2010.getLabel()+":"+year2010.getValue());
                }
                year2010s.add(year2010);
            }
            return year2010s;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return year2010s;
		} finally {
            rs.close();
            HBaseConn.hTableClose(table);
        }
	}

}

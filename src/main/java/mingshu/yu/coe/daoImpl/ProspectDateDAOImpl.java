package mingshu.yu.coe.daoImpl;

import java.io.IOException;
import java.util.ArrayList;

import mingshu.yu.coe.HBaseConn;
import mingshu.yu.coe.dao.ProspectDateDAO;
import mingshu.yu.coe.domain.ProspectDate;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Repository;

@Repository("ProspectDate")
public class ProspectDateDAOImpl implements ProspectDateDAO {

	@Override
	public ArrayList<ProspectDate> listAll() {
		// TODO Auto-generated method stub
		ArrayList<ProspectDate> prospectDates = new ArrayList<ProspectDate>();
		Scan scan = new Scan();
		ResultScanner rs = null;
        HTable table = null;
        
        try {
			table = new HTable(HBaseConn.getConf(), Bytes.toBytes("prospect_date_count_test"));
            rs = table.getScanner(scan);
            for (Result r : rs) {
            	ProspectDate prospectDate = new ProspectDate();
            	//assign fileds of cityCountDistribution
                for (KeyValue kv : r.list()) {
                	prospectDate.setCountp(Bytes.toInt(kv.getValue()));
                	
                	prospectDate.setDate(Bytes.toString(kv.getRow()));
                	
                	System.out.println(prospectDate.getDate()+":"+prospectDate.getCountp());
                }
                prospectDates.add(prospectDate);
            }
            return prospectDates;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return prospectDates;
		} finally {
            rs.close();
            HBaseConn.hTableClose(table);
        }
	}

}

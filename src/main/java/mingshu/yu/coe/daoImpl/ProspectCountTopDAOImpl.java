package mingshu.yu.coe.daoImpl;

import java.io.IOException;
import java.util.ArrayList;

import mingshu.yu.coe.HBaseConn;
import mingshu.yu.coe.dao.ProspectCountTopDAO;
import mingshu.yu.coe.domain.ProspectCountTop;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Repository;

@Repository("ProspectCountTop")
public class ProspectCountTopDAOImpl implements ProspectCountTopDAO {

	@Override
	public ArrayList<ProspectCountTop> listAll() {
		// TODO Auto-generated method stub
		ArrayList<ProspectCountTop> prospectCountTops = new ArrayList<ProspectCountTop>();
		Scan scan = new Scan();
		ResultScanner rs = null;
        HTable table = null;
        
        try {
			table = new HTable(HBaseConn.getConf(), Bytes.toBytes("prospect_count_table_test"));
            rs = table.getScanner(scan);
            for (Result r : rs) {
            	ProspectCountTop prospectCountTop = new ProspectCountTop();
            	//assign fileds of cityCountDistribution
                for (KeyValue kv : r.list()) {
                	prospectCountTop.setLabel(Bytes.toString(kv.getRow()));
                	prospectCountTop.setValue(Bytes.toString(kv.getValue()));
                	
                	
                	System.out.println(prospectCountTop.getLabel()+":"+prospectCountTop.getValue());
                }
                prospectCountTops.add(prospectCountTop);
            }
            return prospectCountTops;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return prospectCountTops;
		} finally {
            rs.close();
            HBaseConn.hTableClose(table);
        }
	}

}

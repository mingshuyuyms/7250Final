package mingshu.yu.coe.daoImpl;

import java.io.IOException;
import java.util.ArrayList;

import mingshu.yu.coe.HBaseConn;
import mingshu.yu.coe.dao.P15yP16nDAO;
import mingshu.yu.coe.domain.P15yP16n;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Repository;
@Repository("P15yP16n")
public class P15yP16nDAOImpl implements P15yP16nDAO {

	@Override
	public ArrayList<P15yP16n> listAll() {
		// TODO Auto-generated method stub
		ArrayList<P15yP16n> p15yP16ns = new ArrayList<P15yP16n>();
		Scan scan = new Scan();
		ResultScanner rs = null;
        HTable table = null;
        
        try {
			table = new HTable(HBaseConn.getConf(), Bytes.toBytes("p15y_p16n_test"));
            rs = table.getScanner(scan);
            for (Result r : rs) {
            	P15yP16n p15yP16n = new P15yP16n();
            	//assign fileds of cityCountDistribution
                for (KeyValue kv : r.list()) {
                	p15yP16n.setValue(Bytes.toString(kv.getValue()));
                	p15yP16n.setLabel(Bytes.toString(kv.getRow()));
                	
                	System.out.println(p15yP16n.getLabel()+":"+p15yP16n.getValue());
                }
                p15yP16ns.add(p15yP16n);
            }
            return p15yP16ns;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return p15yP16ns;
		} finally {
            rs.close();
            HBaseConn.hTableClose(table);
        }
	}

}

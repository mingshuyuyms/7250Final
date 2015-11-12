package mingshu.yu.coe.daoImpl;

import java.io.IOException;
import java.util.ArrayList;

import mingshu.yu.coe.HBaseConn;
import mingshu.yu.coe.dao.RecommendationDAO;
import mingshu.yu.coe.domain.Recommendation;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Repository;

@Repository("Recommendation")
public class RecommendationDAOImpl implements RecommendationDAO {

	@Override
	public ArrayList<Recommendation> listAllByProject(String projectId) {
		// TODO Auto-generated method stub
		ArrayList<Recommendation> arrayList = new ArrayList<Recommendation>();
		Scan scan = new Scan();
		ResultScanner rs = null;
		HTable hTable=null;
		//System.out.println("indao");

		try {
			hTable = new HTable(HBaseConn.getConf(),
					Bytes.toBytes("recommendation_for_project"));
			rs = hTable.getScanner(scan);

			
			
			for (Result r : rs) {
				Recommendation recommendation = new Recommendation();
				for (KeyValue kv : r.list()) {
					
					//System.out.println(Bytes.toString(kv.getValue()));
					if (Bytes.toString(kv.getValue()).equals(projectId)) {
						recommendation.setProjectId(projectId);
						recommendation.setProspectId(Bytes.toString(kv
								.getRow()));
						arrayList.add(recommendation);
						System.out.println(recommendation.getProjectId() + ":"
								+ recommendation.getProspectId());

					}
				}

			}

			return arrayList;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return arrayList;
		} finally {
			HBaseConn.hTableClose(hTable);
		}
	}

}

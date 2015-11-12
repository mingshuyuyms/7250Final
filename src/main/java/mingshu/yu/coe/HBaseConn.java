package mingshu.yu.coe;



import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;


public class HBaseConn {
	
	static Configuration conf=null;
    static HBaseAdmin admin=null;
    
	public static Configuration getConf(){
		conf=HBaseConfiguration.create();
		//conf.set("hbase.zookeeper.quorum", "127.0.0.1");
		return conf;
	}
	
	public static HBaseAdmin getAdmin() throws MasterNotRunningException, ZooKeeperConnectionException, IOException{
		if(admin!=null){
			return admin;
		}else{
			return new HBaseAdmin(getConf());
		}
	}
	
	public static void deleteTable(String tableName) throws IOException{
		if(getAdmin().tableExists(tableName)){  
			getAdmin().disableTable(tableName);
			getAdmin().deleteTable(tableName);
	        System.out.println(tableName+" table has been deleted.");
	    }else{
	    	System.out.println(tableName+" table doesn't exist.");
	    }
	}
	
	public static void createTable(String tableName,String cfs[])throws Exception{   
	    if(getAdmin().tableExists(tableName)){  
	        System.out.println(tableName+" table exists.......");
	    }else{  
	        HTableDescriptor table=new HTableDescriptor(tableName);  
	        for(String cf:cfs){  
	            HColumnDescriptor colf=new HColumnDescriptor(cf);//column family name
	            table.addFamily(colf);//add to this table  
	        }  
	          
	        getAdmin().createTable(table);//create a table  
	        System.out.println("create table "+tableName+" successfully!");  
	    	}  
	}	
	
	public void insertRow(HTable table, String row,    
            String columnFamily, String column, String value) throws Exception {    
   
        Put put = new Put(Bytes.toBytes(row));    
        //parameters are：columnfamily, column, value   
        put.add(Bytes.toBytes(columnFamily), Bytes.toBytes(column),    
                Bytes.toBytes(value));   
        table.put(put);
        //System.out.println("data insert successfully!");  
    }
	
	public static void hTableClose(HTable table){
		try {
			table.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

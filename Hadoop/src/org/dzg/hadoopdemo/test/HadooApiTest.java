package org.dzg.hadoopdemo.test;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;


public class HadooApiTest {

	public static void main(String[] args) throws IOException {
	  
		Configuration conf=new Configuration();
		FileSystem fs=FileSystem.get(conf);
		
		
		HadooApiTest hat=new HadooApiTest();
		System.out.println("¼¯ÈºHomeDir£º"+hat.getHomeDir(fs));

	}

	
	
	
	
	private String getHomeDir(FileSystem fs){
		String homeDirString=fs.getHomeDirectory().toString();
		System.out.println(homeDirString);
		if(homeDirString.startsWith("file:")){
			return homeDirString.substring("file:".length());
		}
		return homeDirString.substring(fs.getUri().toString().length());
	}
	
	
	
}

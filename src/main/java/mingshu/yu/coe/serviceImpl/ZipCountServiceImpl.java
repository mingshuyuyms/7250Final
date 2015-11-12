package mingshu.yu.coe.serviceImpl;

import java.util.ArrayList;

import mingshu.yu.coe.dao.ZipCountDAO;
import mingshu.yu.coe.domain.ZipCount;
import mingshu.yu.coe.service.ZipCountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZipCountServiceImpl implements ZipCountService {

	@Autowired
	ZipCountDAO zipCountDAO;
	
	@Override
	public ArrayList<ZipCount> listAll() {
		// TODO Auto-generated method stub
		return zipCountDAO.listAll();
	}

}

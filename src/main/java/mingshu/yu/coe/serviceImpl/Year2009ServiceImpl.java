package mingshu.yu.coe.serviceImpl;

import java.util.ArrayList;

import mingshu.yu.coe.dao.Year2009DAO;
import mingshu.yu.coe.domain.Year2009;
import mingshu.yu.coe.service.Year2009Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Year2009ServiceImpl implements Year2009Service {

	@Autowired
	Year2009DAO year2009DAO;
	
	@Override
	public ArrayList<Year2009> listAll() {
		// TODO Auto-generated method stub
		return year2009DAO.listAll();
	}

}

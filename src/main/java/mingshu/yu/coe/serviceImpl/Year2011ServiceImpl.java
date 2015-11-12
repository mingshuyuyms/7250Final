package mingshu.yu.coe.serviceImpl;

import java.util.ArrayList;

import mingshu.yu.coe.dao.Year2011DAO;
import mingshu.yu.coe.domain.Year2011;
import mingshu.yu.coe.service.Year2011Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Year2011ServiceImpl implements Year2011Service {

	@Autowired
	Year2011DAO year2011DAO;
	
	@Override
	public ArrayList<Year2011> listAll() {
		// TODO Auto-generated method stub
		return year2011DAO.listAll();
	}

}

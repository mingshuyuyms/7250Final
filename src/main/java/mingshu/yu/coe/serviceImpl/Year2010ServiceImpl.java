package mingshu.yu.coe.serviceImpl;

import java.util.ArrayList;

import mingshu.yu.coe.dao.Year2010DAO;
import mingshu.yu.coe.domain.Year2010;
import mingshu.yu.coe.service.Year2010Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Year2010ServiceImpl implements Year2010Service {

	@Autowired
	Year2010DAO year2010DAO;
	
	@Override
	public ArrayList<Year2010> listAll() {
		// TODO Auto-generated method stub
		return year2010DAO.listAll();
	}

}

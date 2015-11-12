package mingshu.yu.coe.serviceImpl;

import java.util.ArrayList;

import mingshu.yu.coe.dao.CompareVectorMajorDAO;
import mingshu.yu.coe.domain.CompareVectorMajor;
import mingshu.yu.coe.service.CompareVectorMajorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompareVectorMajorServiceImpl implements CompareVectorMajorService {


	@Autowired
	CompareVectorMajorDAO compareVectorMajorDAO;
	
	@Override
	public ArrayList<CompareVectorMajor> listAll() {
		// TODO Auto-generated method stub
		return compareVectorMajorDAO.listAll();
	}

}

package mingshu.yu.coe.serviceImpl;

import java.util.ArrayList;

import mingshu.yu.coe.dao.CompareVectorMinorDAO;
import mingshu.yu.coe.domain.CompareVectorMinor;
import mingshu.yu.coe.service.CompareVectorMinorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompareVectorMinorServiceImpl implements CompareVectorMinorService {

	@Autowired
	CompareVectorMinorDAO compareVectorMinorDAO;
	@Override
	public ArrayList<CompareVectorMinor> listAll() {
		// TODO Auto-generated method stub
		return compareVectorMinorDAO.listAll();
	}

}

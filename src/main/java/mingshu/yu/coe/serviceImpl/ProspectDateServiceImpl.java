package mingshu.yu.coe.serviceImpl;

import java.util.ArrayList;

import mingshu.yu.coe.dao.ProspectDateDAO;
import mingshu.yu.coe.domain.ProspectDate;
import mingshu.yu.coe.service.ProspectDateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProspectDateServiceImpl implements ProspectDateService {

	@Autowired
	ProspectDateDAO prospectDateDAO;
	
	@Override
	public ArrayList<ProspectDate> listAll() {
		// TODO Auto-generated method stub
		return prospectDateDAO.listAll();
		
	}

}

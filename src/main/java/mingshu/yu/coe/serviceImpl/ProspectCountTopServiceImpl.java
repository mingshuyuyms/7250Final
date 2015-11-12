package mingshu.yu.coe.serviceImpl;

import java.util.ArrayList;

import mingshu.yu.coe.dao.ProspectCountTopDAO;
import mingshu.yu.coe.domain.ProspectCountTop;
import mingshu.yu.coe.service.ProspectCountTopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProspectCountTopServiceImpl implements ProspectCountTopService {

	@Autowired
	ProspectCountTopDAO prospectCountTopDAO;
	
	@Override
	public ArrayList<ProspectCountTop> listAll() {
		// TODO Auto-generated method stub
		return prospectCountTopDAO.listAll();
	}

}

package mingshu.yu.coe.serviceImpl;

import java.util.ArrayList;

import mingshu.yu.coe.dao.P15yP16nDAO;
import mingshu.yu.coe.domain.P15yP16n;
import mingshu.yu.coe.service.P15yP16nService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class P15yP16nServiceImpl implements P15yP16nService {

	@Autowired
	P15yP16nDAO p15yP16nDAO;
	
	
	@Override
	public ArrayList<P15yP16n> listAll() {
		// TODO Auto-generated method stub
		return p15yP16nDAO.listAll();
	}

}

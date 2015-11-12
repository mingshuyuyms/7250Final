package mingshu.yu.coe.serviceImpl;

import java.util.ArrayList;

import mingshu.yu.coe.dao.RecommendationDAO;
import mingshu.yu.coe.domain.Recommendation;
import mingshu.yu.coe.service.RecommendationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendationServiceImpl implements RecommendationService {

	@Autowired
	RecommendationDAO recommendationDAO;
	@Override
	public ArrayList<Recommendation> listAllByProject(String projectId) {
		// TODO Auto-generated method stub
		return recommendationDAO.listAllByProject(projectId);
	}

}

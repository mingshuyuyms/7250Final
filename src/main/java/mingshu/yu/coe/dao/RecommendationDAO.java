package mingshu.yu.coe.dao;

import java.util.ArrayList;

import mingshu.yu.coe.domain.Recommendation;

public interface RecommendationDAO {

	public ArrayList<Recommendation> listAllByProject(String projectId);
	
	
}

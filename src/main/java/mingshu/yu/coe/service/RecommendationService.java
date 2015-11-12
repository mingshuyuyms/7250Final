package mingshu.yu.coe.service;

import java.util.ArrayList;

import mingshu.yu.coe.domain.Recommendation;

public interface RecommendationService {

	public ArrayList<Recommendation> listAllByProject(String projectId);
}

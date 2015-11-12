package mingshu.yu.coe;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import mingshu.yu.coe.domain.CompareVectorMajor;
import mingshu.yu.coe.domain.CompareVectorMinor;
import mingshu.yu.coe.domain.P15yP16n;
import mingshu.yu.coe.domain.ProspectCountTop;
import mingshu.yu.coe.domain.ProspectDate;
import mingshu.yu.coe.domain.Recommendation;
import mingshu.yu.coe.domain.Year2009;
import mingshu.yu.coe.domain.Year2010;
import mingshu.yu.coe.domain.Year2011;
import mingshu.yu.coe.domain.ZipCount;
import mingshu.yu.coe.service.CompareVectorMajorService;
import mingshu.yu.coe.service.CompareVectorMinorService;
import mingshu.yu.coe.service.P15yP16nService;
import mingshu.yu.coe.service.ProspectCountTopService;
import mingshu.yu.coe.service.ProspectDateService;
import mingshu.yu.coe.service.RecommendationService;
import mingshu.yu.coe.service.Year2009Service;
import mingshu.yu.coe.service.Year2010Service;
import mingshu.yu.coe.service.Year2011Service;
import mingshu.yu.coe.service.ZipCountService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Autowired
	CompareVectorMajorService compareVectorMajorService;
	@Autowired
	CompareVectorMinorService compareVectorMinorService;
	@Autowired
	P15yP16nService p15yP16nService;
	@Autowired
	ProspectCountTopService prospectCountTopService;
	@Autowired
	ProspectDateService prospectDateService;
	@Autowired
	ZipCountService zipCountService;
	@Autowired
	Year2009Service year2009Service;
	@Autowired
	Year2010Service year2010Service;
	@Autowired
	Year2011Service year2011Service;
	
	@Autowired 
	RecommendationService recommendationService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping(value = "compareVectorMajorService", method = RequestMethod.GET)
	public @ResponseBody List<CompareVectorMajor> listCompareVectorMajor(Locale locale, Model model) {
		logger.info("list compareVectorMajorService...");
		
		ArrayList<CompareVectorMajor> allList = compareVectorMajorService.listAll();
		for(CompareVectorMajor cvm :allList){
			System.out.println(cvm);
		}

		return allList;
	}
	
	@RequestMapping(value = "compareVectorMinorService", method = RequestMethod.GET)
	public @ResponseBody List<CompareVectorMinor> listCompareVectorMinor(Locale locale, Model model) {
		logger.info("list compareVectorMinorService...");
		
		ArrayList<CompareVectorMinor> allList = compareVectorMinorService.listAll();
		for(CompareVectorMinor cvm :allList){
			System.out.println(cvm);
		}

		return allList;
	}
	
	@RequestMapping(value = "p15yP16nService", method = RequestMethod.GET)
	public @ResponseBody List<P15yP16n> listP15yP16n(Locale locale, Model model) {
		logger.info("list P15yP16nService...");
		
		ArrayList<P15yP16n> allList = p15yP16nService.listAll();
		for(P15yP16n cvm :allList){
			System.out.println(cvm);
		}

		return allList;
	}
	@RequestMapping(value = "ProspectDateService", method = RequestMethod.GET)
	public @ResponseBody List<ProspectDate> listProspectDate(Locale locale, Model model) {
		logger.info("list ProspectDateService...");
		
		ArrayList<ProspectDate> allList = prospectDateService.listAll();
		for(ProspectDate cvm :allList){
			System.out.println(cvm);
		}

		return allList;
	}
	
	
	@RequestMapping(value = "prospectCountTopService", method = RequestMethod.GET)
	public @ResponseBody List<ProspectCountTop> listProspectCountTop(Locale locale, Model model) {
		logger.info("list prospectCountTopService...");
		
		ArrayList<ProspectCountTop> allList = prospectCountTopService.listAll();
		for(ProspectCountTop cvm :allList){
			System.out.println(cvm);
		}

		return allList;
	}
	@RequestMapping(value = "ZipCountService", method = RequestMethod.GET)
	public @ResponseBody List<ZipCount> listZipCount(Locale locale, Model model) {
		logger.info("list ZipCountService...");
		
		ArrayList<ZipCount> allList = zipCountService.listAll();
//		for(ZipCount cvm :allList){
//			System.out.println(cvm);
//		}

		return allList;
	}
	@RequestMapping(value = "year2011Service", method = RequestMethod.GET)
	public @ResponseBody List<Year2011> list2011MonthCount(Locale locale, Model model) {
		logger.info("list ");
		
		ArrayList<Year2011> allList = year2011Service.listAll();
		for(Year2011 cvm :allList){
			System.out.println(cvm);
		}

		return allList;
	}
	@RequestMapping(value = "listRecommService", method = RequestMethod.GET)
	public @ResponseBody List<Recommendation> listRecomm(@RequestParam String projectId, Locale locale, Model model) {
		logger.info("list listRecommendationService...");
		
		ArrayList<Recommendation> allList = recommendationService.listAllByProject(projectId);
		for(Recommendation cvm :allList){
			System.out.println(cvm);
		}

		return allList;
	}
	
	@RequestMapping(value = "year2010Service", method = RequestMethod.GET)
	public @ResponseBody List<Year2010> list2010MonthCount(Locale locale, Model model) {
		logger.info("list ");
		
		ArrayList<Year2010> allList = year2010Service.listAll();
		for(Year2010 cvm :allList){
			System.out.println(cvm);
		}

		return allList;
	}
	@RequestMapping(value = "year2009Service", method = RequestMethod.GET)
	public @ResponseBody List<Year2009> list2009MonthCount(Locale locale, Model model) {
		logger.info("list ");
		
		ArrayList<Year2009> allList = year2009Service.listAll();
		for(Year2009 cvm :allList){
			System.out.println(cvm);
		}

		return allList;
	}
	
	
}

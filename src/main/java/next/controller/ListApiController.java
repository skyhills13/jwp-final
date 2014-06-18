package next.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.QuestionDao;
import next.model.Question;

import com.google.gson.Gson;

import core.mvc.Controller;

public class ListApiController implements Controller {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		
		QuestionDao questionDao = new QuestionDao();
		List<Question> questions;
		questions = questionDao.findAll();

//		List<Map<String, Question>> questionList = new ArrayList<Map<String, Question>>();
//
//		for ( int i = 0, i < questions.size() ; ++i){
//			
//		}
		out.println(gson.toJson(questions));
		return "api";
	}
}

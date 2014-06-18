package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import next.dao.QuestionDao;
import next.model.Question;
import core.mvc.Controller;
import core.mvc.FrontController;

public class SaveController implements Controller {

	private static final Logger logger = LoggerFactory.getLogger(FrontController.class);

	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("^^^^^^^^^^into execute of SaveController");
		String writer = request.getParameter("writer") ;
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		QuestionDao questionDao = new QuestionDao();
		Question question = new Question(writer, title, contents);
		
		questionDao.insert(question);

		return "redirect:/list.next";
	}

}

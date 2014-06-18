package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.model.Answer;
import next.model.Question;
import core.mvc.Controller;
import core.mvc.FrontController;

public class CommentController implements Controller {

	private static final Logger logger = LoggerFactory.getLogger(FrontController.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("@@@@@@@@@@@into execute of CommentController");
		QuestionDao questionDao = new QuestionDao();
		AnswerDao answerDao = new AnswerDao();
		Question question;
		
		long questionId = Long.parseLong(request.getParameter("questionId"));
		String writer = request.getParameter("writer");
		String contents = request.getParameter("contents");

		Answer answer = new Answer(writer, contents, questionId);
		answerDao.insert(answer);
		
		question = questionDao.findById(questionId);
		questionDao.updateCountOfComment(question);

		return "api";
	}
	
}

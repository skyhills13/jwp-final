package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.model.Answer;
import next.model.Question;
import core.mvc.Controller;

public class CommentController implements Controller {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		QuestionDao questionDao = new QuestionDao();
		AnswerDao answerDao = new AnswerDao();
		Question question;
		Answer answer;
		
		request.getp
		
		long questionId = Long.parseLong(request.getParameter("questionId"));
		question = questionDao.findById(questionId);
		questionDao.updateCountOfComment(question);

		
		return "redirect:/";
	}
	
}

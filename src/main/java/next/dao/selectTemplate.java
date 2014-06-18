//package next.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import next.model.Question;
//import next.support.db.ConnectionManager;
//
//public abstract class selectTemplate {
//
//	private ConnectionManager conn;
//	
//	public selectTemplate(Connection conn) {
//		this.conn = conn;
//	}
//	
//	public List<Question> findAll() throws SQLException {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			con = ConnectionManager.getConnection();
//			String sql = createQueryForFindAll();
//			pstmt = con.prepareStatement(sql);
//
//			rs = pstmt.executeQuery();
//
//			List<Question> questions = new ArrayList<Question>();
//			Question question = null;
//			while (rs.next()) {
//				question = new Question(
//						rs.getLong("questionId"),
//						rs.getString("writer"),
//						rs.getString("title"),
//						null,
//						rs.getTimestamp("createdDate"),
//						rs.getInt("countOfComment"));
//				questions.add(question);
//			}
//
//			return questions;
//		} finally {
//			if (rs != null) {
//				rs.close();
//			}
//			if (pstmt != null) {
//				pstmt.close();
//			}
//			if (con != null) {
//				con.close();
//			}
//		}
//	}
//	
//	abstract String createQueryForFindById();
//	abstract String createQueryForFindAll();
//	abstract void setValueForFindById (long questionId, PreparedStatement pstmt) throws SQLException;
//}

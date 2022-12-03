package com.crud.myapp.board;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	@Autowired
	JdbcTemplate jdbcTemplate ;
	public int insertBoard(BoardVO vo) {
		String sql = "insert into Week14BOARD (title, writer, category, content) values ("
				+ "'" + vo.getTitle() + "',"
				+ "'" + vo.getWriter() + "',"
				+ "'" + vo.getCategory() + "',"
				+ "'" + vo.getContent() + "')" ;
		return jdbcTemplate.update(sql) ;
	}

	// 글 삭제
	public int deleteBoard(int seq) {
		String sql = "delete from Week14BOARD where seq = " + seq ;
		return jdbcTemplate.update(sql) ;
	}

	public int updateBoard(BoardVO vo) {
		String sql = "update Week14BOARD set title = '" + vo.getTitle() + "',"
				+ " category = '" + vo.getCategory() + "',"
				+ " writer = '" + vo.getWriter() + "',"
				+ " content = '" + vo.getContent() + "' where seq=" + vo.getSeq() ;
		return jdbcTemplate.update(sql);
	}

	public BoardVO getBoard(int seq) {
		String sql = "select * from Week14BOARD where seq=" + seq ;
		return jdbcTemplate.queryForObject(sql, new BoardRowMapper()) ;
	}

	public List<BoardVO> getBoardList(){
		String sql = "select * from Week14BOARD order by regdate desc" ;
		return jdbcTemplate.query(sql, new BoardRowMapper()) ;
	}

}

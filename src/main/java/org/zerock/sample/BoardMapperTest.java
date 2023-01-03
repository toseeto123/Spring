package org.zerock.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.zerock.mapper.BoardMapper;

import com.zerock.domain.BoardVO;
//import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTest {
	@Autowired
	private BoardMapper mapper;
	
	//테스트 완료  
	public void testGetList() {
		mapper.getList().forEach(tbl_board ->log.info(tbl_board));
	}
	
	
	public void testInsert() {
		BoardVO board=new BoardVO();
		board.setTitle("새로작성하는글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
			mapper.insert(board);
		log.info(board);
	}
	
	//완료
	public void testRead() {
		BoardVO board = mapper.read(4);
		log.info(board);
	}
	
	//완
	public void testDelete() {
		log.info("delete count:" +mapper.delete(3));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(4);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("user100");
		int count=mapper.update(board);
		log.info("update count : " + count);
	}
}

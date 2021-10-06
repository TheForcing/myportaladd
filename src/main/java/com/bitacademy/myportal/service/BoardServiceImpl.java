package com.bitacademy.myportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.myportal.repository.BoardDao;
import com.bitacademy.myportal.repository.BoardVo;
@Service
public class BoardServiceImpl implements BoardService {
	@Override
	public boolean delete(long no) {
		int deletedCount = boardDaoImpl.delete(no);
		return deletedCount == 1;
	}

	@Autowired
	private BoardDao boardDaoImpl;

	@Override
	public List<BoardVo> getList() {
		List<BoardVo> list = boardDaoImpl.selectAll();
		return list;
	}

	@Override
	public BoardVo getContent(Long no) {
		BoardVo content = boardDaoImpl.getContent(no);
		return content;
	}

	@Override
	public boolean write(BoardVo vo) {
		int insertedCount = boardDaoImpl.insert(vo);
		return 1 == insertedCount;
	}

	@Override
	public boolean update(BoardVo vo) {
		int updatedCount = boardDaoImpl.update(vo);
		return updatedCount == 1;
	}

}
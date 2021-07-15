package co.kgggy.board.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.kgggy.board.service.BoardService;
import co.kgggy.board.serviceImpl.BoardServiceImpl;
import co.kgggy.board.vo.BoardVO;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private BoardService dao = new BoardServiceImpl();

	private void menuTitle() {
		System.out.println("🌞☁🌨🌦🌩🌞☁🌨🌦");
		System.out.println("<<오늘의 날씨 게시판>>");
		boardAll();
		System.out.println("-- 1. 게시글 조회 --");
		System.out.println("-- 2. 게시글 작성 --");
		System.out.println("-- 3. 게시글 삭제 --");
		System.out.println("-- 4. 시스템 종료 --");
		System.out.println("🌞☁🌨🌦🌩🌞☁🌨🌦");
		System.out.println("원하는 번호를 선택하세요>");
	}

	private void boardAll() {
		List<BoardVO> boards = new ArrayList<BoardVO>();
		boards = dao.boardSelectList();
		for(BoardVO board : boards) {
			System.out.println(board.toString());
		}
	}

	private void menuNo() {
		int menu;
		boolean b = false;
		do {
			menuTitle();

			switch (menu = sc.nextInt()) {
			case 1:
				boardSelect();
				break;
			case 2:
				boardWrite();
				break;
			case 3:
				boardDelete();
				break;
			case 4:
				b = true;
				System.out.println("게시판을 종료합니다.");
				break;
			}
		} while (!b);
	}

	private void boardSelect() {
		// TODO 게시글 하나 조회.

	}

	private void boardWrite() {
		// TODO 게시글 하나 작성.
		BoardVO vo = new BoardVO();
		System.out.println("입력하실 글 번호를 입력하세요>");
		vo.setBoardId(sc.next());
		sc.nextLine();
		System.out.println("작성자>");
		vo.setWriter(sc.next());
		sc.nextLine();
		System.out.println("제목>");
		vo.setTitle(sc.next());
		sc.nextLine();
		System.out.println("내용>");
		vo.setSubject(sc.next());

		int n = dao.boardWrite(vo);
		if (n != 0) {
			System.out.println("게시글이 작성되었습니다.");
		} else {
			System.out.println("게시글 작성에 실패하였습니다.");
		}

	}

	private void boardDelete() {
		// TODO 게시글 하나 삭제.
		BoardVO vo = new BoardVO();
		System.out.println("삭제하실 글 번호를 입력하세요>");
		vo.setBoardId(sc.next());
		sc.nextLine();
		int n = dao.boardDelete(vo);
		if (n != 0) {
			System.out.println("한 건 삭제되었습니다.");
		} else {
			System.out.println("삭제 실패하였습니다.");
		}
	}

	public void run() {
		menuNo();
		sc.close();
	}

}

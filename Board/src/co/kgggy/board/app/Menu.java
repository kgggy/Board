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
		boardAll();
		System.out.println("πβπ¨π¦π©πβπ¨π¦");
		System.out.println("<<μ€λμ λ μ¨ κ²μν>>");
		System.out.println("-- 1. κ²μκΈ μ‘°ν --");
		System.out.println("-- 2. κ²μκΈ μμ± --");
		System.out.println("-- 3. κ²μκΈ μ­μ  --");
		System.out.println("-- 4. μμ€ν μ’λ£ --");
		System.out.println("πβπ¨π¦π©πβπ¨π¦");
		System.out.println("μνλ λ²νΈλ₯Ό μ ννμΈμ>");
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
				System.out.println("κ²μνμ μ’λ£ν©λλ€.");
				break;
			}
		} while (!b);
	}

	private void boardSelect() {
		// TODO κ²μκΈ νλ μ‘°ν.
		BoardVO vo = new BoardVO();
		System.out.println("μ‘°ννμ€ κΈ λ²νΈλ₯Ό μλ ₯νμΈμ>");
		vo.setBoardId(sc.next());
		sc.nextLine();

		vo = dao.boardSelect(vo);
		System.out.println();
		System.out.println("<< λ΄μ© >>");
		System.out.println(vo.getSubject());
		System.out.println();
	}

	private void boardWrite() {
		// TODO κ²μκΈ νλ μμ±.
		BoardVO vo = new BoardVO();
		System.out.println("μλ ₯νμ€ κΈ λ²νΈλ₯Ό μλ ₯νμΈμ>");
		vo.setBoardId(sc.next());
		sc.nextLine();
		System.out.println("μμ±μ>");
		vo.setWriter(sc.next());
		sc.nextLine();
		System.out.println("μ λͺ©>");
		vo.setTitle(sc.nextLine()); //nextLineμΌλ‘ ν΄μ€μΌ μ€νμ΄μ€λ° μΈμ.
		System.out.println("λ΄μ©>");
		vo.setSubject(sc.nextLine());

		int n = dao.boardWrite(vo);
		if (n != 0) {
			System.out.println("κ²μκΈμ΄ μμ±λμμ΅λλ€.");
		} else {
			System.out.println("κ²μκΈ μμ±μ μ€ν¨νμμ΅λλ€.");
		}

	}

	private void boardDelete() {
		// TODO κ²μκΈ νλ μ­μ .
		BoardVO vo = new BoardVO();
		System.out.println("μ­μ νμ€ κΈ λ²νΈλ₯Ό μλ ₯νμΈμ>");
		vo.setBoardId(sc.next());
		sc.nextLine();
		int n = dao.boardDelete(vo);
		if (n != 0) {
			System.out.println("ν κ±΄ μ­μ λμμ΅λλ€.");
		} else {
			System.out.println("μ­μ  μ€ν¨νμμ΅λλ€.");
		}
	}

	public void run() {
		menuNo();
		sc.close();
	}

}

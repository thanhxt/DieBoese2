package dieBoese2;

import java.util.Scanner;

/**
 * 
 * @author Floris Wittner
 * @version V 0.2.1
 * @date 29.05
 *       <p>
 *       </
 *       <p>
 *       This class is subclass from {@link Player}
 *       <p>
 *       </
 *       <p>
 *       {@link HumanPlayer} can {@link #blockSpace(Board)} and
 *       {@link #makeMove(Board)}
 *       <p>
 *       </
 *       <p>
 *       It also has a getter Method {@link #getMyMove()}
 *
 */
public class HumanPlayer extends Player {
	private String myMove;

	/**
	 * 
	 * @param figure X or O
	 * @category constructor
	 */
	public HumanPlayer(char figure) {
		super(figure);
	}

	/**
	 * will be remove is just for testing here.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		HumanPlayer p1 = new HumanPlayer('X');
		System.out.println(p1.getMyMove());
	}

	/**
	 * 
	 * @return myMove
	 * @category getter
	 */
	public String getMyMove() {
		return myMove;
	}

	/**
	 * HumanPlayer block field {@link #myMove} If input is
	 * {@link board#isValidMove(myMove) not valid} he has to give a other input.
	 */
	@Override
	protected void blockSpace(Board board, Scanner sc) {
		System.out.println("Welches Feld wollen Sie blockieren?");
		myMove = sc.next();
		if (board.isValidMove(myMove)) {
			board.placeFigure(myMove, 'B');
		} else {
			System.out.println("Dieses Feld kann nicht blockiert werden.");
			blockSpace(board, sc);
		}
	}

	/**
	 * HumanPlayer set his figure at {@link #myMove} after it was read with
	 * {@link Game#readInput() }. If input is {@link board#isValidMove(myMove) not
	 * valid} he has to give a other input.
	 */
	@Override
	protected void makeMove(Board board, Scanner sc) {
		System.out.println("Auf welches Feld wollen Sie einen Stein legen?");
		myMove = sc.next();
		if (board.isValidMove(myMove)) {
			board.placeFigure(myMove, figure);
		} else {
			System.out.println("Sie k�nnen kein Stein auf dieses Feld legen.");
			makeMove(board, sc);
		}
	}
}
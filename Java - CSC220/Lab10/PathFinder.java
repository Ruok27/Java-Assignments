package lab10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;

public class PathFinder {

	public static void main(String[] args) {
		// solveMaze("turn.txt", "turnOut.txt");
	}

	public static void solveMaze(String inputFile, String outputFile) {

		BufferedReader input;
		try {
			input = new BufferedReader(new FileReader(inputFile));

			String[] dimension = input.readLine().split(" ");

			int height = Integer.parseInt(dimension[0]);
			int width = Integer.parseInt(dimension[1]);

			Node[][] maze = new Node[height][width];

			Node Start = null;
			Node Goal = null;

			for (int i = 0; i < height; i++) {
				String line = input.readLine();

				for (int j = 0; j < width; j++) {

					char symb = line.charAt(j);

					if (symb != 'X') {
						maze[i][j] = new Node(i, j, symb);

					}

					if (symb == 'S') {
						Start = maze[i][j];

					}

					if (symb == 'G') {

						Goal = maze[i][j];
					}

				}
			}

			printMaze(maze, System.out);

			Queue<Node> Q = new LinkedList<Node>();

			Start.setVisited(true);

			Q.add(Start);

			// if wanted to move diagonally

			// int dx[] = new int[] {-1, 1, -1, 1, 0, -1, 0, 1};
			// int dy[] = new int[] {-1, -1, 1, 1, 1, 0, -1, 0};
			// if wanted to change behavior like prioritize wall hugging or take less turns then 
			//pair order should be changed 
			int dx[] = new int[] { 0, -1, 1, 0 };
			int dy[] = new int[] { 1, 0, 0, -1 };

			while (!Q.isEmpty()) {

				Node current = Q.remove();

				if (current.equals(Goal))
					break;

				for (int i = 0; i < 4; i++) {
					int x = current.getRow() + dx[i];
					int y = current.getColumn() + dy[i];

					if (x >= height || y >= width || x < 0 || y < 0) {

						continue;

					}

					Node next = maze[x][y];

					if (next != null && !next.getVisited()) {

						next.setVisited(true);
						next.setParent(current);
						Q.add(next);

					}

				}

			}

			if (Goal.getParent() == null) {
				printMaze(maze, new PrintStream(outputFile));
				return;

			}

			Node Current = Goal.getParent();

			while (Current != Start) {
				Current.setContent('.');
				Current = Current.getParent();
			}
			printMaze(maze, System.out);
			printMaze(maze, new PrintStream(outputFile));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void printMaze(Node[][] maze, PrintStream out) {

		out.println(maze.length + " " + (maze.length > 0 ? maze[0].length : "0"));

		for (int i = 0; i < maze.length; i++) {

			for (int j = 0; j < maze[i].length; j++) {

				if (maze[i][j] == null) {

					out.print('X');
				}

				else {
					out.print(maze[i][j].getContent());
				}

			}
			out.println();
		}

	}

}
